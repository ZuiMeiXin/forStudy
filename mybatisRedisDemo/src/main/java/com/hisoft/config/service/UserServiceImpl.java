package com.hisoft.config.service;

import com.hisoft.config.pojo.User;
import com.hisoft.config.dao.user.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;


    @Override
    public List<User> getUserList() {
        List<User> userList = userMapper.getUserList();
        return userList;
    }
}
