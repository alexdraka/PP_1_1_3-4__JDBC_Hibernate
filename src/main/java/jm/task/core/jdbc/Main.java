package jm.task.core.jdbc;
import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import java.sql.SQLException;
import java.util.List;
import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) throws SQLException {
        // реализуйте алгоритм здесь
        //Util.getConnection();
        UserDao userDao = new UserDaoJDBCImpl();
        // <----- Работает!
        userDao.createUsersTable();
        // <----- Работает!
        userDao.saveUser("Petr", "Petrov", (byte) 20);

        System.out.println("User с именем – Petr добавлен в базу данных");

        userDao.saveUser("Dmitriy", "Popov", (byte) 30);

        System.out.println("User с именем – Dmitriy добавлен в базу данных");

        userDao.saveUser("Ivan", "Kuraev", (byte) 45);

        System.out.println("User с именем – Ivan добавлен в базу данных");

        userDao.saveUser("Denis", "Kalugin", (byte) 70);

        System.out.println("User с именем – Denis добавлен в базу данных");
        // <----- Работает!
        userDao.removeUserById(23);
        // <----- Работает!
        System.out.println(userDao.getAllUsers().toString());
        // <----- Работает!
        userDao.cleanUsersTable();
        // <----- Работает!
        userDao.dropUsersTable();
    }
}
