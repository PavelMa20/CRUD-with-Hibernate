package dao;

import exception.DBException;
import model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user) throws DBException;

    void updateUser(User user) throws DBException;

    void deleteUser(User user) throws DBException;

    List<User> getAllUsers() throws DBException;

    User getUserById(int id) throws DBException;
}
