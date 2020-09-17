<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ page import="com.hisoft.news.entity.News" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>添加主题--管理后台</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <title>新闻中国</title>
    <link href="../css/admin.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div id="main">

    <div>
        <iframe src="../newspages/console_element/top.html" scrolling="no" frameborder="0" width="947px"
                height="180px"></iframe>
    </div>
    <div id="opt_list">
        <iframe src="../newspages/console_element/left.html" scrolling="no" frameborder="0" width="130px"></iframe>
    </div>
    <div id="opt_area">
        <h1 id="opt_type"> 修改新闻： </h1>
        <form action="" method="post">
            <p>
                <label> 主题 </label>
                <select name="ntid">
                    <option value='1' selected="selected">国内</option>
                    <option value='2'>国际</option>
                    <option value='3' selected="selected">军事</option>
                    <option value='4'>体育</option>
                </select>
                <input type="hidden" name="nid" value=""/>
            </p>
            <p>
                <label> 标题 </label>
                <input name="ntitle" type="text" class="opt_input" value=${news.ntitle}/>
            </p>
            <p>
                <label> 作者 </label>
                <input name="nauthor" type="text" class="opt_input" value=${news.nauthor}"/>
            </p>
            <p>
                <label> 摘要 </label>
                <textarea name="nsummary" cols="40" rows="3"><${news.nsummary}</textarea>
            </p>
            <p>
                <label> 内容 </label>
                <textarea name="ncontent" cols="70" rows="10">
                    ${news.ncontent}
                </textarea>
            <p>
                <label> 上传图片 </label>
                <input name="file" type="file" class="opt_input"/>
            </p>
            <input type="submit" value="提交" class="opt_sub"/>
            <input type="reset" value="重置" class="opt_sub"/>
        </form>
        <p></p>
        <h1 id="opt_type">
            修改新闻评论：
        </h1>
        <table width="80%" align="left">
            <tr>
                <td colspan="6">
                    <hr/>
                </td>
            </tr>

            <tr>
                <td> 留言人：</td>
                <td>无花果</td>
                <td> IP：</td>
                <td>127.0.0.1</td>
                <td> 留言时间：</td>
                <td>2012-08-29 03：03：45.0</td>
                <td><a href="#">删除</a></td>
            </tr>
            <tr>
                <td colspan="6">法网恢恢，疏而不露！</td>
            </tr>
            <tr>
                <td colspan="6">
                    <hr/>
                </td>
            </tr>
        </table>
    </div>
</div>
<iframe src="../newspages/console_element/bottom.html" scrolling="no" frameborder="0" width="947px"
        height="190px"></iframe>
</div>
</body>
</html>	