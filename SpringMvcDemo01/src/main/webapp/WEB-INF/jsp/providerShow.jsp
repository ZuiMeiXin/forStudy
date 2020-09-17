<%--
  Created by IntelliJ IDEA.
  User: HiSoft
  Date: 2020/8/28
  Time: 19:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>显示供应商信息</title>
</head>
<body>
供应商编码：${provider.proCode}<br>
供应商名称：${provider.proName}<br>
供应商详细描述：${provider.proDesc}<br>
供应商联系人：${provider.proContact}<br>
联系电话：${provider.proPhone}<br>
地址：${provider.proAddress}<br>
传真：${provider.proFax}<br>
创建者：${provider.createdBy}<br>
<%--创建时间：${provider.creationDate}<br>--%>

</body>
</html>
