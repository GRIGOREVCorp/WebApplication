package daoImpl;

import entity.CustomerEO;
import entity.OrdercustomerEO;
import entity.OrderhistoryEO;
import org.hibernate.Query;
import org.hibernate.Session;
import utils.HibernateUtil;

import java.sql.SQLException;
import java.util.ArrayList;
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

    @Override
    public List<Object> viewQuery(int id) throws SQLException {
        List<Object> customer = null;
        List<OrdercustomerEO> listOrderCusEO=null;
        List<Object> ordersCustomer = null;
        List<OrderhistoryEO> listOrderHisEO=null;
        List<Object> historyOrders = null;
        List<Object> historyCustomer = new ArrayList<Object>();
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();

            Query result = session.createQuery("from CustomerEO cus where cus.id=:inId");
            result.setParameter("inId", id);
            customer = result.list();
            Query result2 = session.createQuery("from OrdercustomerEO");
            ordersCustomer = result2.list();
            Query result3 = session.createQuery("from OrderhistoryEO");
            historyOrders = result3.list();

            listOrderCusEO=((CustomerEO)customer.get(0)).getOrders();

            for(OrdercustomerEO orderC : listOrderCusEO) {
                for(Object orderQ : ordersCustomer) {
                    if(compere(orderQ,orderC)) {
                        listOrderHisEO=(orderC.getHistory());
                        for(OrderhistoryEO historyO : listOrderHisEO) {
                            for(Object historyQ : historyOrders) {
                                if(compere(historyQ,historyO)) {
                                    historyCustomer.add(historyQ);
                                }
                            }
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if((session!=null)&&(session.isOpen())) session.close();
        }
        return historyCustomer;
    }

    public boolean compere(Object o, Object o2) {
        boolean result=false;
        if(o instanceof OrdercustomerEO) {
            if (((OrdercustomerEO)o).equals((OrdercustomerEO)o2)) result=true;
            else result=false;
        }
        if(o instanceof OrderhistoryEO) {
            if (((OrderhistoryEO)o).equals((OrderhistoryEO)o2)) {
                result=true;
                System.out.println();
            }
            else result=false;
        }
        return result;
    }
}
