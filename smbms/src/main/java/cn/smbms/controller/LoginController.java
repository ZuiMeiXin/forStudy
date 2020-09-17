package cn.smbms.controller;

import cn.smbms.pojo.User;
import cn.smbms.service.user.UserService;
import cn.smbms.tools.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login.html")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/dologin.html")
    public String doLogin(@RequestParam("userCode") String userCode,
                          @RequestParam("userPassword") String userPassword,
                          HttpSession session,
                          Model model) {
        //调用service方法，进行用户匹配
        User user = userService.login(userCode, userPassword);
//        if (null != user) {//登录成功
//            //放入session
//            session.setAttribute(Constants.USER_SESSION, user);
//            //页面跳转（frame.jsp）
//            return "redirect:/user/main.html";
//        } else {
//            //页面跳转（login.jsp）带出提示信息--转发
////            model.addAttribute("error", "用户名或密码不正确");
////            return "login";
//            throw new RuntimeException("用户名或密码不正确");
//        }
        if (user == null) {
            throw new RuntimeException("用户不存在");
        } else {
            if (!user.getUserPassword().equals(userPassword)) {
                throw new RuntimeException("密码错误");
            }
        }
        session.setAttribute(Constants.USER_SESSION, user);
        return "redirect:/user/main.html";
    }

    @RequestMapping("/loginOut.html")
    public String loginOut(HttpSession session) {
//        session.removeAttribute(Constants.USER_SESSION);
        /*让session里的东西全部失效*/
        session.invalidate();
        return "redirect:/user/login.html";
    }

}
