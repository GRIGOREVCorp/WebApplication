package Controller;

import dao.CustomerDAO;
import dao.Data;
import dao.OrderDAO;
import entity.CustomerEO;
import entity.OrdercustomerEO;
import entity.OrderhistoryEO;
import utils.Factory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "MyOrderServlet")
public class MyOrderServlet extends HttpServlet {
    Factory factory = Factory.getInstance();
    OrderDAO orderDAO = null;
    List<Object> orders = null;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            factory.orderDAO=null;
            orderDAO = factory.getOrderDAOforHistory();
            orders = orderDAO.viewData();
            System.out.println("af");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("orders", orders);
        request.getRequestDispatcher("ShowOrder.jsp").forward(request,response);
    }
}
