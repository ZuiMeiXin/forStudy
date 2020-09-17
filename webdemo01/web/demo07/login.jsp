<%--
  Created by IntelliJ IDEA.
  User: HiSoft
  Date: 2020/7/24
  Time: 12:48
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
    <title>登录界面</title>
</head>
<body>

<%
    Cookie[] cookies = request.getCookies();
    out.println(cookies[0].getValue());
    out.println(cookies.length);
    if (cookies != null) {
        for (Cookie c : cookies) {
//            out.println(c.getName()+""+c.getValue());
            if ("user".equals(c.getName())) {
                response.sendRedirect("welcome.jsp");
            }
        }
    }
%>

<form action="demo07/welcome.jsp" method="post">
    <p>用户名：<input type="text" name="username"></p>
    <p>密&nbsp;&nbsp;&nbsp;码：<input type="text" name="password"></p>
    <input type="submit" value="登录">
</form>

</body>
</html>
