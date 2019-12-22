package service;

import dao.UserDaoImpl;
import interfaces.UserService;
import model.User;
import org.hibernate.SessionFactory;
import util.DBHelper;

import java.util.List;

public class UserServiceImpl implements UserService {
    private static UserServiceImpl userServiceImpl;

    private SessionFactory sessionFactory;

    private UserServiceImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public static UserServiceImpl getInstance() {
        if (userServiceImpl == null) {
            userServiceImpl = new UserServiceImpl(DBHelper.getSessionFactory());
        }
        return userServiceImpl;
    }

    @Override
    public void addUser(User user) {
        try (UserDaoImpl userDaoImpl = new UserDaoImpl(sessionFactory.openSession())) {
            userDaoImpl.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<User> getAllUsers() {
        try (UserDaoImpl userDaoImpl = new UserDaoImpl(sessionFactory.openSession())) {
            return userDaoImpl.getAllUsers();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public void deleteUser(User user) {
        try (UserDaoImpl userDaoImpl = new UserDaoImpl(sessionFactory.openSession())) {
            userDaoImpl.deleteUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(User user) {
        try (UserDaoImpl userDaoImpl = new UserDaoImpl(sessionFactory.openSession())) {
            userDaoImpl.updateUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUser(int id) {
        try (UserDaoImpl userDaoImpl = new UserDaoImpl(sessionFactory.openSession())) {
            return userDaoImpl.getUserById(id);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
