package jm.task.core.jdbc;
import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        // реализуйте алгоритм здесь
        UserDao userDao = new UserDaoHibernateImpl();
        // <----- Работает!
        userDao.createUsersTable();
        // <----- Работает!
        userDao.saveUser("Petr", "Petrov", (byte) 20);
        userDao.saveUser("Dmitriy", "Popov", (byte) 30);
        userDao.saveUser("Ivan", "Kuraev", (byte) 45);
        userDao.saveUser("Denis", "Kalugin", (byte) 70);
        // <----- Работает!
        userDao.removeUserById(2);
        // <----- Работает!
        System.out.println(userDao.getAllUsers().toString());
        // <----- Работает!
        userDao.cleanUsersTable();
        // <----- Работает!
        userDao.dropUsersTable();
    }
}
