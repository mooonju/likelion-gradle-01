package dbexercise.dao;

import dbexercise.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = UserDaoFactory.class)
class UserDaoTest {

    @Autowired
    ApplicationContext context;

    @Test
    void addAndSelect() {
//        AWSUserDaoImpl userDao = new AWSUserDaoImpl();
        UserDao userDao = context.getBean("awsUserDao", UserDao.class);
        String id = "10";
//        userDao.add(new User(id, "Rara", "1234"));
//        userDao.add(user);

        User user = userDao.findById(id);
        Assertions.assertEquals("Rara", user.getName());
//        Assertions.assertEquals("Rara", selectedUser.getName());
//        Assertions.assertEquals("1234", selectedUser.getPassword());
    }
}