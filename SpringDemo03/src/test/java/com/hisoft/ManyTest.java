package com.hisoft;

import com.hisoft.pojo.Provider;
import com.hisoft.service.ProviderService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ManyTest {
    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Many many=(Many)context.getBean("manyData");
        System.out.println(many);
    }
     @Test
    public void test02(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
         ProviderService providerService=(ProviderService)context.getBean("providerService");
         providerService.addProvider(new Provider());
    }


}
