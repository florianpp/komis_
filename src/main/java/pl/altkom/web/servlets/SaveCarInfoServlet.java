package pl.altkom.web.servlets;

import pl.altkom.web.CarBean;
import pl.altkom.web.dao.CarInfoDAO;
import pl.altkom.web.dao.CarInfoDAOImpl;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet("/add_car_info")
public class SaveCarInfoServlet extends HttpServlet {
    @Resource(name = "jdbc:komis")
    private DataSource dataSource;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // logika zapisywania auta

        CarBean car = new CarBean();
        String make = req.getParameter("make");
        car.setMake(make);

        String type = req.getParameter("type");
        car.setType(type);

        int year = Integer.parseInt(req.getParameter("year"));
        car.setYear(year);

        String distance = req.getParameter("distance");
        car.setDistance(distance);

        String capacity = req.getParameter("capacity");
        car.setCapacity(capacity);

        CarInfoDAO dao = new CarInfoDAOImpl();
        dao.saveCarInfo(car, dataSource);

        req.getRequestDispatcher("redirect").forward(req, resp);
    }
}
