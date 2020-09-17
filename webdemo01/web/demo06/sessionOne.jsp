<%--
  Created by IntelliJ IDEA.
  User: HiSoft
  Date: 2020/7/24
  Time: 11:08
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
    <title>sessionOne</title>
</head>
<body>
<%
    request.setAttribute("request","request作用域只有一次请求");
    session.setAttribute("session","session的作用域是一个会话 会话结束 或者会话改变了都不能获取到了");
    application.setAttribute("application","application的作用域是整个web应用程序 最任何一个会话中都可以访问到数据");
    response.sendRedirect("sessionTwo.jsp");//response请求了两次 所以response获取不到值
%>
</body>
</html>
