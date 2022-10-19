package dbexercise.dao;

import dbexercise.domain.User;

import java.sql.*;
import java.util.Map;

public class UserDao {

    private ConnectionMaker connectionMaker;

    public UserDao() {
        this.connectionMaker = new AwsConnectionMaker();
    }

    public UserDao(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }
    public void add(User user) {
        Map<String, String> env = System.getenv();
        try {
            Connection conn = connectionMaker.makeConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO users(id, name, password) " +
                    "VALUES(?, ? ,?)");

            // 파라메터로 변경
            ps.setString(1, user.getId());
            ps.setString(2, user.getName());
            ps.setString(3, user.getPassword());

            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User findById(String id)  {
        Map<String, String> env = System.getenv();
        Connection conn;

        try {
            conn = connectionMaker.makeConnection();
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

    public int getCount() {
        Map<String, String> env = System.getenv();
        Connection conn;
        try {
            conn = connectionMaker.makeConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) FROM users");
            ResultSet rs = ps.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    public void deleteAll() {

    }

    public static void main(String[] args) {
        UserDao userDao = new UserDao();
//        userDao.add(new User("5", "DDD", "1123"));
        User user = userDao.findById("10");
        System.out.println(user.getName());

    }
}
