    <%@ page import="com.servlet.entity.People" %><%--
  Created by IntelliJ IDEA.
  User: HiSoft
  Date: 2020/8/4
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

=============================request封装===========================<br>
您填写的内容是：<br>
姓名：${People.name}<br>
性别；${People.gender}<br>
密码：${People.password}<br>
兴趣爱好：
${People.luange}
<br>
==============================Param和paramValues作用域=======================<br>

您填写的内容是：<br>
姓名：${param.username}<br>
性别；${param.gender}<br>
密码：${param.password}<br>
兴趣爱好：
${paramValues.langue[0]}
${paramValues.langue[1]}
${paramValues.langue[2]}
${paramValues.langue[3]}
${paramValues.langue[4]}
${paramValues.langue[5]}
<br>




</body>
</html>
