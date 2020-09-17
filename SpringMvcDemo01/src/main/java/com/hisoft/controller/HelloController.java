package com.hisoft.controller;

import com.hisoft.entity.Provider;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Map;


@Controller
@RequestMapping(value = "/test")
public class HelloController {
    private Logger logger = Logger.getLogger(HelloController.class);

    @RequestMapping(value = {"/hello.html", "/hello.do"}, method = {RequestMethod.GET, RequestMethod.POST}, params = {"userName"})
    public String print(@RequestParam("user") String userName,
                        @RequestParam(value = "pwd", required = false) String password) {
        logger.info("welcome SpringMvc" + userName);
        logger.info("welcome SpringMvc" + password);
        return "welcome";//返回的是jsp的名字 根据这个名字找到对应的jsp文件
    }

    @RequestMapping("/hello2.html")
    public String test() {
        logger.info("this is second test");
        return "welcome2";
    }

    /*几种不同的传参方式*/
    @RequestMapping("/getUser1.html")
    public ModelAndView getUser(ModelAndView mav) {
        mav.addObject("userName", "小呆呆");
        mav.setViewName("show");
        return mav;
    }

    /*推荐使用*/
    @RequestMapping("/getUser2.html")
    public String getUser(Model model) {
        model.addAttribute("userName", "小猪猪");
        return "show";
    }

    @RequestMapping("/getUser3.html")
    public String getUser(Map map,@RequestParam String userCode) {
        map.put("userName", userCode);
        return "show";
    }

    @RequestMapping(value = "/showProvider.html")
    public String showProvider(Map map, Provider provider) {
        map.put("provider", provider);
        return "providerShow";
    }

    //    @RequestMapping("/getUser4.html")
//    public String getUser(HttpServletRequest request) {
//        request.setAttribute("userName","慢羊羊，喜羊羊，沸羊羊，美羊羊，懒羊羊，暖羊羊" +
//                "，灰太狼，红太狼，小灰灰，蕉太狼，泰哥");
//        return "show";
//    }
    @RequestMapping("/getUser5.html")
    public String getUser(HttpServletRequest request,@RequestParam("userCode") String userCode) {
        System.out.println(userCode);
        request.setAttribute("userName", userCode);
        return "show";
    }

}


//public class HelloController extends AbstractController {
//    private Logger logger = Logger.getLogger(HelloController.class);
//
//    @Override
//    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
//        logger.info("Hello SpringMVC");
//        return new ModelAndView("welcome");
//    }
//}
