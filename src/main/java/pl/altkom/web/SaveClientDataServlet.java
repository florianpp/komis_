package pl.altkom.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
            dao.saveClientData(client, getServletContext().getInitParameter("dataSource"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
