package com.hisoft.springmybatis.dao.role;

import com.hisoft.springmybatis.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface RoleMapper {
    /*根据角色名称模糊查询角色信息*/
    List<Role> getRoleByName(@Param("roleName")String roleName);


    /*添加新角色*/
    Integer addRole(Role role);
}
