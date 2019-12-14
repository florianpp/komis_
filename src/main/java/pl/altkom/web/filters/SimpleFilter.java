package pl.altkom.web.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Locale;

@WebFilter(urlPatterns = "/hello")
public class SimpleFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        PrintWriter pw = servletResponse.getWriter();
        pw.println("<HTML><HEAD>");
        pw.println("<meta charset=\"UTF-8\">");
        pw.println("<TITLE>Hello</TITLE>");
        pw.println("</HEAD><BODY>");
        filterChain.doFilter(servletRequest, servletResponse);
        pw.println("</BODY></HTML>");
    }

    @Override
    public void destroy() {

    }
}
