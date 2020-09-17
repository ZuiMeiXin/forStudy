<%--
  Created by IntelliJ IDEA.
  User: HiSoft
  Date: 2020/8/4
  Time: 10:58
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
    <title>注册</title>
</head>
<body>

<form action="reg.action" method="post">
    用户名：<input type="text" name="username" ><br>
    性别：<input type="text" name="gender" ><br>
    密码：<input type="password" name="password" ><br>
    兴趣爱好：
    <input type="checkbox" name="langue" value="web">web
    <input type="checkbox" name="langue" value="python">python
    <input type="checkbox" name="langue" value="java">java
    <input type="checkbox" name="langue" value="jsp">jsp
    <input type="checkbox" name="langue" value="html">html<br>
    <input type="submit" value="提交">
</form>


</body>
</html>
