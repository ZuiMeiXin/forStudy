<%--
  Created by IntelliJ IDEA.
  User: HiSoft
  Date: 2020/7/22
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>登录验证</title>
</head>
<body>

<%
    String uname = (String) session.getAttribute("uname");
    if (uname == null) {
        response.sendRedirect("../index.jsp");
        return;
    }
%>

</body>
</html>
