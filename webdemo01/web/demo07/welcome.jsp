<%--
  Created by IntelliJ IDEA.
  User: HiSoft
  Date: 2020/7/24
  Time: 12:57
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
    <title>欢迎界面</title>
</head>
<body>
welcome
<%
    String username=request.getParameter("username");
    String password=request.getParameter("password");
    Cookie cookie1=new Cookie("user",username);
    Cookie cookie2=new Cookie("pass",password);
//    cookie1.setMaxAge(10);
//    cookie2.setMaxAge(10);
    response.addCookie(cookie1);
    response.addCookie(cookie2);
%>


</body>
</html>
