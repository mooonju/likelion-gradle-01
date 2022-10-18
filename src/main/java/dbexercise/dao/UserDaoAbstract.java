package dbexercise.dao;

import dbexercise.domain.User;

import java.sql.*;
import java.util.Map;

public abstract class UserDaoAbstract {

    public abstract Connection makeConnection() throws SQLException;

    public void add(User user) {
        Map<String, String> env = System.getenv();
        try {
            Connection conn = makeConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO users(id, name, password) " +
                    "VALUES(?, ? ,?)");

            // 파라메터로 변경
            ps.setString(1, user.getId());
            ps.setString(2, user.getName());
            ps.setString(3, user.getPassword());

            int status = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User getById(String id)  {
        Map<String, String> env = System.getenv();

        try {
            Connection conn = makeConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT id, name, password FROM users WHERE id =?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            User user = new User(rs.getString("id"), rs.getString("name"), rs.getString("password"));
            rs.close();
            ps.close();
            conn.close();
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        UserDaoAbstract userDao = new UserDaoAbstract();
//        userDao.add(new User("5", "DDD", "1123"));
//        User user = userDao.getById("2");
//        System.out.println(user.getName());

    }
}
