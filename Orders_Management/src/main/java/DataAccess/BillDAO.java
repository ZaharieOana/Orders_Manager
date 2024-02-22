package DataAccess;

import Model.Bills;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import Connection.ConnectionFactory;

public class BillDAO {
    protected static final Logger LOGGER = Logger.getLogger(BillDAO.class.getName());

    /**
     * Pentru fiecare element al tabelei bills se creeaza cate un obiect de tipul Bills, pentru a avea acces la toate elementele tabelei
     * @return lista de Bills
     */
    public ArrayList<Bills> findAll(){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = "SELECT * FROM bills";
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            ArrayList<Bills> list = new ArrayList<>();
            while (resultSet.next()) {
                list.add(new Bills(resultSet.getInt(1), resultSet.getInt(2)));
            }
            return list;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,"Bills DAO:findAll " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * Face inserarea unui obiect de tip Bills ]n tabela corespunzatoare
     * @param b obiectul inserat
     * @return daca inserarea s-a realizat cu succes se returneaza obictul inserat, altfel se returneaza null
     */
    public Bills insert(Bills b) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement insertStatement = null;
        try{
            String query = "INSERT INTO bills (id, sum) VALUES (?,?)";
            insertStatement = connection.prepareStatement(query);
            insertStatement.setInt(1,b.id());
            insertStatement.setInt(2,b.sum());
            insertStatement.executeUpdate();
            return b;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "DAO:insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(connection);
        }
        return null;
    }
}
