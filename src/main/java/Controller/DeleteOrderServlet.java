package Controller;

import dao.OrderDAO;
import utils.Factory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "DeleteOrderServlet")
public class DeleteOrderServlet extends HttpServlet {
    Factory factory = Factory.getInstance();
    OrderDAO orderDAO = null;
    List<Object> orders = null;
    private int cusId=0;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        cusId= Integer.parseInt((String)request.getParameter("cusId"));
        try {
            factory.orderDAO=null;
            orderDAO = factory.getOrderDAO();
            orderDAO.deleteData(Integer.parseInt(request.getParameter("id")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/MyOrderServlet?notParameter=false&cusId="+cusId).forward(request,response);
    }
}
