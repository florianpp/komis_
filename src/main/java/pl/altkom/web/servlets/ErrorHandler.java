package pl.altkom.web.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/handle_error")
public class ErrorHandler extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        pw.println("<HTML><HEAD>");
        pw.println("<meta charset=\"UTF-8\">");
        pw.println("<TITLE>Hello</TITLE>");
        pw.println("</HEAD><BODY>");
        pw.println("<H3>ERROR</H3>");
        pw.println(req.getAttribute("javax.servlet.error.message"));
        getServletContext().log("HAHAHAHAH DUPA");
        getServletContext().log(req.getAttributeNames().toString());
        pw.println("</BODY></HTML>");
    }
}
