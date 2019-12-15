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
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/start_delete_client")
public class BeginDeleteClient extends HttpServlet {
    @Resource(name = "jdbc:komis")
    private DataSource dataSource;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ClientDataDAO dao = new ClientDataDAOImpl();
            List clients = dao.readClientsData(dataSource);
            req.setAttribute("clients", clients);
            req.getRequestDispatcher("list_delete_clients.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new ServletException("Cannot reaad clients", e);
        }
    }
}

