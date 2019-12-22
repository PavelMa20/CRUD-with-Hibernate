package interfaces;

import model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);

    void updateUser(User user);

    void deleteUser(User user);

    List<User> getAllUsers();

    User getUserById(int id);
}
