package dao;

import entity.CustomerEO;
import entity.OrdercustomerEO;
import entity.OrderhistoryEO;
import entity.OrderstatusEO;

import java.sql.SQLException;
import java.util.List;

public interface OrderDAO extends Data {
    public abstract int createOrder(OrdercustomerEO oc, OrderhistoryEO oh) throws SQLException;
    public abstract List<Object> viewQuery(int id) throws SQLException;
}
