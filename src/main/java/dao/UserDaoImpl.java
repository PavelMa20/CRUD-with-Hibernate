package dao;

import interfaces.UserDao;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;


import java.util.List;


public class UserDaoImpl implements AutoCloseable, UserDao {
    private Session session;

    public UserDaoImpl(Session session) {
        this.session = session;
    }

    private int getUserIdByLogin(String login) {

        List<User> list = session.createCriteria(User.class).add(Restrictions.eq("login", login)).list();
        if (list.isEmpty()) {
            return -1;
        }
        return list.listIterator().next().getId();
    }

    public User getUserById(int id) {

        List<User> list = session.createCriteria(User.class).add(Restrictions.eq("id", id)).list();
        if (list.isEmpty()) {
            return null;
        }
        return list.listIterator().next();

    }

    @Override
    public void addUser(User user) {
        Transaction transaction = session.beginTransaction();
        try {
            if (getUserIdByLogin(user.getLogin()) != -1) {
                throw new Exception("alredy exist");
            }

            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(User user) {
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
    }

    @Override
    public void deleteUser(User user) {
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
    }

    @Override
    public List<User> getAllUsers() {
        Query query = session.createQuery("FROM User");
        return query.list();
    }


    @Override
    public void close() throws Exception {
        session.close();
    }
}
