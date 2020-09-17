package cn.smbms.controller;


import cn.smbms.pojo.Role;
import cn.smbms.pojo.User;
import cn.smbms.service.role.RoleService;
import com.alibaba.fastjson.JSONArray;
import com.mysql.jdbc.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("/rolelist.html")
    public String getRoleList(Model model, @RequestParam(value = "roleCode", defaultValue = "") String roleCode, @RequestParam(value = "roleName", defaultValue = "") String roleName) {
        List<Role> roleList = roleService.getRoleListByCodeAndName(roleCode, roleName);
        model.addAttribute("roleList", roleList);
        return "rolelist";
    }

    @RequestMapping("/add.html")
    public String addRole() {
        return "roleadd";
    }

    @RequestMapping("/addrolesave.html")
    public String addRoleSave(Role role) {
        role.setCreationDate(new Date());
        if (roleService.addRole(role)) {
            return "redirect:/role/rolelist.html";
        }
        return "roleadd";
    }

    @RequestMapping("/delrole")
    @ResponseBody
    public String deleteRole(@RequestParam("id") Integer delId) {
        HashMap<String, String> resultMap = new HashMap<String, String>();
        if (delId <= 0) {
            resultMap.put("delResult", "notexist");
        } else {
            if (roleService.deleteRole(delId)) {
                resultMap.put("delResult", "true");
            } else {
                resultMap.put("delResult", "false");
            }
        }
        //把resultMap转换成json对象输出
        return JSONArray.toJSONString(resultMap);
    }

    @RequestMapping("/tomodify.html")
    public String tomodify(@RequestParam("id") Integer id, Model model) {
        Role role = roleService.getRoleById(id);
        model.addAttribute("role", role);
        return "rolemodify";
    }

    @RequestMapping("/modifysave.html")
    public String modifySave(Role role) {
        roleService.modifyRole(role);
        return "redirect:/role/rolelist.html";
    }


    @RequestMapping("/view")
    @ResponseBody
    public String viewAjax(@RequestParam(value = "id", defaultValue = "0") Integer id) {
        Role role = roleService.getRoleById(id);
        return JSONArray.toJSONString(role);
    }
}
