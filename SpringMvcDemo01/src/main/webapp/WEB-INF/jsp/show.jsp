<%--
  Created by IntelliJ IDEA.
  User: HiSoft
  Date: 2020/8/28
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>显示</title>
</head>
<body>
<h1>用户编码：${userName}</h1>

</body>
</html>
