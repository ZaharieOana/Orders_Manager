package DataAccess;

import Model.Orders;

public class OrderDAO extends AbstractDAO<Orders>{

    public OrderDAO() {
        super(Orders.class);
    }
}
