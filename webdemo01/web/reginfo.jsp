<%--
  Created by IntelliJ IDEA.
  User: HiSoft
  Date: 2020/7/22
  Time: 10:05
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
    <title>Title</title>
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
String name = request.getParameter("name");
String pwd = request.getParameter("pwd");
String[] channels = request.getParameterValues("channel");
%>
<table border="0" align="center">
    <tr><td>用户名</td><td><%=name%></td></tr>
    <tr><td>密码</td><td><%=pwd%></td></tr>
    <tr><td>信息来源</td><td>
        <%
            for (String channel : channels) {
                out.println(channel+"&nbsp;");
            }
        %>
    </td></tr>


</table>

</body>
</html>
