package pl.altkom.web;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ReadClientDataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
//        pw.println("Tutaj będą się wyświetlać użytkownicy");
        try {
            InitialContext initCtx = new InitialContext();
            Context context = (Context) initCtx.lookup("java:comp/env");
            DataSource ds = (DataSource) context.lookup(getServletContext().getInitParameter("dataSource"));
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
