package Controller;

import dao.CustomerDAO;
import utils.Factory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AuthorizationServlet")
public class AuthorizationServlet extends HttpServlet {
    List<Object> customers =null;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Factory factory = Factory.getInstance();
        CustomerDAO customerDAO = factory.getCustomerDAO();
        try {
            customers = customerDAO.viewQuery((String) request.getParameter("login"), (String) request.getParameter("password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html;charset=UTF-8");
        if((customers!=null)&&(customers.size()>0))
            request.getRequestDispatcher("Welcom.jsp").include(request, response);
        else
            request.getRequestDispatcher("Authorization.jsp?notFound=true").include(request, response);
    }
}
