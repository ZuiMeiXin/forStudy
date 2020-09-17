<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <base href="<%=basePath%>">
    <title>添加新闻--管理后台</title>
    <link href="css/admin.css" rel="stylesheet" type="text/css"/>

</head>

<body>

<div id="main">
    <div>
        <iframe src="newspages/console_element/top.html" scrolling="no" frameborder="0" width="947px"
                height="180px"></iframe>
    </div>
    <div id="opt_list">
        <iframe src="newspages/console_element/left.html" scrolling="no" frameborder="0" width="130px"></iframe>

    </div>
    <div id="opt_area">
        <h1 id="opt_type"> 添加新闻： </h1>
        <form action="news.control?action=addnews" enctype="multipart/form-data" method="post">
            <p>
                <label> 主题 </label>
                <select name="ntid" id="select">
                    <option value="1">选择</option>
                    <%--                    <option value='1'> 国内</option>--%>
                </select>
            </p>
            <p>
                <label> 标题 </label>
                <input name="ntitle" type="text" class="opt_input"/>
            </p>
            <p>
                <label> 作者 </label>
                <input name="nauthor" type="text" class="opt_input"/>
            </p>
            <p>
                <label> 摘要 </label>
                <textarea name="nsummary" cols="40" rows="3"></textarea>
            </p>
            <p>
                <label> 内容 </label>
                <textarea name="ncontent" cols="70" rows="10"></textarea>
            </p>
            <p>
                <label> 上传图片 </label>
                <input name="file" type="file" class="opt_input"/>
            </p>
            <input name="action" type="hidden" value="addnews"/>
            <input type="submit" value="提交" class="opt_sub"/>
            <input type="reset" value="重置" class="opt_sub"/>
        </form>
    </div>
    <iframe src="newspages/console_element/bottom.html" scrolling="no" frameborder="0" width="947px"
            height="190px"></iframe>
</div>

<script src="js/jquery-3.5.1.js"></script>
<script>
    $(function () {
        $.ajax({
            "url": "topic.control",
            type: "get",
            data: {
                action: "ajax"
            },
            dataType: "json",
            success: function (data) {
                console.log("success");
                for (let i = 0;   i < data.length;    i++
                ) {
                    $("#select").append("<option value=" + data[i].tid + "> " + data[i].tname + "</option>")
                }

            },
            error: function (data) {
                console.log("error");
            }
        })





        // $.ajax({
        //     "url": "topic.control",
        //     type: "get",
        //     data: {
        //         action: "topicajax"
        //     },
        //     dataType: "html",
        //     success: function (data) {
        //         console.log("success");
        //             $("#select").append(data);
        //     },
        //     error: function (data) {
        //         console.log("error");
        //     }
        // })


        // $("#select").load("topic.control","action=topicajax");




    })

</script>


</body>
</html>
