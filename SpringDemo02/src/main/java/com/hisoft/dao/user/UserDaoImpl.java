package com.hisoft.dao.user;

import com.hisoft.pojo.User;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Override
    public int addUser(User user) {
        System.out.println("添加成功");
        return 1;
    }
}
