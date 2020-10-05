package service;

import dao.UserDaoImpl;
import exception.DBException;
import model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private static UserServiceImpl userServiceImpl;
    private UserDaoImpl userDaoImpl;

    private UserServiceImpl() {
        this.userDaoImpl = new UserDaoImpl();
    }

    public static UserServiceImpl getInstance() {
        if (userServiceImpl == null) {
            userServiceImpl = new UserServiceImpl();
        }
        return userServiceImpl;
    }

    @Override
    public void addUser(User user) throws DBException {
        userDaoImpl.addUser(user);
    }

    @Override
    public List<User> getAllUsers() throws DBException {
        return userDaoImpl.getAllUsers();
    }

    @Override
    public void deleteUser(User user) throws DBException {
        userDaoImpl.deleteUser(user);
    }

    @Override
    public void updateUser(User user) throws DBException {
        userDaoImpl.updateUser(user);
    }

    @Override
    public User getUser(int id) throws DBException {
        return userDaoImpl.getUserById(id);
    }
}
