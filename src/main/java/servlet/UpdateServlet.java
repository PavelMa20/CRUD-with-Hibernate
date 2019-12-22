package servlet;

import model.User;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/update"})
public class UpdateServlet extends BaseServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User upUser = new User(Integer.parseInt(request.getParameter("id")),
                (request.getParameter("name")), request.getParameter("password"),
                request.getParameter("login"));
        userServiceImpl.updateUser(upUser);
        response.sendRedirect("list");
    }
}
