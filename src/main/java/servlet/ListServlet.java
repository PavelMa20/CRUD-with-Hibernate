package servlet;


import exception.DBException;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/list"})
public class ListServlet extends BaseServlet {


    @Override
    protected void doEX(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, DBException {
        List<User> listUser;
        listUser = userServiceImpl.getAllUsers();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/userList.jsp");
        dispatcher.forward(request, response);
    }


}
