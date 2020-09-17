<%--
  Created by IntelliJ IDEA.
  User: HiSoft
  Date: 2020/8/3
  Time: 11:01
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
    <title>登录界面</title>
</head>
<body>
<form action="first.demo" method="post">

    用户名：<input type="text" name="username" value="">
    密码：<input type="password" name="password" value="">
    <input type="submit" value="提交">

</form>
</body>
</html>
