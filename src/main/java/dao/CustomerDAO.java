package dao;

import entity.CustomerEO;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDAO extends Data{
    public abstract int createCustomer(CustomerEO customerEO) throws SQLException;
    public abstract List<Object> viewQuery(String log, String pas) throws SQLException;
}
