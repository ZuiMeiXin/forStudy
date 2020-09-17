<%@ page import="com.servlet.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>foreach</title>
</head>
<body>
<%
    List<User> users = new ArrayList<>();
    users.add(new User(1, "小呆呆", '男'));
    users.add(new User(2, "小呆呆", '男'));
    users.add(new User(3, "小呆呆", '男'));
    users.add(new User(4, "小呆呆", '男'));
    users.add(new User(5, "小呆呆", '男'));
    users.add(new User(6, "小呆呆", '男'));
    users.add(new User(7, "小呆呆", '男'));
    users.add(new User(8, "小呆呆", '男'));
    users.add(new User(9, "小呆呆", '男'));
    request.setAttribute("users", users);


    Map<String ,String > map = new HashMap<>();
    map.put("name","小呆呆");
    map.put("age","18");
    map.put("address","河南");
    map.put("gender","男");
    request.setAttribute("map",map);
%>

<ul>
    <c:forEach items="${map}" var="entry">
        <li>${entry.key} ${entry.value}</li>
    </c:forEach>

</ul>


<table>
    <tr>
        <td>序号</td>
        <td>id</td>
        <td>用户名</td>
        <td>性别</td>
    </tr>
    <c:forEach items="${users}" var="user" varStatus="v">
        <tr
                <c:if test="${v.count%2 eq 0}">
                    style="background-color: red"
                </c:if>

        >
            <td>${v.index}</td>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.gender}</td>
        </tr>
    </c:forEach>

</table>



</body>
</html>
