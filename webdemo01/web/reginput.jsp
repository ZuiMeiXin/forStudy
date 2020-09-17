<%--
  Created by IntelliJ IDEA.
  User: HiSoft
  Date: 2020/7/22
  Time: 10:04
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
    <title>用户登录界面</title>
</head>
<body>
<form name="form1" method="get" action="reginfo.jsp">
    <table border="0" align="center">
        <tr> <td>用户名</td><td> <input type="text" name="name"></td></tr>
        <tr><td>密码</td><td > <input type="password" name="pwd"> </td></tr>
        <tr> <td>信息来源</td><td>
            <input type="checkbox" name="channel" value="报刊">报刊
            <input type="checkbox" name="channel" value="网络">网络
            <input type="checkbox" name="channel" value="朋友推荐"> 朋友推荐
            <input type="checkbox" name="channel" value="电视"> 电视
        </td></tr>
        <!--省略提交、取消按钮 -->
        <tr><td > <input type="submit" value="提交"> </td></tr>
    </table>
</form>

</body>
</html>
