<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ page import="com.hisoft.news.entity.News" %>
<%@ page import="com.hisoft.news.service.impl.NewsServiceImpl" %>
<%@ page import="com.hisoft.news.service.NewsService" %>
<%@ page import="com.hisoft.news.util.Page" %>
<%--<%@ include file="loginControl.jsp" %>--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>添加主题--管理后台</title>
    <base href="<%=basePath%>">
    <link href="css/admin.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div id="main">
    <div>
        <%--        <iframe src="newspages/console_element/top.html" scrolling="no" frameborder="0"--%>
        <%--                width="947px" height="180px"></iframe>--%>
        <%@include file="console_element/top.html" %>
    </div>
    <div id="opt_list">
        <%@include file="console_element/left.html" %>
        <%--        <iframe src="newspages/console_element/left.html" scrolling="no" frameborder="0"--%>
        <%--                width="130px"></iframe>--%>

    </div>

    <div id="opt_area">
        <ul class="classlist">

            <%--            <%--%>
            <%--                String currPageNostr = request.getParameter("currPageNo");--%>
            <%--                if (currPageNostr == null) {--%>
            <%--                    currPageNostr = "1";--%>
            <%--                }--%>
            <%--                int currPageNo = Integer.parseInt(currPageNostr);--%>
            <%--                NewsService newsService = new NewsServiceImpl();--%>
            <%--                Map<String, Object> map = (Map<String, Object>) newsService.queryIndexList(null, null, null, null, currPageNo);--%>
            <%--                request.setAttribute("map", map);--%>
            <%--            %>--%>


            <%--            <c:forEach items="${map}" var="entry">--%>
            <%--                <c:if test="${entry.key eq 'page'}">--%>
            <%--                    <c:set var="newspage" value="${entry.value}"/>--%>
            <%--                    <c:forEach items="${newspage.newsList}" var="news" varStatus="v">--%>
            <%--                                    <li class='space'> ${news.ntitle}<span> 作者：--%>
            <%--            	        ${news.nauthor}--%>
            <%--            	        &#160;&#160;&#160;&#160; <a href='news.control?action=tomodifynews&nid=${news.nid}'>修改</a> &#160;&#160;&#160;&#160; <a--%>
            <%--                                                href='javascript:checkdelete(${news.nid})'>删除</a> </span></li>--%>

            <%--                        <c:if test="${v.count%5 eq 0}">--%>

            <%--                            <li></li>--%>
            <%--                        </c:if>--%>
            <%--                    </c:forEach>--%>
            <%--                    <p align="right"> 当前页数:[${newspage.currPageNo}/${newspage.totalPageCount}]&nbsp;--%>
            <%--                        <a href='newspages/admin.jsp?currPageNo=1'>首页</a>--%>
            <%--                        <c:if test="${newspage.currPageNo > 1}">--%>
            <%--                        <a href="newspages/admin.jsp?currPageNo=${newspage.currPageNo-1}">上一页</a>--%>
            <%--                        </c:if>--%>
            <%--                        <c:if test="${newspage.currPageNo<newspage.totalPageCount}">--%>
            <%--                        <a href="newspages/admin.jsp?currPageNo=${newspage.currPageNo+1}">下一页</a>--%>
            <%--                        </c:if>--%>
            <%--                        <a href="newspages/admin.jsp?currPageNo=${newspage.totalPageCount}">末页</a>--%>
            <%--                    </p>--%>
            <%--                </c:if>--%>
            <%--            </c:forEach>--%>

        </ul>
    </div>
    <%--    <iframe src="newspages/console_element/bottom.html" scrolling="yes" frameborder="0"--%>
    <%--            width="947px" height="190px"></iframe>--%>
    <%@include file="console_element/bottom.html" %>
</div>
<script src="js/jquery-3.5.1.js"></script>
<script type="text/javascript">
    function checkdelete(nid) {
        if (confirm("你确定要删除此条新闻以及新闻下的所有评论吗？")) {
            location.href = "news.control?action=deletenews&nid=" + nid;
        }
    }

    $(function () {
        // $.ajax({
        //     url: "http://localhost:8080/news/news.control",
        //     type: "post",
        //     data: {
        //         action: "ajax"
        //     },
        //     dataType: "json",
        //     success: function (data) {
        //         console.log("succeed");
        //         console.log(data)
        //         for (let i = 0; i < data.length; i++) {
        //             $("#opt_area>.classlist").append("<li class='space'> " + data[i].ntitle + "<span> 作者：\n" +
        //                 "            \t        " + data[i].nauthor + "\n" +
        //                 "            \t        &#160;&#160;&#160;&#160; <a href='news.control?action=tomodifynews&nid=" + data[i].nid + "'>修改</a> &#160;&#160;&#160;&#160; <a\n" +
        //                 "                                                href='javascript:checkdelete(" + data[i].nid + ")'>删除</a> </span></li>");
        //         }
        //     }, error: function (errorInfo) {
        //         console.log("error");
        //         console.log(errorInfo)
        //     }
        // })

        //将所有的标题展示出来
        $.getJSON("news.control", "action=ajax", callback)

        function callback(data) {
            for (let i = 0; i < data.length; i++) {
                $("#opt_area> .classlist").append("<li class='space'> " + data[i].ntitle + "<span> 作者：\n" +
                    "            \t        " + data[i].nauthor + "\n" +
                    "            \t        &#160;&#160;&#160;&#160; <a href='news.control?action=tomodifynews&nid=" + data[i].nid + "'>修改</a> &#160;&#160;&#160;&#160; <a\n" +
                    "                                                href='javascript:checkdelete(" + data[i].nid + ")'>删除</a> </span></li>");
                if ((i + 1) % 5 == 0) {
                    $("#opt_area> .classlist").append("<li class='space'></li>");
                }
            }
        }

        // $.ajax({
        //     url: "http://localhost:8080/news/news.control",
        //     type: "post",
        //     data: {
        //         action: "ajax"
        //     },
        //     dataType: "html",
        //     success: function (data) {
        //         console.log("succeed");
        //         console.log(data)
        //             $("#opt_area>.classlist").append(data);
        //     }, error: function (errorInfo) {
        //         console.log("error");
        //         console.log(errorInfo)
        //     }
        // })

        // $("#opt_area>.classlist").load("news.control","action=ajax");

        /*添加主题*/
        //    首先加载添加主题的页面 局部刷新
        $("#addTopicLink").click(function () {
            $("#opt_area").load("newspages/topic_add.jsp #opt_area");

        });
        //    执行真正的修改主题
        //    使用这种方式是不能执行的因为这些内容是动态添加进来的
        //     $("#addTopicSubmit").click(function () {
        //
        //     })
        $("#opt_area").on("click", "#addTopicSubmit", function () {
            $.post("topic.control", $("#addTopicForm").serialize(), afterAddTopic, "json");

            function afterAddTopic(data) {
                //成功则显示主题列表
                //失败显示信息
                if (data.message == "success") {
                    alert("添加主题成功！");
                    $("#opt_area").html("");
                    $("#opt_area").append("<ul class='classlist'></ul>");
                    $("#opt_area .classlist").load("topic.control", "action=topiclist");
                } else {
                    alert(data.message);
                }

            }
        })
        /*修改主题*/

        $("#showTopicList").click(function () {
            $("#opt_area").html("");
            $("#opt_area").append("<ul class='classlist'></ul>");
            $("#opt_area .classlist").load("topic.control", "action=topiclist");
        })

        //修改 加载修改表单
        //         $("#addTopicLink").click(function () {
        //             $("#opt_area").load("newspages/topic_modify.jsp #opt_area");
        //
        //         });
        $("#opt_area").on("click", ".classlist li .tomodifyLink", function () {
            var arr = this.id.split(":");
            var tid = arr[0];
            var tname = arr[1];
            $("#opt_area").load("newspages/topic_modify.jsp #opt_area", "tid=" + tid + "&tname=" + tname);
        })
        //    执行修改
        $("#opt_area").on("click", "#updateTopicButton", function () {
            $.post("topic.control", $("#updateTopicForm").serialize(), afterUpdateTopic, "json");

            function afterUpdateTopic(data) {
                if (data.message == "success") {
                    alert("修改主题成功");
                    $("#opt_area").html("");
                    $("#opt_area").append("<ul class='classlist'></ul>");
                    $("#opt_area .classlist").load("topic.control", "action=topiclist");
                } else {
                    alert(data.message)
                }

            }

        });
        //删除主题
        $("#opt_area").on("click", ".classlist li .deleteLink", function () {
            var p = $(this).parent();
            $.getJSON("topic.control", "action=delete&tid=" + this.id, function (data) {
                if (data.message == "success"){
                    alert("删除成功");
                    p.remove();
                }else{
                    alert(date.message)
                }
            })
        })


    })

</script>
</body>
</html>

	