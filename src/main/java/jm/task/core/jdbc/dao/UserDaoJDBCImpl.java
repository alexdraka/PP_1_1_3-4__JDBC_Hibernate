package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() throws SQLException {

    }
    private Util util = new Util();
    private Connection connection = util.getConnection();

    public void createUsersTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS `mytestdb`.`userstable` (\n" +
                "  `id` BIGINT(19) UNSIGNED NOT NULL AUTO_INCREMENT,\n" +
                "  `name` VARCHAR(45) NOT NULL,\n" +
                "  `lastName` VARCHAR(45) NOT NULL,\n" +
                "  `age` BIT(8) NULL,\n" +
                "  PRIMARY KEY (`id`))\n" +
                "ENGINE = InnoDB\n" +
                "DEFAULT CHARACTER SET = utf8;";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        connection.close();
    }

    public void dropUsersTable() throws SQLException {
        String sql = "DROP TABLE IF EXISTS userstable";

        Connection connection = util.getConnection();

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        String sql = "INSERT INTO userstable (name, lastName, age) VALUES(?, ?, ?)";

        Connection connection = util.getConnection();

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, lastName);
            ps.setByte(3, age);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeUserById(long id) throws SQLException {
        String sql = "DELETE FROM userstable WHERE id = ?";

        Connection connection = util.getConnection();

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setLong(1, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<User> getAllUsers() throws SQLException {
        List<User> userList = new ArrayList<>();

        String sql = "SELECT id, name, lastName, age FROM userstable";

        Connection connection = util.getConnection();

        try (Statement stm = connection.createStatement()) {
            ResultSet rs = stm.executeQuery(sql);

            while(rs.next()) {

                userList.add(new User(rs.getLong("id"), rs.getString("name"),
                        rs.getString("lastName"), rs.getByte("age")));
            }
            return userList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void cleanUsersTable() throws SQLException {
        String sql = "DELETE FROM userstable";

        Connection connection = util.getConnection();

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
