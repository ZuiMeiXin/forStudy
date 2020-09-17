<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>index</title>
</head>
<body>
<form method="get" action="test/getUser5.html">
    用户编码：<input type="text" id="userCode" name="userCode" value="">
    <input type="submit" value="提交">
</form>
<a href="provider.jsp">添加供应商</a>
</body>
</html>
