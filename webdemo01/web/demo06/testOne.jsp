<%--
  Created by IntelliJ IDEA.
  User: HiSoft
  Date: 2020/7/24
  Time: 10:17
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
    <title>testOne</title>
</head>
<body>
<%--存数据到page作用域--%>
<%
pageContext.setAttribute("page","page作用域");
%>

<h1>
    <%--取数据 从page作用域取数据--%>
    <%=pageContext.getAttribute("page")%>
</h1>

<%
    pageContext.include("testTwo.jsp");//先翻译编译，再引入，生成两个class文件
%>


<%--先引入 再翻译编译 只生成一个class文件--%>
<%--<%@include file="testTwo.jsp"%>--%>

</body>
</html>
