import dao.OrderDAO;
import utils.Factory;

import java.sql.SQLException;
import java.util.*;

public class Main {
    static Factory factory = Factory.getInstance();
    static OrderDAO orderDAO = null;
    static List<Object> orders = null;
    private static int cusId=0;

    public static void main(final String[] args) throws Exception {
        try {
            factory.orderDAO=null;
            orderDAO = factory.getOrderDAOforHistory();
            orders = orderDAO.viewQuery(1);
            System.out.println("af");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}