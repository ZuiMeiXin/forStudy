<%--
  Created by IntelliJ IDEA.
  User: HiSoft
  Date: 2020/7/24
  Time: 12:07
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
    <title>cookieOne</title>
</head>
<body>

<%
    Cookie cookies = new Cookie("username", "小呆呆");
    Cookie cookies2 = new Cookie("pass", "小呆呆");
//    cookies.setMaxAge(1);
    response.addCookie(cookies);
    response.addCookie(cookies2);
    response.sendRedirect("cookieTwo.jsp");
%>


</body>
</html>
