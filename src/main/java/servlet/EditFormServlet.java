package servlet;

import model.User;
import service.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/edit"})
public class EditFormServlet extends BaseServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User exUser = userServiceImpl.getUser(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/userForm.jsp");
        request.setAttribute("user", exUser);
        dispatcher.forward(request, response);
    }
}
