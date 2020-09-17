package com.hisoft.news.filter;

import com.hisoft.news.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class CheckUserLogin implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        List<String> list = Arrays.asList("bottom.html", "left.html", "top.html");
        String uri = request.getRequestURI();
        list.forEach((path) -> {
            if (uri.endsWith(path)) {
                try {
                    filterChain.doFilter(servletRequest, servletResponse);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ServletException e) {
                    e.printStackTrace();
                }
            }
        });

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        User user = new User();
        String uname = (String)request.getSession().getAttribute("uname");
        String upwd = request.getParameter("upwd");
        if ("admin".equals(uname)) {
            user.setUname(uname);
            user.setUpwd(upwd);
            request.getSession().setAttribute("user", user);
            filterChain.doFilter(request, response);
        } else {
            out.println("<script>alert('请登录后访问');location.href='../index.jsp?action=index'</script>");
            return;
//            response.sendRedirect("../index.jsp?action=index");
        }

    }

}
