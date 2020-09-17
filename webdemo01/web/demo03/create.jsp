<%--
  Created by IntelliJ IDEA.
  User: HiSoft
  Date: 2020/7/22
  Time: 14:20
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
    <title>创建会话</title>
</head>
<body>

<%
    session.setAttribute("user", "张三");
    session.setAttribute("password", "jiubugaosuni");
    response.sendRedirect("showinfo.jsp");
%>

</body>
</html>
