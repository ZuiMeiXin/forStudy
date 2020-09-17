package com.role;

import com.hisoft.springmybatis.pojo.Role;
import com.hisoft.springmybatis.service.role.RoleService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public class RoleTest {
    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        RoleService roleService = (RoleService) context.getBean("roleService");
        List<Role> role = roleService.getRoleByName("普通");
        for (Role role1 : role) {
            System.out.println(role1);

        }
    }

    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        RoleService roleService = (RoleService) context.getBean("roleService");
        Role role = new Role();
        role.setRoleCode("SMBMS_FIVE");
        role.setRoleName("打工仔");
        role.setCreatedBy(1);
        role.setCreationDate(new Date() );
        Integer integer = roleService.addRole(role);
        System.out.println(integer);
    }
}
