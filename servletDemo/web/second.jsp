<%--
  Created by IntelliJ IDEA.
  User: HiSoft
  Date: 2020/8/4
  Time: 18:05
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
    <title>Title</title>
</head>
<body>
<c:if test="${empty test}">
    kon
    <%
        request.getRequestDispatcher("first.jsp").forward(request,response);
    %>
</c:if>
<c:if test="${ not empty test}">
    非空
</c:if>


${name}


</body>
</html>
