package com;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动入口main类
 * <p>
 * 启动该引导类就相当于启动整个项目会启动tomcat
 * 该类必须放在项目的根目录下，其他的业务类需要在该包下的子包中编写
 * 添加scanBasePackages={"","",...}
 * 通过扫描包的方式管理项目
 */
@SpringBootApplication
@MapperScan(basePackages = "com.hisoft.mapper")
public class SpringBootDemo {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemo.class, args);
    }
}
