<%@ page language="java" import="java.util.*,java.sql.*,org.jbit.news.entity.*" pageEncoding="utf-8" %>
<%@ page import="com.hisoft.news.entity.Topic" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <title>编辑主题--管理后台</title>
    <script type="text/javascript">
        function check() {
            var tname = document.getElementById("tname");

            if (tname.value == "") {
                alert("请输入主题名称！！");
                tname.focus();
                return false;
            }
            return true;
        }

        function chenckdelete(tid) {
            if (confirm("你确定要删除吗")) {
                location.href = "topic.control?action=delete&tid=" + tid;
            }
        }


    </script>
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
        <ul class="classlist">
            <%--            <c:forEach var="topic" items="${topicList}">--%>
<%--                                    <li>--%>
<%--                                        ${topic.tname}--%>
<%--                                        &nbsp;&nbsp;&nbsp;&nbsp; <a href="topic.control?action=tomodify&tid=${topic.tid}">修改</a>--%>
<%--                                        &nbsp;&nbsp;&nbsp;&nbsp; <a href="javascript:chenckdelete(${topic.tid})">删除</a>--%>
<%--                                    </li>--%>
            <%--            </c:forEach>--%>
        </ul>
    </div>
    <iframe src="newspages/console_element/bottom.html" scrolling="no" frameborder="0" width="947px"
            height="190px"></iframe>
</div>

<script src="js/jquery-3.5.1.js"></script>
<script>
    $(function () {
        // $.ajax({
        //     url:"topic.control",
        //     data:{
        //         action:"ajax"
        //     },
        //     type:"post",
        //     dataType:"html",
        // success:function (data) {
        //     console.log("success");
        //     console.log(data[data.length-1].tid)
        //     for (let i = 0; i < data.length; i++) {
        //
        //         $(".classlist").append("<li>\n" +
        //             "                            "+data[i].tname+"\n" +
        //             "                            &nbsp;&nbsp;&nbsp;&nbsp; <a href=\"topic.control?action=tomodify&tid="+data[i].tid+"\">修改</a>\n" +
        //             "                            &nbsp;&nbsp;&nbsp;&nbsp; <a href=\"javascript:chenckdelete("+data[i].tid+")\">删除</a>\n" +
        //             "                        </li>")
        //     }
        //         },
        //         error:function (data) {
        //             console.log("error");
        //         }
        //
        //     })

            // $.getJSON("topic.control", "action=ajax", callback);
            //
            // function callback(data) {
            //     for (let i = 0; i < data.length; i++) {
            //
            //         $(".classlist").append("<li>\n" +
            //             "                            " + data[i].tname + "\n" +
            //             "                            &nbsp;&nbsp;&nbsp;&nbsp; <a href=\"topic.control?action=tomodify&tid=" + data[i].tid + "\">修改</a>\n" +
            //             "                            &nbsp;&nbsp;&nbsp;&nbsp; <a href=\"javascript:chenckdelete(" + data[i].tid + ")\">删除</a>\n" +
            //             "                        </li>")
            //     }
            // }




        $.ajax({
            url:"topic.control",
            data:{
                action:"ajax"
            },
            type:"post",
            dataType:"html",
        success:function (data) {
        // console.log("success");
        // console.log(data[data.length-1].tid)

            $(".classlist").append(data)
            },
            error:function (data) {
                console.log("error");
            }
        })

        // $(".classlist").load("topic.control","action=ajax")













    })


</script>

</body>

</html>	