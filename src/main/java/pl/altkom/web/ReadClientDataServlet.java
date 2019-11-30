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
            pw.println("<ol>");
            for (Object o : clients) {
                Client c = (Client)o;
                pw.print("<li>");
                pw.print(c.getFirstName() + " " + c.getLastName());
                pw.println("</li>");
            }
            pw.println("</ol>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
