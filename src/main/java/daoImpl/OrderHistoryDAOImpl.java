package daoImpl;

import entity.OrderhistoryEO;
import org.hibernate.Session;
import utils.HibernateUtil;

import java.sql.SQLException;
import java.util.List;

public class OrderHistoryDAOImpl extends OrderDAOImpl {
    @Override
    public List<Object> viewData() throws SQLException {
        List<Object> historyOrder = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            historyOrder = session.createCriteria(OrderhistoryEO.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if((session!=null)&&(session.isOpen())) session.close();
        }
        return historyOrder;
    }
}
