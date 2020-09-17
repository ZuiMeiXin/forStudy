package cn.smbms.service.role;

import java.sql.Connection;
import java.util.List;

import cn.smbms.dao.BaseDao;
import cn.smbms.dao.role.RoleDao;
import cn.smbms.dao.role.RoleDaoImpl;
import cn.smbms.dao.role.RoleMapper;
import cn.smbms.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> getRoleListByCodeAndName(String code, String name) {
        List<Role> roleListByCodeAndName = roleMapper.getRoleListByCodeAndName(code, name);
        return roleListByCodeAndName;
    }

    @Override
    public List<Role> getRoleList() {
        List<Role> roleList = null;
        roleList = roleMapper.getRoleList();
        return roleList;
    }


    @Override
    public boolean deleteRole(Integer id) {
        int i = roleMapper.deleteRole(id);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean addRole(Role role) {
        if (roleMapper.addRole(role) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean modifyRole(Role role) {
        if (roleMapper.modifyRole(role) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Role getRoleById(Integer id) {
        Role role = roleMapper.getRoleById(id);
        return role;
    }
}
