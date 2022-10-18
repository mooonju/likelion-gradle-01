package dbexercise.dao;

import dbexercise.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {
    @Test
    void addAndSelect() {
        AWSUserDaoImpl userDao = new AWSUserDaoImpl();
        User user = new User("6", "Rara", "1234");
        userDao.add(user);

        User selectedUser = userDao.getById("6");
        Assertions.assertEquals("Rara", selectedUser.getName());
    }
}