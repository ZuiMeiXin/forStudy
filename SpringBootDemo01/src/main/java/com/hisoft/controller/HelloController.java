package com.hisoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

//相当于 @Controller+@ResponseBody
@RestController
public class HelloController {

    /*
    两种方式获取配置文件中的属性值
     */
    //第一种 使用Environment对象  getproperty(key)方法获取
    @Resource
    private Environment environment;

    //第二种 直接使用value获取
//    @Value("${name}")
//    private String name;
//    @Value("${url}")
//    private String url;

    //相当于 @RequestMapping+method=Method.GET
    @GetMapping("/hello")
    public String hello() {
        return "这是配置了热部署\n" +
                "首先添加热部署依赖，然后在springboot插件中添加配置 必须添加 否则热部署依赖不起作用\n" +
                "之后将ieda settings中的配置勾选配置\n" +
                "使用快捷键 ctrl+shift+A 找到compiler.autuomake.allow.when.app.running 勾选上\n" +
                "然后添加一个资源文件   配置文件 设置重新启动为true 热部署路径  不包括的路径";
    }

//    @GetMapping("/show")
//    public String show() {
//        System.out.println(name + url);
//        return "" + environment.getProperty("name") + "" + environment.getProperty("url");
//    }


}
