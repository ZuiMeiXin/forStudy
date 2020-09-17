<%--
  Created by IntelliJ IDEA.
  User: HiSoft
  Date: 2020/7/24
  Time: 9:16
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
    <title>计数器</title>
</head>
<body>
<a href="demo05/show.jsp">点击跳转</a>
<%
    Integer count = (Integer) application.getAttribute("count");
    if (count != null) {
        count = count + 1;
    } else {
        count = 1;
    }
    application.setAttribute("count",count);

%>
</body>
</html>
