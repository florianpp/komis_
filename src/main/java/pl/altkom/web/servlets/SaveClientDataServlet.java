package pl.altkom.web.servlets;

import pl.altkom.web.Client;
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
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/add_user")
public class SaveClientDataServlet extends HttpServlet {

    @Resource(name="jdbc:komis")
    private DataSource ds;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Client client = new Client();

        client.setFirstName(req.getParameter("firstName"));
        client.setLastName(req.getParameter("lastName"));
        String ageString = req.getParameter("age");
        client.setAge(Integer.parseInt(ageString));
        client.setRegion(req.getParameter("region"));
        client.setSex(req.getParameter("sex"));

        ClientDataDAO dao = new ClientDataDAOImpl();
        try {
            dao.saveClientData(client, ds);
            req.setAttribute("bla bla", client);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("Błąd", e);
        }

        PrintWriter out = resp.getWriter();
        out.println("<html><head><title>SUKCES</title></head>");
        out.println("<body>");
        out.println("<h1>Udało Ci się dodać użytkownika!!!</h1>");
        out.println("<a href=\"userForm.jsp\">Dodaj kolejnego użytkownika</a>");
        out.println("</body></html>");

    }
}
