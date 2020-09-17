package com.Spring;

import com.hisoft.pojo.Provider;
import com.hisoft.pojo.User;
import com.hisoft.service.UserService;
import com.hisoft.service.provider.ProviderService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContxt.xml");
        UserService userService =(UserService) context.getBean("userService");
        userService.addUser(new User());
    }

    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContxt.xml");
        ProviderService providerService=(ProviderService) context.getBean("providerService");
        providerService.addProvider(new Provider());
    }
}
