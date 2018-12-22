package daoImpl;

import dao.OrderDAO;
import entity.OrderstatusEO;
import org.hibernate.Session;
import utils.HibernateUtil;

import java.sql.SQLException;
import java.util.List;

public class OrderStatusDAOImpl extends OrderDAOImpl {

    @Override
    public List<Object> viewData() throws SQLException {
        List<Object> statusOrder = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            statusOrder = session.createCriteria(OrderstatusEO.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if((session!=null)&&(session.isOpen())) session.close();
        }
        return statusOrder;
    }
}
