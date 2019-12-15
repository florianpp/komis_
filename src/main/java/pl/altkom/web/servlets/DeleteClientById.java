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

@WebServlet(urlPatterns = "/delete_user_by_id")
public class DeleteClientById extends HttpServlet {
    @Resource(name = "jdbc:komis")
    private DataSource dataSource;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parameter = req.getParameter("id");
        int id = Integer.parseInt(parameter);
        ClientDataDAO dao = new ClientDataDAOImpl();
        try {
            dao.removeClient(id, dataSource);
            req.getRequestDispatcher("read_users").forward(req, resp);
        } catch (Exception e) {
            throw new ServletException("cannot remove client", e);
        }
    }
}
