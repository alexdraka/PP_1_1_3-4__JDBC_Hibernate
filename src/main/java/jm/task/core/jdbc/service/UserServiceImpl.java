package jm.task.core.jdbc.service;
import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl extends Util implements UserService {
    private final UserDao userDao = new UserDaoJDBCImpl();
    public UserServiceImpl() {
    }
    public void createUsersTable() throws SQLException {
        userDao.createUsersTable();
    }
    public void dropUsersTable() throws SQLException {
        userDao.dropUsersTable();
    }
    public void saveUser(String name, String lastName, byte age) throws SQLException {
        userDao.saveUser(name, lastName, age);
    }
    public void removeUserById(long id) throws SQLException {
        userDao.removeUserById(id);
    }
    public List<User> getAllUsers() throws SQLException {
        return userDao.getAllUsers();
    }

    public void cleanUsersTable() throws SQLException {
        userDao.cleanUsersTable();
    }
}
