<%--
  Created by IntelliJ IDEA.
  User: HiSoft
  Date: 2020/7/22
  Time: 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=GBK" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>test</title>
</head>
<body>

<%
    String[] name={"�꿨���Ϳ�"," ����������","���űȹ�","��ķ������","�����ʺá�"};
    for (String s : name) {
        %>
<%=s%><br/>
<%
    }
%>



</body>
</html>
