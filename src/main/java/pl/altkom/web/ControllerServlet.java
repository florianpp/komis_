package pl.altkom.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet({"/controller", "/"})
public class ControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
        pw.println("<a href=\"makeForm.html\">Link</a><br><br>");
        String email = this.getServletContext().getInitParameter("adres_email_tworcy");
        pw.println("Adres e-mail twórcy strony: " + email);
        pw.println("</BODY></HTML>");
    }
}
