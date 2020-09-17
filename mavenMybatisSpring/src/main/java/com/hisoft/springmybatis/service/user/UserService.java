package com.hisoft.springmybatis.service.user;

import com.hisoft.springmybatis.pojo.User;

import java.util.List;

public interface UserService {
    List<User> getUserList();
    Integer updateUserById(String userName,Integer id);
    Integer addUser(User user);
}
