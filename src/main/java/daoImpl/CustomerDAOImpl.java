package daoImpl;

import dao.CustomerDAO;
import entity.CustomerEO;
import org.hibernate.*;
import utils.HibernateUtil;

import java.sql.SQLException;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    public int createCustomer(CustomerEO customerEO) throws SQLException {
        int id=0;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            id = (Integer) session.save(customerEO);
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
        CustomerEO customerEO = null;
        if (obj instanceof CustomerEO)
            customerEO = (CustomerEO) obj;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(customerEO);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("customer not found");
            e.printStackTrace();
        } finally {
            if((session!=null)&&(session.isOpen())) session.close();
        }
    }

    public List<Object> viewData() throws SQLException {
        List<Object> customers = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            customers = session.createCriteria(CustomerEO.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if((session!=null)&&(session.isOpen())) session.close();
        }
        return customers;
    }

    public Object getData(int id) throws SQLException {
        CustomerEO customerEO = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            customerEO = (CustomerEO) session.load(CustomerEO.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if((session!=null)&&(session.isOpen())) session.close();
        }
        return customerEO;
    }

    public List<Object> viewQuery(String login, String password) throws SQLException {
        List<Object> customers = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query result = session.createQuery("from CustomerEO c where c.login=:inLogin and c.password=:inPassword");
            result.setParameter("inLogin", login);
            result.setParameter("inPassword", password);
            customers = result.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if((session!=null)&&(session.isOpen())) session.close();
        }
        return customers;
    }
}
