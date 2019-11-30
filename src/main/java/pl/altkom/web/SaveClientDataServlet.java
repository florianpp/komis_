package pl.altkom.web;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;

public class SaveClientDataServlet extends HttpServlet {
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
            InitialContext initCtx = new InitialContext();
            Context context = (Context) initCtx.lookup("java:comp/env");
            DataSource ds = (DataSource) context.lookup(getServletContext().getInitParameter("dataSource"));
            dao.saveClientData(client, ds);
        } catch (Exception e) {
            e.printStackTrace();
        }

        PrintWriter out = resp.getWriter();
        out.println("<html><head><title>SUKCES</title></head>");
        out.println("<body>");
        out.println("<h1>Udało Ci się dodać użytkownika!!!</h1>");
        out.println("<a href=\"userForm.html\">Dodaj kolejnego użytkownika</a>");
        out.println("</body></html>");

    }
}
