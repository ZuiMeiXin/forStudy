package com.hisoft.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.hisoft.pojo.User;
import com.hisoft.service.RedisService;
import com.hisoft.service.UserService;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Resource
    private UserService userService;

    @Resource
    private RedisService redisService;

    @RequestMapping("/welcome")
    public String welcome(Model model) {
        model.addAttribute("username", "小呆呆");
        return "index";
    }

    @RequestMapping("/userlist")
    @ResponseBody
    public Object getUserList() {
//        List<User> userList = userService.getUserList();
        /*
         * 先判断缓存中是否有数据，
         * 有就从缓存中拿，
         * 如果没有就从数据库查询数据
         *
        */
//       String usersStr=(String)redisService.getObj("users");
//       List users = (List) JSON.parse(usersStr);
        List<User> users = (List<User>) redisService.getObj("users");

        if (users==null){
            System.out.println("查询了数据库-----------------");
            users = userService.getUserList();
            redisService.setObj("users",users,1000*60*60);
//            redisService.setObj("users", JSON.toJSONString(users),1000*60*60);
//            System.out.println(redisService.getObj("users"));
        }
        return users;

    }

    @GetMapping("/test")
    public String test01(Model model){
        User user = new User();
        user.setUserCode("xdd");
        user.setUserName("小呆呆");
        user.setUserPassword("123123");


        List list = new ArrayList();
        list.add("小猪猪");
        list.add("猪刚鬣");
        list.add("沙僧");
        list.add("唐僧");
        list.add("猴子");



        Map map = new HashMap<Object, Object>();
        map.put("m1","zhangsan");
        map.put("m2","zhangsan");
        map.put("m3","zhangsan");
        map.put("m4","zhangsan");
        map.put("m5","zhangsan");
        model.addAttribute("maps",map);
        model.addAttribute("user",user);
        model.addAttribute("list",list);
        return "index";
    }
}
