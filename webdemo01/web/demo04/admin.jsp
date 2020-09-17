<%--
  Created by IntelliJ IDEA.
  User: HiSoft
  Date: 2020/7/22
  Time: 15:19
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
    <title>admin页面</title>
</head>
<body>
<%
    String user = (String) session.getAttribute("user");
    if (user==null){
        response.sendRedirect("input.jsp");
        return;
    }

%>
welcome
</body>
</html>
