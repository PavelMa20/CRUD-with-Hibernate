package service;

import exception.DBException;
import model.User;

import java.util.List;

public interface UserService {
    void addUser(User user) throws DBException;

    void deleteUser(User user) throws DBException;

    List<User> getAllUsers() throws DBException;

    void updateUser(User user) throws DBException;

    User getUser(int id) throws DBException;
}
