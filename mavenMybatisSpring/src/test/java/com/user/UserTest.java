package com.user;

import com.hisoft.springmybatis.pojo.User;
import com.hisoft.springmybatis.service.user.UserService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserTest {
    @Test
    public  void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService1 = (UserService) context.getBean("userService");
        UserService userService2 = (UserService) context.getBean("userService");
        System.out.println(userService1==userService2);
    }




    @Test
    public void getUserList() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml","applicationContext-dao.xml","applicationContext-service.xml");
        UserService userService = (UserService) context.getBean("userService");
        List<User> userList = userService.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void updateUserNameById() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) context.getBean("userService");
        Integer integer = userService.updateUserById("小呆", 17);
        System.out.println(integer);
    }
}
