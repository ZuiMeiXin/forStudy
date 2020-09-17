<%--
  Created by IntelliJ IDEA.
  User: HiSoft
  Date: 2020/8/28
  Time: 10:14
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
    <title>Welcome</title>
</head>
<body>
<h1>Welcome SpringMVC</h1>
</body>
</html>
