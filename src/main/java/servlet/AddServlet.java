package servlet;

import model.User;
import service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/insert"})
public class AddServlet extends BaseServlet{


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User newUser = new User(request.getParameter("name"), request.getParameter("password"),
                request.getParameter("login"));
        userServiceImpl.addUser(newUser);
        response.sendRedirect("list");
    }
}
