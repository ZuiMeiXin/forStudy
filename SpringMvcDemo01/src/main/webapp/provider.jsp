<%--
  Created by IntelliJ IDEA.
  User: HiSoft
  Date: 2020/8/28
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    /showProvider.html">
    供应商编码：<input type="text" name="proCode"><br>
    供应商名称：<input type="text" name="proName"><br>
    供应商详细描述：<input type="text" name="proDesc"><br>
    供应商联系人：<input type="text" name="proContact"><br>
    联系电话：<input type="text" name="proPhone"><br>
    地址：<input type="text" name="proAddress"><br>
    传真：<input type="text" name="proFax"><br>
    创建者：<input type="text" name="createdBy"><br>
    <%--    创建时间：<input type="text" name="creationDate"><br>--%>
    <input type="submit" value="提交">
    </form>

    </body>
</html>
