package dbexercise.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

public class LocalConnectionMaker implements ConnectionMaker{
    @Override
    public Connection makeConnection() throws SQLException {

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://loclahost:3306/likelion-db",
                "root", "1000");
        return conn;
    }
}
