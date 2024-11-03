package servlets;
import entity.Person;
import model.Model;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/add.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String date = request.getParameter("date");
        Person person = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            if (gender.equalsIgnoreCase("male")) {
                person = Person.createMale(name, simpleDateFormat.parse(date));
            } else if (gender.equalsIgnoreCase("female")) {
                person = Person.createFemale(name, simpleDateFormat.parse(date));
            }
            Model.getInstance().add(person);
        } catch (ParseException e) {}
        request.setAttribute("userName", name);
        doGet(request, response);
    }
}
