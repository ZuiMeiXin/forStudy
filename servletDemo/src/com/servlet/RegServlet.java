package com.servlet;

import com.servlet.entity.People;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "RegServlet", urlPatterns = "/reg.action")
public class RegServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String username=request.getParameter("username");
        String gender = request.getParameter("gender");
        String password=request.getParameter("password");
        String[] langue = request.getParameterValues("langue");
        List<String> stringList = Arrays.asList(langue);

        People people = new People(username,gender,password,stringList);
        request.setAttribute("People",people);
        request.getRequestDispatcher("welcomeel.jsp").forward(request,response);

    }
}
