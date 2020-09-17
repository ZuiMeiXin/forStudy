package cn.smbms.dao.role;

import cn.smbms.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.sql.Connection;
import java.util.List;

public interface RoleMapper {
    List<Role> getRoleList();
    /*条件查询角色列表*/
    List<Role> getRoleListByCodeAndName(@Param("roleCode") String roleCode,@Param("roleName") String roleName);
    /*增加角色*/
    int addRole(Role role);
    /*删除角色*/
    int deleteRole(Integer delId);
    /*修改角色信息*/
    int modifyRole(Role role);
    Role getRoleById(@Param("id") Integer id);

}
