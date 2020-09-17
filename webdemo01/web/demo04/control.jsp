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
    <title>控制页面</title>
</head>
<body>

<%
    //String user=(String)session.getAttribute("user");
//String pass=(String)session.getAttribute("pass");
    String user = request.getParameter("userName");
    String pass = request.getParameter("pwd");
    if ("admin".equals(user) && "admin".equals(pass)) {
        session.setAttribute("user", user);
        session.setMaxInactiveInterval(10);
        response.sendRedirect("admin.jsp");
    } else {
        response.sendRedirect("input.jsp");
    }

%>

</body>
</html>
