package jm.task.core.jdbc.service;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import java.util.List;


public class UserServiceImpl extends Util implements UserService {
    //private UserDao userDao = new UserDaoJDBCImpl();
    public UserServiceImpl() {
    }
    public void createUsersTable() {
        cleanUsersTable();
    }
    public void dropUsersTable() {
        dropUsersTable();

    }
    public void saveUser(String name, String lastName, byte age) {
        saveUser(name, lastName, age);
    }
    public void removeUserById(long id) {
        removeUserById(id);
    }
    public List<User> getAllUsers() {
        return getAllUsers();
    }

    public void cleanUsersTable() {
        cleanUsersTable();
    }
}
