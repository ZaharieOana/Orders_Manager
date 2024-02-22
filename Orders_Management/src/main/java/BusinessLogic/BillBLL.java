package BusinessLogic;

import DataAccess.BillDAO;
import Model.Bills;

import java.util.ArrayList;

public class BillBLL {
    private final BillDAO billDAO;
    public BillBLL(){
        billDAO = new BillDAO();
    }
    public Bills insertBill(Bills b){
        return billDAO.insert(b);
    }
    public ArrayList<Bills> findAllBills(){
        return billDAO.findAll();
    }
}
