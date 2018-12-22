package daoImpl;

import dao.OrderDAO;
import entity.OrdercustomerEO;
import entity.OrderhistoryEO;
import entity.OrderstatusEO;
import org.hibernate.Session;
import utils.HibernateUtil;
import org.hibernate.*;
import java.sql.SQLException;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    public int createOrder(OrdercustomerEO ordercustomerEO,
                           OrderhistoryEO orderhistoryEO) throws SQLException {
        int id=0;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            id = (Integer) session.save(ordercustomerEO);
            session.persist(orderhistoryEO);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if((session!=null)&&(session.isOpen())) session.close();
        }
        return id;
    }

    public void deleteData(int id) throws SQLException {
        Object obj = getData(id);
        OrdercustomerEO ordercustomerEO = null;
        if (obj instanceof OrdercustomerEO)
            ordercustomerEO = (OrdercustomerEO) obj;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(ordercustomerEO);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("order not found");
            e.printStackTrace();
        } finally {
            if((session!=null)&&(session.isOpen())) session.close();
        }
    }

    public List<Object> viewData() throws SQLException {
        List<Object> orders = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            orders = session.createCriteria(OrdercustomerEO.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if((session!=null)&&(session.isOpen())) session.close();
        }
        return orders;
    }

    public Object getData(int id) throws SQLException {
        OrdercustomerEO ordercustomerEO = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            ordercustomerEO = (OrdercustomerEO) session.load(OrdercustomerEO.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if((session!=null)&&(session.isOpen())) session.close();
        }
        return ordercustomerEO;
    }

    public List<Object> viewQuery(int id) throws SQLException {
        List<Object> orders = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query result = session.createQuery("from OrdercustomerEO c where c.id=:inId");
            result.setParameter("inId", id);
            orders = result.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if((session!=null)&&(session.isOpen())) session.close();
        }
        return orders;
    }
}
