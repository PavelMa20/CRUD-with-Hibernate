package servlet;

import service.UserServiceImpl;

import javax.servlet.http.HttpServlet;

public abstract class BaseServlet extends HttpServlet {
    protected static UserServiceImpl userServiceImpl= UserServiceImpl.getInstance();
}
