package BusinessLogic;

import BusinessLogic.Validators.EmailValidator;
import BusinessLogic.Validators.Validator;
import DataAccess.ClientDAO;
import Model.Clients;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ClientBLL {
    private final ArrayList<Validator<Clients>> validators;
    private final ClientDAO clientDAO;
    public ClientBLL(){
        validators=new ArrayList<>();
        validators.add(new EmailValidator());

        clientDAO=new ClientDAO();
    }
    public Clients findClientById(int id){
        Clients cl = clientDAO.findById(id);
        if(cl==null){
            throw new NoSuchElementException("The client with id =" + id + " was not found!");
        }
        return cl;
    }
    public Clients insertClient(Clients client){
        for(Validator<Clients> v : validators)
            v.validate(client);
        return clientDAO.insert(client);
    }
    public ArrayList<Clients> findAllClients(){
        ArrayList<Clients> list = clientDAO.findAll();
        if(list.isEmpty()){
            System.out.println("No elements in table Clients");
        }
        return list;
    }
    public Clients updateClient(Clients client){
        Clients cl = clientDAO.update(client);
        if(cl==null){
            throw new NoSuchElementException("The client couldn't be updated!");
        }
        return cl;
    }
    public boolean deleteClient(int id){
        boolean del = clientDAO.delete(id);
        if(!del){
            throw new NoSuchElementException("The client couldn't be deleted!");
        }
        return del;
    }
}
