package util;

import model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class DBHelper {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = createSessionFactory();
        }
        return sessionFactory;
    }

    @SuppressWarnings("UnusedDeclaration")
    private static Configuration getMySqlConfiguration() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(User.class);


        configuration.setProperty("hibernate.dialect", PropertyReader.getProperty("hibernate.dialect"));
        configuration.setProperty("hibernate.connection.driver_class", PropertyReader.getProperty("hibernate.connection.driver_class"));
        configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/" + PropertyReader.getProperty("hibernate.connection.url") + "?serverTimezone=UTC");
        configuration.setProperty("hibernate.connection.username", PropertyReader.getProperty("hibernate.connection.username"));
        configuration.setProperty("hibernate.connection.password", PropertyReader.getProperty("hibernate.connection.password"));
        configuration.setProperty("hibernate.show_sql", PropertyReader.getProperty("hibernate.show_sql"));
        configuration.setProperty("hibernate.hbm2ddl.auto", PropertyReader.getProperty("hibernate.hbm2ddl.auto"));


        return configuration;
    }

    private static SessionFactory createSessionFactory() {
        try {
            Configuration configuration = getMySqlConfiguration();
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
            builder.applySettings(configuration.getProperties());
            ServiceRegistry serviceRegistry = builder.build();
            return configuration.buildSessionFactory(serviceRegistry);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }
}
