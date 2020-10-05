package servlet;

import exception.DBException;
import service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class BaseServlet extends HttpServlet {
    protected static UserServiceImpl userServiceImpl = UserServiceImpl.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        try {
            doEX(request, response);
        } catch (Exception e) {
            response.sendError(401, e.toString());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        try {
            doEX(request, response);
        } catch (Exception e) {
            response.sendError(401, e.toString());
        }
    }

    abstract void doEX(HttpServletRequest request, HttpServletResponse response) throws IOException, DBException, ServletException;


}

