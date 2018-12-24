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
    private int cusId=0;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        cusId= Integer.parseInt((String)request.getParameter("cusId"));
        response.setContentType("text/html;charset=UTF-8");
        try {
            factory.orderDAO=null;
            orderDAO = factory.getOrderDAOforHistory();
            orders = orderDAO.viewQuery(cusId);
            System.out.println("af");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("orders", orders);
        request.getRequestDispatcher("ShowOrder.jsp?notParameter="+request.getParameter("notParameter")+ "&cusId="+cusId).forward(request,response);
    }
}
