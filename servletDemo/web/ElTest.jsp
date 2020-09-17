<%@ page import="com.servlet.entity.User" %>
<%@ page import="sun.rmi.runtime.NewThreadAction" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: HiSoft
  Date: 2020/8/4
  Time: 10:11
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
    <title>el</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
    pageContext.setAttribute("userName","小呆皮");
    request.setAttribute("userName","小呆呆");
    request.setAttribute("password","001217");
    User user = new User();
    user.setId(98);
    user.setName("小呆呆");
    user.setGender('男');
    request.setAttribute("user",user);
    List<String> stringList=new ArrayList<>();
    stringList.add("this");
    stringList.add("is");
    stringList.add("a");
    stringList.add("test");
    request.setAttribute("stringList",stringList);
%>

用户名：
${userName}
${requestScope.userName}
密码：
${password}
<br>
用户id：
${user.id}
用户名称：
${user.name}
用户性别：
${user["gender"]}
<br>
${stringList[0]}
${stringList[1]}
${stringList[2]}
${stringList[3]}
${stringList[4]}






</body>
</html>
