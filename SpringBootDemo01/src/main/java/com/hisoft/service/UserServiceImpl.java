package com.hisoft.service;

import com.hisoft.mapper.UserMapper;
import com.hisoft.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> getUserList() {
        List<User> userList = userMapper.getUserList();
        return userList;
    }
}
