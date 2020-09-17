<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %><%--
  Created by IntelliJ IDEA.
  User: HiSoft
  Date: 2020/7/29
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
    <title>第一个应用</title>
</head>
<body>
<%
    Context context=new InitialContext();
    String lookup =(String) context.lookup("java:comp/env/testJdni");
    out.println("jdni1:"+lookup);
%>

</body>
</html>
