package com.provider;

import com.hisoft.springmybatis.pojo.Provider;
import com.hisoft.springmybatis.service.provider.ProviderService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ProviderTest {
    @Test
    public void getProviderList(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ProviderService providerService = (ProviderService) context.getBean("providerService");
        List<Provider> providerList = providerService.getProviderList("北京");
        for (Provider provider : providerList) {
            System.out.println(provider);

        }
    }

    @Test
    public void updateProviderPhone(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ProviderService providerService = (ProviderService) context.getBean("providerService");
        Integer integer = providerService.updateProvider("15224747260", 15);
        System.out.println(integer);
    }
}
