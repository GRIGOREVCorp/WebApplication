package Controller;

import dao.OrderDAO;
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
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet(name = "AddOrderServlet")
public class AddOrderServlet extends HttpServlet {
    Factory factory = Factory.getInstance();
    OrderDAO orderDAO = null;
    List<Object> statusOrder=null;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        request.getRequestDispatcher("/MyOrderServlet").forward(request,response);
    }

    public void add(OrdercustomerEO ordercustomerEO,
                    OrderhistoryEO orderhistoryEO,
                    OrderstatusEO orderstatusEO,
                    HttpServletRequest request) throws SQLException {

        factory.orderDAO=null;
        orderDAO = factory.getOrderDAOforStatus();
        statusOrder=orderDAO.viewData();
        orderstatusEO = (OrderstatusEO) statusOrder.get(0);

        ordercustomerEO.setOrderstatusEO(orderstatusEO);
        ordercustomerEO.setDate(new java.sql.Date( (new java.util.Date()).getTime()));

        orderhistoryEO.setPlaceOfIssue(request.getParameter("poi"));
        orderhistoryEO.setDelivery(request.getParameter("d"));
        orderhistoryEO.setDeliveryAddress(request.getParameter("da"));
        orderhistoryEO.setOrdercustomerEO(ordercustomerEO);
        orderhistoryEO.setOrderstatusEO(orderstatusEO);
    }
}
