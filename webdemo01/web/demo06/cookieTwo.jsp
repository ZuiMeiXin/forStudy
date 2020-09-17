<%--
  Created by IntelliJ IDEA.
  User: HiSoft
  Date: 2020/7/24
  Time: 12:09
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
    <title>cookieTwo</title>
</head>
<body>
<%
   Cookie[] cookies= request.getCookies();
   if (cookies != null){
       for (Cookie cookie:cookies) {
           out.println(cookie.getName()+":"+cookie.getValue()+"<br/>");
       }
   }
%>
sessionID:<%=session.getId()%>


</body>
</html>
