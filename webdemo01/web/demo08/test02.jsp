<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.Context" %>
<%--
  Created by IntelliJ IDEA.
  User: HiSoft
  Date: 2020/7/29
  Time: 15:22
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
    <title>第二个应用</title>
</head>
<body>
<%
    Context context=new InitialContext();
    String lookup =(String) context.lookup("java:comp/env/testJdni");
    out.println("jdni2:"+lookup);
%>
</body>
</html>
