package DataAccess;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Connection.ConnectionFactory;


public class AbstractDAO<T> {
    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());
    private final Class<T> type;

    public AbstractDAO(Class<T> type) {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    /**
     * Metoda creeaza un query de SELECT
     * @param field este numele campului folosit in clauza WHERE. Daca este un string gol inseamna ca se selecteaza toata tabela
     * @return returneaza un string cu query-ul rezultat
     */
    private String createSelectQuery(String field){
        StringBuilder s = new StringBuilder();
        s.append("SELECT * FROM ");
        s.append(type.getSimpleName());
        if(!field.isEmpty())
            s.append(" WHERE ").append(field).append(" =?");
        return s.toString();
    }

    /**
     * Metoda genereaza un queri de INSERT
     * @return returneaza un string cu query-ul rezultat
     */
    private String createInsertQuery(){
        StringBuilder s = new StringBuilder();
        s.append("INSERT INTO ");
        s.append(type.getSimpleName());
        s.append(" (");
        for (Field field : type.getDeclaredFields()) {
            field.setAccessible(true);
            s.append(field.getName()).append(",");
        }
        s.deleteCharAt(s.length()-1);
        s.append(") VALUES (");
        for (Field field : type.getDeclaredFields())
            s.append("?,");
        s.deleteCharAt(s.length()-1);
        s.append(")");
        return s.toString();
    }

    /**
     * Metoda genereaza un query de UPDATE pntru un anumit element
     * @return returneaza un string cu query-ul rezultat
     */
    private String createUpdateQuery(){
        StringBuilder s = new StringBuilder();
        s.append("UPDATE ");
        s.append(type.getSimpleName());
        s.append(" SET ");
        for (Field field : type.getDeclaredFields()) {
            field.setAccessible(true);
            if (!field.getName().equals("id"))
                s.append(field.getName()).append("=").append("?").append(", ");
        }
        s.deleteCharAt(s.length()-2);
        s.append(" WHERE id=?");
        return s.toString();
    }

    /**
     * Metoda genereaza un query de DELETE a unui element
     * @return returneaza un string cu query-ul rezultat
     */
    private String createDeleteQuery(){
        StringBuilder s = new StringBuilder();
        s.append("DELETE FROM ");
        s.append(type.getSimpleName());
        s.append(" WHERE id=?");
        return s.toString();
    }

    /**
     * @return lista de obiecte ce se afla intr-o tebela
     */
    public ArrayList<T> findAll(){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery("");

        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            return (ArrayList<T>) createObjects(resultSet);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findAll " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    public T findById(int id){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery("id");
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            return createObjects(resultSet).get(0);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    private List<T> createObjects(ResultSet resultSet) {
        List<T> list = new ArrayList<T>();
        Constructor[] ctors = type.getDeclaredConstructors();
        Constructor ctor = null;
        for (int i = 0; i < ctors.length; i++) {
            ctor = ctors[i];
            if (ctor.getGenericParameterTypes().length == 0)
                break;
        }
        try {
            while (resultSet.next()) {
                ctor.setAccessible(true);
                T instance = (T)ctor.newInstance();
                for (Field field : type.getDeclaredFields()) {
                    String fieldName = field.getName();
                    Object value = resultSet.getObject(fieldName);
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }
                list.add(instance);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return list;
    }

    public T insert(T t) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement insertStatement = null;
        try{
            String query = createInsertQuery();
            insertStatement = connection.prepareStatement(query);
            int index=1;
            for (Field field : type.getDeclaredFields()){
                field.setAccessible(true);
                insertStatement.setObject(index, field.get((Object) t));
                index++;
            }
            insertStatement.executeUpdate();
            return t;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "DAO:insert " + e.getMessage());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    public T update(T t) {
        Connection connection = null;
        PreparedStatement statement = null;
        String query = createUpdateQuery();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            int id=0;
            int index = 1;
            for (Field field : type.getDeclaredFields()){
                field.setAccessible(true);
                if(field.getName().equals("id"))
                    id= (int) field.get((Object) t);
                else {
                    statement.setObject(index, field.get((Object) t));
                    index++;
                }
            }
            statement.setInt(index, id);
            statement.executeUpdate();
            return t;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:update " + e.getMessage());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }
    public boolean delete(int id){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createDeleteQuery();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();

            return true;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:delete " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return false;
    }
}
