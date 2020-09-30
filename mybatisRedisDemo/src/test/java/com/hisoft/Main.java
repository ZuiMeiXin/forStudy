package com.hisoft;

import com.hisoft.config.pojo.User;
import org.springframework.util.SerializationUtils;

/**
 * 序列化和反序列化
 */
public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.setUserName("admin");
        user.setUserCode("admin");
        user.setGender("女");

        byte[] serialize = SerializationUtils.serialize(user);
        User user1 = (User)SerializationUtils.deserialize(serialize);
        System.out.println(serialize.toString());
        System.out.println(user1);


    }
}
