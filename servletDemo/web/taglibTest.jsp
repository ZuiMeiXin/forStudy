<%--
  Created by IntelliJ IDEA.
  User: HiSoft
  Date: 2020/8/4
  Time: 12:13
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
    <title>tagLib</title>
</head>
<body>
<c:set var="user" value="小呆呆" scope="page"/>
<%--    相当于 pageContext.setAttribute("user","小呆呆")--%>
用户名：   ${user}


</body>
</html>