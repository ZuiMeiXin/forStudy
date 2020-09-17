<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ page import="com.hisoft.news.entity.News" %>
<%@ page import="com.hisoft.news.entity.Comment" %>
<%@ page import="javax.swing.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%--<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">--%>
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>新闻中国</title>
    <link href="css/read.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript">
        function check() {
            var cauthor = document.getElementById("cauthor");
            var content = document.getElementById("ccontent");
            if (cauthor.value == "") {
                alert("用户名不能为空！！");
                return false;
            } else if (content.value == "") {
                alert("评论内容不能为空！！");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<div id="header">
    <div id="top_login">
        <label> 登录名 </label>
        <input type="text" id="uname" value="" class="login_input"/>
        <label> 密&#160;&#160;码 </label>
        <input type="password" id="upwd" value="" class="login_input"/>
        <input type="button" class="login_sub" value="登录" onclick="login()"/>
        <label id="error"> </label>
        <a href="index.jsp" class="login_link">返回首页</a> <img src="images/friend_logo.gif" alt="Google"
                                                             id="friend_logo"/></div>
    <div id="nav">
        <div id="logo"><img src="images/logo.jpg" alt="新闻中国"/></div>
        <div id="a_b01"><img src="images/a_b01.gif" alt=""/></div>
        <!--mainnav end-->
    </div>
</div>
<div id="container">

    <div class="sidebar">
        <h1><img src="images/title_1.gif" alt="国内新闻"/></h1>
        <div class="side_list">
            <ul>
                <c:forEach items="${list1}" var="news1">
                    <li><a href='news.control?action=readnews&nid=${news1.nid}'><b>${news1.ntitle}
                    </b></a></li>
                </c:forEach>

            </ul>
        </div>
        <h1><img src="images/title_2.gif" alt="国际新闻"/></h1>
        <div class="side_list">
            <ul>
                <c:forEach items="${list2}" var="news2">
                    <li><a href='news.control?action=readnews&nid=${news2.nid}'><b>${news2.ntitle}
                    </b></a></li>
                </c:forEach>
            </ul>
        </div>
        <h1><img src="images/title_3.gif" alt="娱乐新闻"/></h1>
        <div class="side_list">
            <ul>
                <c:forEach items="${list3}" var="news3">

                    <li><a href='news.control?action=readnews&nid=${news3.nid}'><b>${news3.ntitle}
                    </b></a></li>
                </c:forEach>
            </ul>
        </div>
    </div>
    <div class="main">
        <div class="class_type"><img src="images/class_type.gif" alt="新闻中心"/></div>
        <div class="content">
            <ul class="classlist">
                <table width="80%" align="center">
                    <tr width="100%">
                        <td colspan="2" align="center">${news.ntitle}
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <hr/>
                        </td>
                    </tr>
                    <tr>
                        <td align="center">发布时间：${news.ncreateDate}
                        </td>
                        <td align="left">作者：${news.nauthor}
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            ${news.ncontent}
                    </tr>
                    <tr>
                        <td colspan="2">
                            <hr/>
                        </td>
                    </tr>
                </table>
            </ul>
            <ul class="classlist">
                <table width="80%" align="center" id="commenttable">
                    <c:if test="${empty news.comment}">
                        <tr>
                            <td colspan="6"> 暂无评论！</td>
                        </tr>
                        <tr>
                            <td colspan="6">
                                <hr/>
                            </td>
                        </tr>
                    </c:if>
                    <c:if test="${not empty news.comment}">
                        <c:forEach items="${news.comment}" var="comment1">
                            <tr>
                                <td>留言人：</td>
                                <td>${comment1.cauthor}
                                </td>
                                <td>IP:</td>
                                <td>${comment1.cip}
                                </td>
                                <td>留言时间：</td>
                                <td>${comment1.cdate}
                                </td>
                            </tr>
                            <tr>
                                <td colspan="6">${comment1.ccontent}
                                </td>
                            </tr>
                            <tr>
                                <td colspan="6">
                                    <hr>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:if>
                </table>
            </ul>
            <ul class="classlist">
                <%--                <form action="news.control?action=addComment" method="post" onsubmit="return check()">--%>
                <form action="" method="post" id="commentform">

                    <input type="hidden" name="nid" value="${news.nid}"/>
                    <table width="80%" align="center"/>
                    <tr>
                        <td> 评 论</td>
                    </tr>
                    <tr>
                        <td> 用户名：</td>
                        <td>
                            <c:if test="${not empty admin}">
                                <input id="cauthor" name="cauthor" value="${admin}"
                                       readonly="readonly" style="border: 0px;"/>
                            </c:if>
                            <c:if test="${ empty admin}">
                                <input type="cauthor" name="cauthor" value="这家伙很懒什么也没留下"/>
                                IP：
                                <input name="cip" value="${pageContext.request.remoteAddr}" readonly="readonly"
                                       style="border:0px;"/>
                            </c:if>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"><textarea name="ccontent" cols="70" rows="10"></textarea>
                        </td>
                    </tr>
                    >

                    <td><input name="submit" id="commentsubmint" value="发  表" type="button"/>
                    </td>
                    </table>
                </form>
            </ul>
        </div>
    </div>
</div>
<div id="footer">
    <iframe src="newspages/index-elements/index_bottom.html" scrolling="no" frameborder="0" width="947px"
            height="190px"></iframe>
</div>
<script src="js/jquery-3.5.1.js"></script>
<script>

    $(function () {
        var $form = $("#commentform");
        $("#commentsubmint").click(function () {
            var array = $form.serializeArray();
            var param = $.param(array);
            $.post("news.control?action=addComment", param, afterComment, "json");
            function afterComment(data) {//{"result":"success/error","cdate":"添加日期"}
                if (data.result == "success") {
                    var $newComment = $("<tr>\n" +
                        "                                <td>留言人：</td>\n" +
                        "                                <td>cauthor\n" +
                        "                                </td>\n" +
                        "                                <td>IP:</td>\n" +
                        "                                <td>cip\n" +
                        "                                </td>\n" +
                        "                                <td>留言时间：</td>\n" +
                        "                                <td>" + data.cdate + "\n" +
                        "                                </td>\n" +
                        "                            </tr>\n" +
                        "                            <tr>\n" +
                        "                                <td colspan=\"6\">ccontent\n" +
                        "                                </td>\n" +
                        "                            </tr>\n" +
                        "                            <tr>\n" +
                        "                                <td colspan=\"6\">\n" +
                        "                                    <hr>\n" +
                        "                                </td>\n" +
                        "                            </tr>");
                    $(array).each(function () {
                        // $newComment.find("td:contains('" + this.name + "')").text(this.value);
                        //td单元格中包含
                        $newComment.find("td:contains('" + this.name + "')").text(this.value);
                    })
                    $("#commenttable").prepend($newComment);
                } else {
                    alert("failed")
                }
            }
        })
    })


</script>

</body>
</html>
