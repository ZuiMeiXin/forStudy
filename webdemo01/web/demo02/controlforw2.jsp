<%--
  Created by IntelliJ IDEA.
  User: HiSoft
  Date: 2020/7/22
  Time: 12:15
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
String name=request.getParameter("userid");
String pass=request.getParameter("passwd");
if (name.equals("lucky")&&pass.equals("123456")){
    request.getRequestDispatcher("welcomefor2.jsp").forward(request,response);
}else{
    request.getRequestDispatcher("mailLogin.jsp").forward(request,response);
}
%>
</body>
</html>
