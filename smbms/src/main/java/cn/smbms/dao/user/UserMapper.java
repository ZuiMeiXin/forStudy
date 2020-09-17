package cn.smbms.dao.user;

import cn.smbms.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.Connection;
import java.util.List;

public interface UserMapper {
    /**
     * 通过userCode获取User
     */
    User getLoginUser(@Param("userCode") String userCode);

    /**
     * 通过条件查询-userList
     */
    List<User> getUserList(@Param("userName") String userName,
                           @Param("userRole") Integer userRole,
                           @Param("currentPageNo") Integer currentPageNo,
                           @Param("pageSize") Integer pageSize);

    /*获取总记录条数*/
    int getUserCount(@Param("userName") String userName, @Param("userRole") Integer userRole);


    /**
     * 通过userId删除user
     */
     int deleteUserById(@Param("delId") Integer delId);

    /**
     * 增加用户信息
     */
    Integer add(User user);

    /**
     * 通过userId获取user
     */
     User getUserById(@Param("id") String id);

    /**
     * 修改用户信息
     */
     Integer modify( User user);


    /**
     * 修改当前用户密码
     */
     Integer updatePwd(  @Param("id") Integer id, @Param("pwd") String pwd);



}
