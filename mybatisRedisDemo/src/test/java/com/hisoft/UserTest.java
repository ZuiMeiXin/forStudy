package com.hisoft;

import com.hisoft.redis.dao.user.UserMapper;
import com.hisoft.redis.pojo.User;
import com.hisoft.redis.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserTest {
    @Autowired
    private UserService userService;

    @Test
    public void test01() {
        List<User> userList = userService.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }

        System.out.println("======================================================");
        List<User> userList2 = userService.getUserList();
        for (User user : userList2) {
            System.out.println(user);
        }
        System.out.println("======================================================");
    }

    @Test
    public void test02() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        List<User> userList = context.getBean(UserMapper.class).getUserList();
        for (User user : userList) {
            System.out.println(user);
        }
    }
}
