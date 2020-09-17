<%@ page import="com.servlet.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>jstl</title>
</head>
<body>
<%
    User user = new User();
    request.setAttribute("user",user);
%>


<c:set target="${user}" property="name" value="小呆呆"/>
用户名：${user.name}
<br>
<%--c:out标签可以设置默认值--%>
性别：<c:out value="${user.id}" default="123"/>

<%--标签--%>
<p>${"<a href='www.baidu.com'>百度</a>"}</p>


<br>

<%--remove标签就是将作用域中的值删除--%>
<!-- 设置之前应该是空值 -->
设置变量之前的值是：msg=<c:out  value="${msg}"  default="null" /><br/>
<!-- 给变量msg设值 -->
<c:set  var="msg"  value="Hello  World!"  scope="page"></c:set>
<!-- 此时msg的值应该是上面设置的“Hello World!” -->
设置新值以后：msg=<c:out  value="${msg}"></c:out><br/>
<!-- 把 msg变量从page范围内移除-->
<c:remove  var="msg"  scope="page" />
<!-- 此时msg的值应该显示null -->
移除变量msg以后：msg=<c:out  value="${msg}"  default="null"></c:out>



</body>
</html>
