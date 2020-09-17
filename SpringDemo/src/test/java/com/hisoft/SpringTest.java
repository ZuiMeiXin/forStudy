package com.hisoft;

import cn.printer.Printer;
import com.hisoft.user.User;
import javafx.application.Application;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    @Test
    public void springTest() {
//        创建容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContxt.xml");
//        获取bean
        SpringDemo springDemo = (SpringDemo) context.getBean("hello");
        springDemo.print();
    }

    @Test
    public void springTest02() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContxt.xml");
//        获取bean
        SpringDemo02 springDemo = (SpringDemo02) context.getBean("sayInfo1");
        SpringDemo02 springDemo02 = (SpringDemo02) context.getBean("sayInfo2");
        springDemo.print();
        springDemo02.print();
    }

    @Test
    public void test03(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContxt.xml");
        Printer printer =(Printer) context.getBean("printer");
        printer.print("作为中国历史古都最多的省份，河南的旅游景点可谓是不少，中国十大历史古都，河南就占据了4个，即郑州、开封、洛阳、安阳。不过可惜的是，开封、洛阳、安阳现在都沦为了三四线城市，甚至算不上。应该归因于发展规划得不好吧，现在各个省份都是优先发展自己的省会城市，资源偏向太严重。");

    }

    @Test
    public void test04(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContxt.xml");
        User littleBlack = (User) context.getBean("littleBlack");
        User merman = (User) context.getBean("merman");
        littleBlack.show();
        merman.show();

    }

}
