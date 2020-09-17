<%--
  Created by IntelliJ IDEA.
  User: HiSoft
  Date: 2020/8/3
  Time: 11:12
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
    <title>欢迎页面</title>
</head>
<body>
<h1>欢迎登陆</h1>
</body>
</html>
