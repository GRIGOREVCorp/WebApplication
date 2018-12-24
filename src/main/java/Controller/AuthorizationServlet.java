package Controller;

import Exceptions.NullParameterException;
import dao.CustomerDAO;
import entity.CustomerEO;
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
    private int cusId=0;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Factory factory = Factory.getInstance();
        CustomerDAO customerDAO = factory.getCustomerDAO();
        try {
            if((request.getParameter("login")=="")||(request.getParameter("password")=="")) throw new NullParameterException();
            try {
                customers = customerDAO.viewQuery((String) request.getParameter("login"), (String) request.getParameter("password"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            response.setContentType("text/html;charset=UTF-8");
            if ((customers != null) && (customers.size() > 0)) {
                cusId=((CustomerEO)customers.get(0)).getId();
                request.getRequestDispatcher("Welcom.jsp?cusId="+cusId).include(request, response);
            }
            else
                request.getRequestDispatcher("Authorization.jsp?notFound=true").include(request, response);
        }catch (NullParameterException ex) {
            ex.printStackTrace();
            request.getRequestDispatcher("Authorization.jsp?notFound=true").include(request, response);
        }
    }
}
