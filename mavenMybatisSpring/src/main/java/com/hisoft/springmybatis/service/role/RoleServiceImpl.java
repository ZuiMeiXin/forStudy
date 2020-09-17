package com.hisoft.springmybatis.service.role;

import com.hisoft.springmybatis.dao.role.RoleMapper;
import com.hisoft.springmybatis.pojo.Role;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService{
    @Resource
    private RoleMapper roleMapper;
    @Override
    public List<Role> getRoleByName(String roleName) {
        return roleMapper.getRoleByName(roleName);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.REPEATABLE_READ)
    public Integer addRole(Role role) {
//        System.out.println(1/0);
        return roleMapper.addRole(role);
    }
}
