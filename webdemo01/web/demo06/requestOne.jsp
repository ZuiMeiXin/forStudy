<%--
  Created by IntelliJ IDEA.
  User: HiSoft
  Date: 2020/7/24
  Time: 10:41
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
    <title>requestOne</title>
</head>
<body>

<%
    request.setAttribute("request","request作用域可以跨多个页面");
    request.getRequestDispatcher("requestTwo.jsp").forward(request,response);
%>

</body>
</html>
