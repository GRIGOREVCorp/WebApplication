package utils;

import dao.CustomerDAO;
import dao.OrderDAO;
import daoImpl.CustomerDAOImpl;
import daoImpl.OrderDAOImpl;
import daoImpl.OrderHistoryDAOImpl;
import daoImpl.OrderStatusDAOImpl;
import entity.OrdercustomerEO;
import entity.OrderhistoryEO;
import entity.OrderstatusEO;

public class Factory {
    public static Factory instance = new Factory();

    public CustomerDAO customerDAO;
    public OrderDAO orderDAO;

    private Factory() {}

    public static Factory getInstance() {
        return instance;
    }

    public CustomerDAO getCustomerDAO() {
        if(customerDAO == null) customerDAO = new CustomerDAOImpl();
        return customerDAO;
    }

    public OrderDAO getOrderDAO() {
        if(orderDAO == null)
            orderDAO = new OrderDAOImpl();
        return orderDAO;
    }

    public OrderDAO getOrderDAOforStatus() {
        if(orderDAO == null)
            orderDAO=new OrderStatusDAOImpl();
        return orderDAO;
    }

    public OrderDAO getOrderDAOforHistory() {
        if(orderDAO == null)
            orderDAO=new OrderHistoryDAOImpl();
        return orderDAO;
    }
}
