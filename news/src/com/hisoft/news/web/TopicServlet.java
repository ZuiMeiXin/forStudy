package com.hisoft.news.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.hisoft.news.dao.TopicDao;
import com.hisoft.news.dao.impl.TopicDaoImpl;
import com.hisoft.news.entity.Topic;
import com.hisoft.news.service.TopicService;
import com.hisoft.news.service.impl.TopicServiceImpl;
import com.hisoft.news.util.JdbcUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class TopicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();//上面两行的顺序必须放在前面 否则会出现乱码的问题
        String tname = request.getParameter("tname");
        String action = request.getParameter("action");
        TopicDao topicDao = new TopicDaoImpl(JdbcUtil.getConnection());
        TopicService topicService = new TopicServiceImpl();
        if ("addtopic".equals(action)) {
            if (tname.equals("")) {
                out.println("{\"message\":\"主题不能为空！\"}");
//                request.setAttribute("message", "主题不能为空！");
//                request.getRequestDispatcher("newspages/topic_add.jsp").forward(request, response);
                return;
            }
            int result = topicService.addTopicByTname(tname);
            if (result == -1) {
                out.println("{\"message\":\"主题已经存在\"}");
//                request.setAttribute("message", "主题已经存在");
//                request.setAttribute("tname", tname);
//                request.getRequestDispatcher("newspages/topic_add.jsp").forward(request, response);
                return;
            }
            if (result == 1) {
                List<Topic> allTopics = topicService.findAllTopics();
                request.getServletContext().setAttribute("allTopics", allTopics);
                out.println("{\"message\":\"success\"}");
//                out.println("<script>alert('添加成功');location.href='topic.control?action=topiclist';</script>");
            }
            if (result == 0) {
                out.println("{\"message\":\"添加失败！\"}");
//                out.println("<script>alert('添加失败');location.href='newspages/topic_add.jsp';</script>");
            }
        } else if ("topiclist".equals(action)) {//判断是否为编辑主题
            List<Topic> allTopics = topicService.findAllTopics();

            StringBuffer sb = new StringBuffer();
            for (Topic topic : allTopics) {
                sb.append("<li>\n" + topic.getTname() +
                        " &nbsp;&nbsp;&nbsp;&nbsp; <a href=\"javasript:;\" id=" + topic.getTid() + ":" + topic.getTname() + " class=\"tomodifyLink\">修改</a>\n" +
                        "     &nbsp;&nbsp;&nbsp;&nbsp; <a href=\"javascript:;\" id=" + topic.getTid()+ " class=\"deleteLink\">删除</a>\n" +
                        "</li>");
            }
            out.println(sb.toString());

//            request.setAttribute("topicList", allTopics);
//            request.getRequestDispatcher("newspages/topic_list.jsp").forward(request, response);
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
//            request.getRequestDispatcher("newspages/topic_modify.jsp").forward(request, response);
        } else if ("updatetopic".equals(action)) {//判断是否为修改主题
            int tid = Integer.parseInt(request.getParameter("tid"));
            Topic topic = new Topic(tname, tid);
            int updateTopic = topicService.updateTopic(tname, tid);
            if (updateTopic == -1) {
                request.setAttribute("topic", topic);
                out.println("{\"message\":\"主题已经存在，请重新输入\"}");
//                request.setAttribute("message", "主题已经存在，请重新输入");
//                request.getRequestDispatcher("newspages/topic_modify.jsp").forward(request, response);
                return;
            }
            if (updateTopic == 1) {
                List<Topic> allTopics = topicService.findAllTopics();

                out.println("{\"message\":\"success\"}");

//                request.getServletContext().setAttribute("allTopics", allTopics);
//                out.println("<script>alert('修改成功');location.href='topic.control?action=topiclist'</script>");
            }
            if (updateTopic == 0) {
                out.println("{\"message\":\"修改失败,联系管理员\"}");
//                request.setAttribute("message", "修改失败,联系管理员");
//                request.getRequestDispatcher("newspages/topic_modify.jsp").forward(request, response);
            }
        } else if ("delete".equals(action)) {
            int tid = Integer.parseInt(request.getParameter("tid"));
            int result = topicService.deleteTopicByTid(tid);
            if (result == -1) {
                out.println("{\"message\":\"主题下有新闻 无法删除\"}");
//                out.println("<script>alert('主题下有新闻 无法删除');location.href='topic.control?action=topiclist'</script>");
                return;
            }
            if (result == 1) {
                List<Topic> allTopics = topicService.findAllTopics();
                request.getServletContext().setAttribute("allTopics", allTopics);
                out.println("{\"message\":\"success\"}");
//                out.println("<script>alert('删除成功');location.href='topic.control?action=topiclist'</script>");
            }
            if (result == -2) {
                out.println("{\"message\":\"删除失败，联系管理员\"}");
//                out.println("<script>alert('删除失败，联系管理员');</script>");
            }
        } else if ("ajax".equals(action)) {
            List<Topic> allTopiclist = topicService.findAllTopics();

            String str = JSON.toJSONString(allTopiclist,
                    SerializerFeature.WriteNullStringAsEmpty,
                    SerializerFeature.WriteNullListAsEmpty
            );
            out.println(str);


//            StringBuffer str = new StringBuffer("[");
//            Topic topic = null;
//            for (int i = 0; i < allTopiclist.size(); i++) {
//                topic = allTopiclist.get(i);
//                if (i != allTopiclist.size() - 1) {
//
//                    str.append("{\n" +
//                            "        \"tid\": \"" + topic.getTid() + "\",\n" +
//                            "        \"tname\": \"" + topic.getTname() + "\"\n" +
//                            "    },");
//                } else {
//                    str.append("{\n" +
//                            "        \"tid\": \"" + topic.getTid() + "\",\n" +
//                            "        \"tname\": \"" + topic.getTname() + "\"\n" +
//                            "    }]");
//                }
//            }
//            out.println(str.toString());


//            StringBuffer stringBuffer = new StringBuffer();
//            Topic topic = null;
//            for (int i = 0; i < allTopiclist.size(); i++) {
//                topic = allTopiclist.get(i);
//                stringBuffer.append("<li>\n" +
//                                     "                            " + topic.getTname() + "\n" +
//                                     "                            &nbsp;&nbsp;&nbsp;&nbsp; <a href=\"topic.control?action=tomodify&tid=" + topic.getTid() + "\">修改</a>\n" +
//                                     "                            &nbsp;&nbsp;&nbsp;&nbsp; <a href=\"javascript:chenckdelete(" + topic.getTid() + ")\">删除</a>\n" +
//                                     "                        </li>");
//            }
//            out.println(stringBuffer.toString());
        } else if ("topicajax".equals(action)) {
            List<Topic> allTopiclist = topicService.findAllTopics();
            String str = JSON.toJSONString(allTopiclist,
                    SerializerFeature.WriteNullStringAsEmpty,
                    SerializerFeature.WriteNullListAsEmpty
            );
            out.println(str);


//            StringBuffer stringBuffer = new StringBuffer();
//            Topic topic = null;
//            for (int i = 0; i < allTopiclist.size(); i++) {
//                topic = allTopiclist.get(i);
//                stringBuffer.append("<option value=" + topic.getTid() + "> " + topic.getTname() + "</option>");
//            }
//            out.println(stringBuffer.toString());
//        }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}