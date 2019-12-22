package interfaces;

import model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    void deleteUser(User user);

    List<User> getAllUsers();

    void updateUser(User user);

    User getUser(int id);
}
