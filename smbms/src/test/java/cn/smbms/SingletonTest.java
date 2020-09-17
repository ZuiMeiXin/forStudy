package cn.smbms;

import cn.smbms.dao.Singleton;
import cn.smbms.tools.ConfigManager;
import org.junit.Test;

public class SingletonTest {
    @Test
    public void test1(){
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton1==singleton2);
    }

    @Test
    public void test2(){
        ConfigManager configManager1 =  ConfigManager.getInstance();
        ConfigManager configManager2 =  ConfigManager.getInstance();
        System.out.println(configManager1==configManager2);
    }
}
