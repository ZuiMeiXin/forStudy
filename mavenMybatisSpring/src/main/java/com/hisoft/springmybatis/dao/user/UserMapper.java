package com.hisoft.springmybatis.dao.user;

import com.hisoft.springmybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    List<User> getUserList();

    Integer addUser(User user);

    Integer updateUserById(@Param("userName") String userName,@Param("id") Integer id);
}
