<%--
  Created by IntelliJ IDEA.
  User: HiSoft
  Date: 2020/7/22
  Time: 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>逻辑判断</title>
</head>
<body>
<%
    String name = request.getParameter("userName");
    String pass = request.getParameter("pwd");
    if ("admin".equals(name)&&"admin".equals(pass)){
        /*重定向到欢迎页面   重定向会改变地址*/
        response.sendRedirect("welcome.jsp");
    }else{
        /*登录有误 重定向回到登录页面*/
        response.sendRedirect("input.jsp");
    }


%>


</body>
</html>
