<%@ page import="com.servlet.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: HiSoft
  Date: 2020/8/4
  Time: 15:00
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
    <title>if标签</title>
</head>
<body>

<%
    User user = new User();
    user.setName("学生");
    session.setAttribute("user", user);
%>

<c:if test="${ empty requestScope.user}">
    欢迎失败
</c:if>
<c:if test="${not empty sessionScope.user}">
    登录成功
</c:if>

<br>


<c:choose>
    <c:when test="${user.name eq '老师'}">
        老师来了！
    </c:when>
    <c:when test="${user.name eq '学生'}">
        学生来了！
    </c:when>
    <c:otherwise>
        旷课了
    </c:otherwise>


</c:choose>


</body>
</html>
