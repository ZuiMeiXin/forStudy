<%--
  Created by IntelliJ IDEA.
  User: HiSoft
  Date: 2020/7/24
  Time: 11:11
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
    <title>sessionTwo</title>
</head>
<body>

request：<%=request.getAttribute("request")%><br>
session：<%=session.getAttribute("session")%><br>
application：<%=application.getAttribute("application")%>



</body>
</html>
