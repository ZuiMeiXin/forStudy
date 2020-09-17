<%--
  Created by IntelliJ IDEA.
  User: HiSoft
  Date: 2020/7/22
  Time: 10:50
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
    <title>信息显示</title>
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
    String txtuser = request.getParameter("txtUser");
    String txtPass = request.getParameter("txtPass");
    String txtRPass = request.getParameter("txtRPass");
    String sex = request.getParameter("gen");
    String txtEmail = request.getParameter("txtEmail");
    String year = request.getParameter("year");
    String month = request.getParameter("month");
    String day = request.getParameter("day");
%>
<table border="0" align="center">
    <tr><td>用户名</td><td><%=txtuser%></td></tr>
    <tr>
        <td>密码</td>
        <td><%=txtPass%></td></tr>
    <tr>
    <tr>
        <td>确认密码</td>
        <td><%=txtRPass%></td></tr>
    <tr>
        <td>性别</td>
        <td><%=sex%></td></tr>
    <tr>
        <td>邮箱地址</td>
        <td><%=txtEmail%></td></tr>
    <tr>
        <td>出生日期</td>
        <td><%=year%>年<%=month%>月<%=day%>日</td></tr>
</table>




</body>
</html>
