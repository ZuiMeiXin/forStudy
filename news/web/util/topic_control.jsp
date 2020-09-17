<%@ page import="com.hisoft.news.entity.Topic" %>
<%@ page import="com.hisoft.news.dao.impl.TopicDaoImpl" %>
<%@ page import="com.hisoft.news.dao.TopicDao" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hisoft.news.service.TopicService" %>
<%@ page import="com.hisoft.news.service.impl.TopicServiceImpl" %>
<%@ page import="com.hisoft.news.util.JdbcUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ include file="../newspages/loginControl.jsp" %>--%>
<html>
<head>
    <title>主题控制页</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
    String tname = request.getParameter("tname");
    String action = request.getParameter("action");
    TopicDao topicDao = new TopicDaoImpl(JdbcUtil.getConnection());
    TopicService topicService = new TopicServiceImpl();
    if ("addtopic".equals(action)) {
        if (tname.equals("")) {
            request.setAttribute("message", "主题不能为空！");
            request.getRequestDispatcher("../newspages/topic_add.jsp").forward(request, response);
            return;
        }
        int result = topicService.addTopicByTname(tname);
        if (result == -1) {
            request.setAttribute("message", "主题已经存在");
            request.setAttribute("tname", tname);
            request.getRequestDispatcher("../newspages/topic_add.jsp").forward(request, response);
            return;
        }
        if (result == 1) {
            out.println("<script>alert('添加成功');location.href='../topic.control?action=topiclist';</script>");
        }
        if (result == 0) {
            out.println("<script>alert('添加失败');location.href='../newspages/topic_add.jsp';</script>");
        }
    } else if ("topiclist".equals(action)) {//判断是否为编辑主题
        List<Topic> allTopics = topicService.findAllTopics();
        request.setAttribute("topicList", allTopics);
        request.getRequestDispatcher("../newspages/topic_list.jsp").forward(request, response);
    } else if ("tomodify".equals(action)) {
        //获取要修改的记录信息
        String tidstr = request.getParameter("tid");
        int tid = (int) (tidstr == null ? -1 : Integer.parseInt(tidstr));
        Topic topic = null;
        if (tid != -1) {
            topic = topicService.findTopicById(tid);
        }
        request.setAttribute("topic", topic);
//        转发到修改页面
        request.getRequestDispatcher("../newspages/topic_modify.jsp").forward(request, response);
    } else if ("updatetopic".equals(action)) {//判断是否为修改主题
        int tid = Integer.parseInt(request.getParameter("tid"));
        Topic topic = new Topic(tname,tid);
        int updateTopic = topicService.updateTopic(tname, tid);
        if (updateTopic==-1) {
            request.setAttribute("topic", topic);
            request.setAttribute("message", "主题已经存在，请重新输入");
            request.getRequestDispatcher("../newspages/topic_modify.jsp").forward(request, response);
            return;
        }
        if (updateTopic == 1) {
            out.println("<script>alert('修改成功');location.href='../topic.control?action=topiclist'</script>");
        }
        if (updateTopic==0){
            request.setAttribute("message", "修改失败,联系管理员");
            request.getRequestDispatcher("../newspages/topic_modify.jsp").forward(request, response);
        }
    } else if ("delete".equals(action)) {
        int tid = Integer.parseInt(request.getParameter("tid"));
        int result = topicService.deleteTopicByTid(tid);
        if (result == -1) {
            out.println("<script>alert('主题下有新闻 无法删除');location.href='../topic.control?action=topiclist'</script>");
            return;
        }
        if (result == 1) {
            out.println("<script>alert('删除成功');location.href='../topic.control?action=topiclist'</script>");
        }
        if (result == -2) {
            out.println("<script>alert('删除失败，联系管理员');</script>");
        }
    }
%>


</body>
</html>
