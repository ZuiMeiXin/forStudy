package com.hisoft.springmybatis.service.user;

import com.hisoft.springmybatis.dao.user.UserMapper;
import com.hisoft.springmybatis.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service("userService")
@Scope
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true,isolation = Isolation.READ_COMMITTED)
    public List<User> getUserList() {
        return userMapper.getUserList();
    }

    @Override
    public Integer updateUserById(String userName, Integer id) {
        return userMapper.updateUserById(userName,id);
    }

    @Override
    public Integer addUser(User user) {
        return userMapper.addUser(user);
    }


}
