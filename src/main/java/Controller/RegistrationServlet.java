package Controller;

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

@WebServlet(name = "AuthorizationServlet")
public class RegistrationServlet extends HttpServlet {
    private String login,
                   password,
                   firstName,
                   lastName,
                   middleName;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Factory factory = Factory.getInstance();
        CustomerDAO customerDAO = factory.getCustomerDAO();

        CustomerEO addCustomer = new CustomerEO();
        addCustomer(addCustomer,request);
        int id = 0;
        try {
            id = customerDAO.createCustomer(addCustomer);
        } catch (SQLException e) { e.printStackTrace(); }
        response.setContentType("text/html;charset=UTF-8");
        if(id>0)
            request.getRequestDispatcher("Authorization.jsp?notFound=false").include(request, response);
        else
            request.getRequestDispatcher("NotFound.jsp").include(request, response);
    }

    public void addCustomer(CustomerEO customerEO, HttpServletRequest request) {
        customerEO.setLogin(request.getParameter("login"));
        customerEO.setPassword(request.getParameter("password"));
        customerEO.setFirstName(request.getParameter("firstName"));
        customerEO.setLastName(request.getParameter("lastName"));
        customerEO.setMiddleName(request.getParameter("middleName"));
    }
}
