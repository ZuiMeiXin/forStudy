package cn.smbms.controller;

import cn.smbms.pojo.Role;
import cn.smbms.pojo.User;
import cn.smbms.service.role.RoleService;
import cn.smbms.service.user.UserService;
import cn.smbms.tools.Constants;
import cn.smbms.tools.PageSupport;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.mysql.jdbc.StringUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/user")
public class UserController extends  BaseController{
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;



    @RequestMapping("/main.html")
    public String main(HttpSession session) {
        if (session.getAttribute(Constants.USER_SESSION) == null) {
            return "redirect:/user/login.html";
        }
        return "frame";
    }




    @RequestMapping("/userlist.html")
    public String getUserList(
            @RequestParam(value = "queryname", defaultValue = "") String queryUserName,
            @RequestParam(value = "queryUserRole", defaultValue = "0") Integer queryUserRole,
            @RequestParam(value = "pageIndex", defaultValue = "1") Integer currentPageNo,
            Model model
    ) {
        List<User> userList = null;
        //设置页面容量
        int pageSize = Constants.pageSize;
        //总数量（表）
        int totalCount = userService.getUserCount(queryUserName, queryUserRole);
        //总页数
        PageSupport pages = new PageSupport();
        pages.setCurrentPageNo(currentPageNo);
        pages.setPageSize(pageSize);
        pages.setTotalCount(totalCount);

        int totalPageCount = pages.getTotalPageCount();

        //控制首页和尾页
        if (currentPageNo < 1) {
            currentPageNo = 1;
        } else if (currentPageNo > totalPageCount) {
            currentPageNo = totalPageCount;
        }
        userList = userService.getUserList(queryUserName, queryUserRole, currentPageNo, pageSize);
        List<Role> roleList = null;
        roleList = roleService.getRoleList();
        model.addAttribute("userList", userList);
        model.addAttribute("roleList", roleList);
        model.addAttribute("queryUserName", queryUserName);
        model.addAttribute("queryUserRole", queryUserRole);
        model.addAttribute("totalPageCount", totalPageCount);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("currentPageNo", currentPageNo);
        return "userlist";
    }


    @RequestMapping("/add.html")
    public String add(@ModelAttribute("user") User user) {
        return "useradd";
    }

    @RequestMapping("/addusersave.html")
    public String addUserSave(@Valid User user,
                              BindingResult result,
                              HttpSession session,
                              @RequestParam(value = "a_idPicPath",required =false) MultipartFile multipartFile,
                              @RequestParam(value = "a_workPicPath",required = false) MultipartFile workFile,

                              Model model
    ) {

        String savePath = null;
        if (!multipartFile.isEmpty()) {
            /*上传准备工作*/
            /*获取文件上传的原名和大小*/
            String oldName = multipartFile.getOriginalFilename();
            /*获取文件名的后缀*/
            String ext = FilenameUtils.getExtension(oldName);
            long size = multipartFile.getSize();

            /*上传图片不能超过500kb*/
            if (size > 500 * 1024) {
                model.addAttribute("upLoadFileError", "文件上传大小不能超过500K");
                return "useradd";
            } else {
                String[] types = {"jpg", "jpeg", "png", "gif"};
                if (!Arrays.asList(types).contains(ext)) {
                    model.addAttribute("upLoadFileError", "文件上传格式不符合要求，只能上传：jpg，jpeg,png,gif");
                    return "useradd";
                } else {
                    /*正式上传*/
                    String targetPath = session.getServletContext().getRealPath("statics" + File.separator + "upload");
                    /*修改上传文件名*/
                    String fileName = System.currentTimeMillis() + RandomUtils.nextInt(1000000) + "_Personal" + ext;
                    File saveFile = new File(targetPath, fileName);
                    if (!saveFile.exists()) {
                        saveFile.mkdirs();
                    }
                    /**/
                    try {
                        multipartFile.transferTo(saveFile);
                    } catch (IOException e) {
                        e.printStackTrace();
                        model.addAttribute("upLoadFileError", "文件上传失败，联系管理员");
                        return "useradd";
                    }
                    savePath = targetPath + File.separator + fileName;
                }
            }
        }

        String saveWorkPath = null;
        if (!workFile.isEmpty()) {
            /*上传准备工作*/
            /*获取文件上传的原名和大小*/
            String oldName = workFile.getOriginalFilename();
            /*获取文件名的后缀*/
            String ext = FilenameUtils.getExtension(oldName);
            long size = workFile.getSize();

            /*上传图片不能超过500kb*/
            if (size > 500 * 1024) {
                model.addAttribute("upLoadWorkFileError", "文件上传大小不能超过500K");
                return "useradd";
            } else {
                String[] types = {"jpg", "jpeg", "png", "gif"};
                if (!Arrays.asList(types).contains(ext)) {
                    model.addAttribute("upLoadWorkFileError", "文件上传格式不符合要求，只能上传：jpg，jpeg,png,gif");
                    return "useradd";
                } else {
                    /*正式上传*/
                    String targetPath = session.getServletContext().getRealPath("statics" + File.separator + "upload");
                    /*修改上传文件名*/
                    String fileName = System.currentTimeMillis() + RandomUtils.nextInt(1000000) + "_Worker" + ext;
                    File saveFile = new File(targetPath, fileName);
                    if (!saveFile.exists()) {
                        saveFile.mkdirs();
                    }
                    /**/
                    try {
                        workFile.transferTo(saveFile);
                    } catch (IOException e) {
                        e.printStackTrace();
                        model.addAttribute("upLoadWorkFileError", "文件上传失败，联系管理员");
                        return "useradd";
                    }
                    saveWorkPath = targetPath + File.separator + fileName;
                }
            }
        }


        if (result.hasErrors()) {
            return "useradd";
        }

        user.setCreationDate(new Date());
        user.setCreatedBy(((User) session.getAttribute(Constants.USER_SESSION)).getId());
        user.setIdPicPath(savePath);
        user.setWorkPicPath(saveWorkPath);
        if (userService.add(user)) {
            return "redirect:/user/userlist.html";
        } else {
            return "useradd";
        }
    }


    /*修改用户信息*/
    @RequestMapping("/tomodify.html")
    public String getUserById(@RequestParam(value = "uid", defaultValue = "") String id, Model model) {
        if (!StringUtils.isNullOrEmpty(id)) {
            //调用后台方法得到user对象
            User user = userService.getUserById(id);
            model.addAttribute("user", user);
            return "usermodify";
        } else {
            throw new RuntimeException("数据不存在 没有获取到用户id");
        }
    }

    @RequestMapping("/modifysave.html")
    public String modifySave(HttpServletRequest request, User user) {
        user.setModifyBy(((User) request.getSession().getAttribute(Constants.USER_SESSION)).getId());
        user.setModifyDate(new Date());
        if (userService.modify(user)) {
            return "redirect:/user/userlist.html";
        } else {
            return "usermodify";
        }

    }

    @RequestMapping("/view/{id}")
    public String view(@PathVariable String id, Model model) {
        if (!StringUtils.isNullOrEmpty(id)) {
            //调用后台方法得到user对象
            User user = userService.getUserById(id);
            model.addAttribute("user", user);
            return "userview";
        } else {
            throw new RuntimeException("数据不存在 没有获取到用户id");
        }
    }

    @RequestMapping("/ucexists.html")
    @ResponseBody
    public String ucExist(@RequestParam("userCode")String userCode){
        HashMap<String, String> resultMap = new HashMap<String, String>();
        if(StringUtils.isNullOrEmpty(userCode)){
            resultMap.put("userCode", "exist");
        }else{
            User user = userService.selectUserCodeExist(userCode);
            if(null != user){
                resultMap.put("userCode","exist");
            }else{
                resultMap.put("userCode", "notexist");
            }
        }
        return JSONArray.toJSONString(resultMap);
    }


    @RequestMapping(value = "/view",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String viewAjax(@RequestParam(value = "id",defaultValue = "") String id) {
        if (!StringUtils.isNullOrEmpty(id)) {
            //调用后台方法得到user对象
            User user = userService.getUserById(id);
            return JSON.toJSONString(user);
        } else {
            return "null";
        }
    }

    @RequestMapping("/pwdmodify.html")
    public String pwdmodify(){
        return "pwdmodify";
    }




    /*修改密码*/
    @RequestMapping("/pwdmodify")
    @ResponseBody
    public String getPasswordByUserId(HttpServletRequest request,@RequestParam("oldpassword") String oldpassword){
        Object o = request.getSession().getAttribute(Constants.USER_SESSION);
        Map<String, String> resultMap = new HashMap<String, String>();

        if(null == o ){//session过期
            resultMap.put("result", "sessionerror");
        }else if(StringUtils.isNullOrEmpty(oldpassword)){//旧密码输入为空
            resultMap.put("result", "error");
        }else{
            String sessionPwd = ((User)o).getUserPassword();
            if(oldpassword.equals(sessionPwd)){
                resultMap.put("result", "true");
            }else{//旧密码输入不正确
                resultMap.put("result", "false");
            }
        }
        return JSONArray.toJSONString(resultMap);
    }

    @RequestMapping("/pwdmodifysave.html")
    public String pwdmodifysave(HttpSession session,Model model,@RequestParam("newpassword") String newpassword){

        Object o = session.getAttribute(Constants.USER_SESSION);
        boolean flag = false;
        if(o != null && !StringUtils.isNullOrEmpty(newpassword)){
            flag = userService.updatePwd(((User)o).getId(),newpassword);
            if(flag){
                model.addAttribute(Constants.SYS_MESSAGE, "修改密码成功,请退出并使用新密码重新登录！");
                session.removeAttribute(Constants.USER_SESSION);//session注销
                return "redirect:/user/login.html";
            }else{
               model.addAttribute(Constants.SYS_MESSAGE, "修改密码失败！");
               return "pwdmodify";
            }
        }else{
            model.addAttribute(Constants.SYS_MESSAGE, "修改密码失败！");
            return "pwdmodify";
        }
    }

    /*获取用户名称列表*/
    @RequestMapping("/getrolelist")
    @ResponseBody
    public String getRoleList(){
        List<Role> roleList = null;
        roleList = roleService.getRoleList();
        //把roleList转换成json对象输出
        return JSONArray.toJSONString(roleList);
    }



    @RequestMapping(value = "/deluser",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String delUser(@RequestParam(value = "uid" ,defaultValue = "0") Integer delId){
        HashMap<String, String> resultMap = new HashMap<String, String>();
        if(delId <= 0){
            resultMap.put("delResult", "notexist");
        }else{
            if(userService.deleteUserById(delId)){
                resultMap.put("delResult", "true");
            }else{
                resultMap.put("delResult", "false");
            }
        }

        //把resultMap转换成json对象输出
        return JSONArray.toJSONString(resultMap);
    }


    /*局部异常处理*/
//    @ExceptionHandler(value = {RuntimeException.class})
//    public String handlerException(RuntimeException e, HttpServletRequest request) {
//        request.setAttribute("e", e);
//        return "login";
//    }

}