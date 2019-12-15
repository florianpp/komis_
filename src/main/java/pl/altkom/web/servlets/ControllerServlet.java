package pl.altkom.web.servlets;

import pl.altkom.web.listeners.SessionCounter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/redirect")
public class ControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String name = req.getParameter("name");
        PrintWriter pw = resp.getWriter();

        pw.println("<HTML><HEAD>");
        pw.println("<meta charset=\"UTF-8\">");
        pw.println("<TITLE>Hello</TITLE>");
        pw.println("</HEAD><BODY>");
        pw.print("<H3>Hello ");
        if (name != null) {
            pw.print(name);
        } else {
            pw.print("world");
        }
        pw.println("!</H3>");
        pw.println("<a href=\"makeForm.jsp\">Marka</a><br><br>");
        pw.println("<a href=\"userForm.jsp\">Utwórz użytkownika</a><br><br>");
        pw.print("<h5>Liczba aktywnych użytkowników: " + SessionCounter.getCounter());
        pw.println("</h5><br><br>");
        Object counter = getServletContext().getAttribute("savedClientsCounter");
        if (counter == null) {
            pw.println("Nie ma dodanych żadnych użytkowników");
        } else {
            pw.println("Dodano: " + counter.toString() + " użytkowników");
        }
        pw.println("<br><br>");
        String email = this.getServletContext().getInitParameter("adres_email_tworcy");
        pw.println("Adres e-mail twórcy strony: " + email);
        pw.println("</BODY></HTML>");
    }
}
