package dao;

import exception.DBException;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.DBHelper;

import java.util.List;


public class UserDaoImpl implements UserDao {
    private static SessionFactory sessionFactory = DBHelper.getSessionFactory();

    public UserDaoImpl() {
    }


    public User getUserById(int id) throws DBException {
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("from User user where user.id =:id");
            query.setParameter("id", id);
            List<User> users = query.list();
            if (users.isEmpty()) {
                throw new DBException("user is empty");
            }
            return users.listIterator().next();
        }
    }

    @Override
    public void addUser(User user) throws DBException {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            Query query = session.createQuery("from User user where user.login =:login");
            query.setParameter("login", user.getLogin());
            List<User> users = query.list();
            if (!users.isEmpty()) {
                transaction.rollback();
                throw new DBException("alredy exist");
            }
            session.save(user);
            transaction.commit();
        }
    }

    @Override
    public void updateUser(User user) throws DBException {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new DBException(e.getMessage());
        }
    }

    @Override
    public void deleteUser(User user) throws DBException {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.delete(user);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new DBException(e.getMessage());
        }
    }

    @Override
    public List<User> getAllUsers() throws DBException {
        try (Session session = sessionFactory.openSession()) {

            Query query = session.createQuery("FROM User");
            return query.list();
        } catch (Exception e) {
            throw new DBException(e.getMessage());
        }
    }


}
