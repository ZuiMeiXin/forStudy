<%--
  Created by IntelliJ IDEA.
  User: HiSoft
  Date: 2020/8/5
  Time: 15:04
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
    <title>401</title>
</head>
<body>
您无权访问本资源，请返回 <a href="index.jsp">登录</a> 返回登录
</body>
</html>
