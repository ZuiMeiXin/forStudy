<%--
  Created by IntelliJ IDEA.
  User: HiSoft
  Date: 2020/9/29
  Time: 10:01
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
    <title>首页</title>
    <link rel="stylesheet" href="test.css">
</head>
<body>
<h1>welcome ${username}</h1>
</body>
</html>
