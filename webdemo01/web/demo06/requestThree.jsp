<%--
  Created by IntelliJ IDEA.
  User: HiSoft
  Date: 2020/7/24
  Time: 10:43
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
    <title>requestThree</title>
</head>
<body>
<h1>
    requestThree：
    <%=
        request.getAttribute("request")
    %>
</h1>

</body>
</html>
