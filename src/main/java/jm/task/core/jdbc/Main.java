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
        userDao.saveUser("Dmitriy", "Popov", (byte) 30);
        userDao.saveUser("Ivan", "Kuraev", (byte) 45);
        userDao.saveUser("Denis", "Kalugin", (byte) 70);
        // <----- Работает!
        userDao.removeUserById(23);
        // <----- Работает!
        List<User> lu = userDao.getAllUsers();
        StringJoiner joiner = new StringJoiner(",");
        for (User user : lu) {
            joiner.add(user.toString());
        }
        String myString = joiner.toString();
        System.out.println(myString);
        // <----- Работает!
        userDao.cleanUsersTable();
        // <----- Работает!
        userDao.dropUsersTable();
    }
}
