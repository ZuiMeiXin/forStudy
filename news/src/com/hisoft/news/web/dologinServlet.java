package com.hisoft.news.web;

import com.hisoft.news.dao.UserDao;
import com.hisoft.news.dao.impl.UserDaoImpl;
import com.hisoft.news.entity.NewsUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "dologinServlet")
public class dologinServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        String username = (String) request.getParameter("uname");
        String userpass = (String) request.getParameter("upwd");
        String action = request.getParameter("action");
        //服务器 验证
        if ("logout".equals(action)) {
            out.print("<script>window.top.location='index.jsp'</script>");
//            request.getRequestDispatcher("index.jsp?action=index").forward(request,response);
            return;
        }
        if ("".equals(username)) {
            request.setAttribute("message", "用户名不能为空");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }
        if ("".equals(userpass)) {
            request.setAttribute("message", "密码不能为空");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }
        NewsUser newsUser1 = new NewsUser(username, userpass);
        UserDao userDao = new UserDaoImpl();
        NewsUser findUser = null;
        try {
            findUser = userDao.findNewsUser(newsUser1);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (findUser != null) {
            request.getSession().setAttribute("uname", username);

            request.getRequestDispatcher("newspages/admin.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

    }
}
