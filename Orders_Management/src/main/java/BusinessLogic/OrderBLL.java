package BusinessLogic;

import DataAccess.OrderDAO;
import Model.Orders;

import java.util.ArrayList;

public class OrderBLL {
    private final OrderDAO orderDAO;
    public OrderBLL(){
        orderDAO=new OrderDAO();
    }
    public Orders insertOrders(Orders client){
        return orderDAO.insert(client);
    }
    public ArrayList<Orders> findAllOrders(){
        ArrayList<Orders> list = orderDAO.findAll();
        if(list.isEmpty()){
            System.out.println("No elements in table Clients");
        }
        return list;
    }
}
