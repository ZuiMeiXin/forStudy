package com.hisoft.service;

import com.hisoft.dao.user.UserDao;
import com.hisoft.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService{
//    @Autowired
//    @Qualifier("userDao")
//    上面的Qualifier是根据类型查找的
//    Resource是根据变量名查找的 没有给值的时候 默认是变量名 根据名字匹配 如果没有匹配到就按照类型匹配
    @Resource(name = "userDao")
    private UserDao userDao;
    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }

    public Integer  addUser(User user){
//        int a=1/0;
        int i = userDao.addUser(user);
        return i;
    }

}
