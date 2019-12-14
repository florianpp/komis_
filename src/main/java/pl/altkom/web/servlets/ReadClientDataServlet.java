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
import java.util.List;

@WebServlet(urlPatterns = "/read_users")
public class ReadClientDataServlet extends HttpServlet {

    @Resource(name="jdbc:komis")
    private DataSource ds;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
//        pw.println("Tutaj będą się wyświetlać użytkownicy");
        try {
            ClientDataDAO dao = new ClientDataDAOImpl();
            List clients = dao.readClientsData(ds);
            pw.println("<html><head><title>Lista klientow</title></head><body>");
            pw.println("<table>");
            pw.println("<tr>");
            pw.print("<th>");
            pw.print("Imie");
            pw.println("</th>");
            pw.print("<th>");
            pw.print("Nazwisko");
            pw.println("</th>");
            pw.print("<th>");
            pw.print("Wiek");
            pw.println("</th>");
            pw.print("<th>");
            pw.print("Region");
            pw.println("</th>");
            pw.print("<th>");
            pw.print("Plec");
            pw.println("</th>");
            pw.println("</tr>");
            for (Object o : clients) {
                Client c = (Client)o;
                pw.println("<tr>");
                pw.print("<td>");
                pw.print(c.getFirstName());
                pw.println("</td>");
                pw.print("<td>");
                pw.print(c.getLastName());
                pw.println("</td>");
                pw.print("<td>");
                pw.print(c.getAge());
                pw.println("</td>");
                pw.print("<td>");
                pw.print(c.getRegion());
                pw.println("</td>");
                pw.print("<td>");
                pw.print(c.getSex());
                pw.println("</td>");
                pw.println("</tr>");
            }
            pw.println("</table>");
            pw.println("</body></html>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
