package com.hisoft.springmybatis.service.role;

import com.hisoft.springmybatis.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleService {
    /*根据角色名称模糊查询角色信息*/
    List<Role> getRoleByName(@Param("roleName")String roleName);


    /*添加新角色*/
    Integer addRole(Role role);
}
