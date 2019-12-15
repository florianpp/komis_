package pl.altkom.web.servlets;

import pl.altkom.web.dao.ClientDataDAO;
import pl.altkom.web.dao.ClientDataDAOImpl;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet(urlPatterns = "/delete_client")
public class DeleteClient extends HttpServlet {
    @Resource(name = "jdbc:komis")
    DataSource dataSource;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String client = req.getParameter("client");
        getServletContext().log(client);
        String firstName, lastName;
        String[] splittedClient = client.split(" ");
        firstName = splittedClient[0];
        lastName = splittedClient[1];
        ClientDataDAO dao = new ClientDataDAOImpl();
        try {
            dao.removeClient(firstName, lastName, dataSource);
            req.getRequestDispatcher("read_users").forward(req, resp);
        } catch (Exception e) {
            throw new ServletException("Cannot delete user", e);
        }
    }
}
