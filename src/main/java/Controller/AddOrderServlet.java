package Controller;

import Exceptions.NullParameterException;
import dao.CustomerDAO;
import dao.OrderDAO;
import entity.CustomerEO;
import entity.OrdercustomerEO;
import entity.OrderhistoryEO;
import entity.OrderstatusEO;
import utils.Factory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import Exceptions.NullParameterException;

@WebServlet(name = "AddOrderServlet")
public class AddOrderServlet extends HttpServlet {
    Factory factory = Factory.getInstance();
    OrderDAO orderDAO = null;
    CustomerDAO customerDAO = null;
    List<Object> statusOrder=null;
    private int cusId=0;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        cusId=Integer.parseInt((String)request.getParameter("cusId"));
        String s = (String) request.getParameter("d");
        try {
            if ((request.getParameter("poi")=="") ||
                    (request.getParameter("d") == "") ||
                    (request.getParameter("da")==""))
                throw new NullParameterException();

            OrdercustomerEO ordercustomerEO = new OrdercustomerEO();
            OrderhistoryEO orderhistoryEO = new OrderhistoryEO();
            OrderstatusEO orderstatusEO = null;
            try {
                add(ordercustomerEO, orderhistoryEO, orderstatusEO, request);
                factory.orderDAO=null;
                orderDAO = factory.getOrderDAO();
                int id = orderDAO.createOrder(ordercustomerEO, orderhistoryEO);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            request.getRequestDispatcher("/MyOrderServlet?notParameter=false&cusId="+cusId).forward(request,response);
        } catch (NullParameterException ex) {
            ex.printStackTrace();
            request.getRequestDispatcher("/MyOrderServlet?notParameter=true&cusId="+cusId).forward(request,response);
        }
    }

    public void add(OrdercustomerEO ordercustomerEO,
                    OrderhistoryEO orderhistoryEO,
                    OrderstatusEO orderstatusEO,
                    HttpServletRequest request) throws SQLException{

            factory.orderDAO = null;
            orderDAO = factory.getOrderDAOforStatus();
            statusOrder = orderDAO.viewData();
            orderstatusEO = (OrderstatusEO) statusOrder.get(0);

            customerDAO = factory.getCustomerDAO();
            Object customerEO = customerDAO.getData(cusId);

            ordercustomerEO.setOrderstatusEO(orderstatusEO);
            ordercustomerEO.setCustomerEO((CustomerEO)customerEO);
            ordercustomerEO.setDate(new java.sql.Date((new java.util.Date()).getTime()));

            orderhistoryEO.setPlaceOfIssue(request.getParameter("poi"));
            orderhistoryEO.setDelivery(request.getParameter("d"));
            orderhistoryEO.setDeliveryAddress(request.getParameter("da"));
            orderhistoryEO.setOrdercustomerEO(ordercustomerEO);
            orderhistoryEO.setOrderstatusEO(orderstatusEO);
    }
}
