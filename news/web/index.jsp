<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>新闻中国</title>
    <link href="css/main.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div id="header">
    <c:if test="${empty map}">
        <jsp:forward page="news.control?action=index&tid="/>
        return;
    </c:if>
    <div id="top_login">

        <form action="dologin.control" method="post">
            <label> 登录名 </label>

            <input type="text" id="uname" name="uname"
                   value="${param.uname}"
                   class="login_input"/>
            <label> 密&#160;&#160;码 </label>
            <input type="text" id="upwd" name="upwd"
                   value="${param.upwd}" class="login_input"/>
            <input type="submit" class="login_sub" value="登录"/>
            <label id="error">${message}
            </label>
            <img src="images/friend_logo.gif" alt="Google" id="friend_logo"/></form>
    </div>
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
                <%--                国内新闻--%>
                <c:forEach items="${map}" var="entry">
                    <c:if test="${entry.key eq 'list1'}">
                        <c:forEach items="${entry.value}" var="news">
                            <li><a href='news.control?action=readnews&nid=${news.nid}'><b>${news.ntitle}
                            </b></a></li>
                        </c:forEach>
                    </c:if>
                </c:forEach>
            </ul>
        </div>
        <h1><img src="images/title_2.gif" alt="国际新闻"/></h1>
        <div class="side_list">
            <ul>
                <%--                国际新闻--%>
                <c:forEach items="${map}" var="entry">
                    <c:if test="${entry.key eq 'list2'}">
                        <c:forEach items="${entry.value}" var="news">
                            <li><a href='news.control?action=readnews&nid=${news.nid}'><b>${news.ntitle}
                            </b></a></li>
                        </c:forEach>
                    </c:if>
                </c:forEach>
            </ul>
        </div>
        <h1><img src="images/title_3.gif" alt="娱乐新闻"/></h1>
        <div class="side_list">
            <ul>
                <c:forEach items="${map}" var="entry">
                    <c:if test="${entry.key eq 'list3'}">
                        <c:forEach items="${entry.value}" var="news">
                            <li><a href='news.control?action=readnews&nid=${news.nid}'><b>${news.ntitle}
                            </b></a></li>
                        </c:forEach>
                    </c:if>
                </c:forEach>
            </ul>
        </div>
    </div>
    <%--    下面是 新闻中心 包括所以的新闻标题和新闻内容--%>
    <div class="main">
        <div class="class_type"><img src="images/class_type.gif" alt="新闻中心"/></div>
        <div class="content">
            <ul class="class_date">
                <li id='class_month'>
                    <c:forEach items="${applicationScope.allTopics}" var="alltopic">
                    <a href='news.control?action=index&tid=${alltopic.tid}'><b>${alltopic.tname}
                        </c:forEach>
            </ul>
            <ul class="classlist">
                <%--                下面是新闻的主体部分--%>
                ======================================================


                <%--                <c:forEach items="${map}" var="entry">--%>
                <%--                    <c:if test="${entry.key eq 'page'}">--%>
                <%--                        <c:if test="${not empty entry.value}">--%>
                <%--                            <c:set var="newspage1" value="${entry.value}"/>--%>
                <%--                            <c:forEach items="${newspage1.newsList}" var="newspage">--%>
                <%--                                                <li>--%>
                <%--                                                    <a href='news.control?action=readnews&nid=${newspage.nid}'>${newspage.ntitle}--%>
                <%--                                                    </a>--%>
                <%--                                                    <span><fmt:formatDate value="${newspage.ncreateDate}"--%>
                <%--                                                                          pattern="yyyy-MM-dd HH:mm:ss"/> </span>--%>
                <%--                                                </li>--%>
                <%--                                <li class='space'></li>--%>
                <%--                            </c:forEach>--%>
                <%--                            <p align="right"> 当前页数:[${newspage1.currPageNo}/${newspage1.totalPageCount}]&nbsp;--%>
                <%--                                <a href='news.control?action=index&currPageNo=1' &tid=${param.tid}>首页</a>--%>
                <%--                                <c:if test="${newspage1.currPageNo gt 1}">--%>
                <%--                                    <a href="news.control?action=index&currPageNo=${newspage1.currPageNo - 1}&tid=${param.tid}">上一页</a>--%>
                <%--                                </c:if>--%>
                <%--                                <c:if test="${newspage1.currPageNo lt newspage1.totalPageCount}">--%>
                <%--                                    <a href="news.control?action=index&currPageNo=${newspage1.currPageNo + 1}&tid=${param.tid}">下一页</a>--%>
                <%--                                </c:if>--%>
                <%--                                <a href="news.control?action=index&currPageNo=${newspage1.totalPageCount}&tid=${param.tid}">末页</a>--%>
                <%--                            </p>--%>
                <%--                        </c:if>--%>
                <%--                    </c:if>--%>
                <%--                </c:forEach>--%>
            </ul>
        </div>
        <div class="picnews">
            <ul>
                <li><a href="#"><img src="images/Picture1.jpg" width="249" alt=""/> </a><a href="#">幻想中穿越时空</a></li>
                <li><a href="#"><img src="images/Picture2.jpg" width="249" alt=""/> </a><a href="#">国庆多变的发型</a></li>
                <li><a href="#"><img src="images/Picture3.jpg" width="249" alt=""/> </a><a href="#">新技术照亮都市</a></li>
                <li><a href="#"><img src="images/Picture4.jpg" width="249" alt=""/> </a><a href="#">群星闪耀红地毯</a></li>
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
        getPage(null, 1);
        function getPage(tid, currPageNo) {
            $.getJSON("news.control", "action=pageNews&tid=" + tid + "&currPageNo=" + currPageNo, showPage);
            function showPage(data) {
                var tid = data[0].tid;//tid
                var page = data[1].newsList;
                $(".classlist").html("");
                $(page).each(function () {

                    $(".classlist").append("<li>\n" +
                        "  <a href='news.control?action=readnews&nid=" + this.nid + "'>" + this.ntitle + "\n" +
                        "   </a>\n" +
                        "   <span>" + this.ncreateDate +
                        "  </span>\n" +
                        "  </li>"
                    )
                });

                 $(".classlist").append("<p align='right'></p>");
                var pagebar =$(".classlist p")
                pagebar.append("当前页数:[" + data[1].currPageNo + "/" + data[1].totalPageCount + "]&nbsp;");
                pagebar.append($("<a href='javascript:;' >首页</a>")).click(function () {
                    getPage(tid, 1);
                });

                if (data[1].currPageNo < data[1].totalPageCount) {
                    pagebar.append($("<a href='javascript:;' >下一页</a>")).click(function () {
                        getPage(tid, data[1].currPageNo + 1);
                    });
                }
                if (data[1].currPageNo > 1) {
                    pagebar.append($("<a href='javascript:;' >上一页</a>")).click(function () {
                        getPage(tid, data[1].currPageNo - 1);
                    });
                }


                pagebar.append($("<a href='javascript:;' >末页</a>")).click(function () {
                    getPage(tid, data[1].totalPageCount);
                });

            }
        }



        $("#class_month a").each(function () {
            $(this).click(function () {
                getPage(this.tid, 1);
            })
        })

    })


</script>

</body>
</html>
	