package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/Mytestdb";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "root";

    private Session session;
    private Transaction transaction;

    private static SessionFactory sessionFactory;
    private static StandardServiceRegistry registry;

    public Connection getConnection() throws SQLException {

        return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                // Настройка Hibernate эквивалетные настройкам файла hibernate.cfg.xml's
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, DB_DRIVER);
                settings.put(Environment.URL, DB_URL);
                settings.put(Environment.USER, DB_USERNAME);
                settings.put(Environment.PASS, DB_PASSWORD);

                configuration.setProperties(settings);

                configuration.addAnnotatedClass(User.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
    public static void shutdown() {
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
    public  Session getSession() {
        return session;
    }
    public Transaction getTransaction() {
        return transaction;
    }
    public Session openSession() {
        return getSessionFactory().openSession();
    }
    public  Session openTransactionSession() {
        session = openSession();
        transaction = session.beginTransaction();
        return session;
    }
    public void closeSession() {
        session.close();
    }
    public void closeTransactionSession() {
        transaction.commit();
        closeSession();
    }
}
