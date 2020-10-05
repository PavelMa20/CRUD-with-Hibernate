package servlet;

import exception.DBException;
import model.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/insert"})
public class AddServlet extends BaseServlet {


    @Override
    protected void doEX(HttpServletRequest request, HttpServletResponse response) throws IOException, DBException {
        User newUser = new User(request.getParameter("name"), request.getParameter("password"),
                request.getParameter("login"));
        userServiceImpl.addUser(newUser);
        response.sendRedirect("list");
    }
}
