<%--
  Created by IntelliJ IDEA.
  User: HiSoft
  Date: 2020/7/22
  Time: 14:30
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
    <title>显示sessionID</title>
</head>
<body>
当前会话的sessionID是：<%=session.getId()%><br>
会话的用户名为：<%=session.getAttribute("user")%><br>
用户密码为：<%=session.getAttribute("password")%><br>
<a href="demo03/son.jsp">子页面</a>

</body>
</html>
