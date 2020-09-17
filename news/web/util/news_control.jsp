<%@ page import="com.hisoft.news.entity.News" %>
<%@ page import="com.hisoft.news.dao.CommentsDao" %>
<%@ page import="com.hisoft.news.dao.impl.CommentsDaoImpl" %>
<%@ page import="com.hisoft.news.entity.Comment" %>
<%@ page import="com.hisoft.news.util.JdbcUtil" %>
<%@ page import="com.hisoft.news.service.NewsService" %>
<%@ page import="com.hisoft.news.service.impl.NewsServiceImpl" %>
<%@ page import="com.hisoft.news.service.TopicService" %>
<%@ page import="com.hisoft.news.service.impl.TopicServiceImpl" %>
<%@ page import="org.apache.commons.fileupload.FileItem" %>
<%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory" %>
<%@ page import="org.apache.commons.fileupload.servlet.ServletFileUpload" %>
<%@ page import="java.io.File" %>
<%@ page import="org.apache.commons.fileupload.FileUploadBase" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新闻控制页面</title>
</head>
<body>
<%
    /**
     * 获取 国内-list1 国际-list2 娱乐-list3 标题-topiclist 新闻-newslist
     *
     * */
    request.setCharacterEncoding("utf-8");
    String action = request.getParameter("action");
    NewsService newsService = new NewsServiceImpl();
    TopicService topicService = new TopicServiceImpl();
    CommentsDao commentsDao = new CommentsDaoImpl(JdbcUtil.getConnection());
    if ("index".equals(action)) {
        String tidstr = request.getParameter("tid");
        Integer tid = ((tidstr == null || tidstr == "null") ? null : Integer.parseInt(tidstr));
        String currPageNostr = request.getParameter("currPageNo");
        if (currPageNostr == null) {
            currPageNostr = "1";
        }
        int currPageNo = Integer.parseInt(currPageNostr);
        Map<String, Object> map = newsService.queryIndexList("国内", "国际", "娱乐", tid, currPageNo);
        request.setAttribute("map", map);
        request.getRequestDispatcher("../index.jsp").forward(request, response);
    } else if ("readnews".equals(action)) {
// 左侧标题栏的新闻
        List<News> list1 = newsService.queryAllNewsByTopic("国内");
        List<News> list2 = newsService.queryAllNewsByTopic("国际");
        List<News> list3 = newsService.queryAllNewsByTopic("娱乐");
        request.setAttribute("list1", list1);
        request.setAttribute("list2", list2);
        request.setAttribute("list3", list3);
// 获取点击事件之后的nid 新闻id 根据新闻id获取对应的新闻 以及对应的评论
        Integer nid = Integer.parseInt(request.getParameter("nid"));
// 读取新闻内容
        News newsShow = newsService.queryNewsByNid(nid);//根据新闻的id获取到对应的新闻
        List<Comment> comments = commentsDao.getCommentsByNid(nid);
        if (comments.size() > 0) {
            newsShow.setComment(comments);
        }
        request.setAttribute("news", newsShow);
//  跳转到新闻阅读界面
        request.getRequestDispatcher("../newspages/news_read.jsp").forward(request, response);
    } else if ("addComment".equals(action)) {
        String cauthor = request.getParameter("cauthor");
        String cnid = request.getParameter("nid");
        String cip = request.getParameter("cip");
        String ccontent = request.getParameter("ccontent");
        Date date = new java.util.Date();
        Comment comment = new Comment();
        comment.setCnid((Integer.parseInt(cnid)));
        comment.setCcontent(ccontent);
        comment.setCdate(date);
        comment.setCip(cip);
        comment.setCauthor(cauthor);
        CommentsDao commentsDao1 = new CommentsDaoImpl(JdbcUtil.getConnection());
        if (commentsDao1.addComment(comment) > 0) {%>
<script type="text/javascript">
    alert("添加成功 点击确认返回原来页面");
    location.href = "../news.control?action=readnews&nid=<%=cnid%>";
</script>

<%
} else {%>
<script type="text/javascript">
    alert("添加失败 请联系管理员查找原因！点击确认返回原来页面");
    location.href = "../news.control?action=readnews&nid=<%=cnid%>";
</script>

<%
    }
} else if ("deletenews".equals(action)) {
    /*根据新闻的id号进行删除新闻以及新闻下的评论*/
    int nid = Integer.parseInt(request.getParameter("nid"));
    int deleteNewsByNid = newsService.deleteNewsByNid(nid);
    if (deleteNewsByNid == 0) {
%>
<script type="text/javascript">
    alert("删除失败 请联系管理员查找原因！点击确认返回原来页面");
    location.href = "../newspages/admin.jsp";
</script>

<%
    }
    if (deleteNewsByNid == 1) {
%>
<script type="text/javascript">
    alert("删除成功 点击确认返回原来页面");
    location.href = "../newspages/admin.jsp";
</script>
<%
        }
    } else if ("tomodifynews".equals(action)) {
        /*获取新闻信息*/
        int nid = Integer.parseInt(request.getParameter("nid"));
        News news = newsService.queryNewsByNid(nid);
        request.setAttribute("news", news);
        request.getRequestDispatcher("../newspages/news_modify.jsp").forward(request, response);
    } else if ("updatenews".equals(action)) {

    } else if ("addnews".equals(action)) {

        request.setCharacterEncoding("utf-8");
        String uploadFileName = ""; //上传的文件名
        String fieldName = "";  //表单字段元素的name属性值
        //请求信息中的内容是否是multipart类型
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        //上传文件的存储路径（服务器文件系统上的绝对文件路径）
//	String uploadFilePath = request.getSession().getServletContext().getRealPath("upload/" );
        String uploadFilePath = application.getRealPath("upload/");

        if (isMultipart) {
//		FileItemFactory factory = new DiskFileItemFactory();
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //设置缓冲区大小和临时目录
            factory.setSizeThreshold(1024 * 10);
            factory.setRepository(new File("F:\\test\\fileupload_temp"));
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setSizeMax(1024 * 1024 * 5);//设置上传文件的属性 设置大小只能是5MB
            News news = new News();

            try {
                //解析form表单中所有文件
                List<FileItem> items = upload.parseRequest(request);
                Iterator<FileItem> iter = items.iterator();
                while (iter.hasNext()) {   //依次处理每个文件
                    FileItem item = iter.next();
                    if (item.isFormField()) {  //普通表单字段
                        fieldName = item.getFieldName();   //表单字段的name属性值
                        switch (fieldName) {
                            case "ntid":
                                news.setNtid(Integer.parseInt(item.getString("utf-8")));
                                break;
                            case "ntitle":
                                news.setNtitle(item.getString("utf-8"));
                                break;
                            case "nauthor":
                                news.setNauthor(item.getString("utf-8"));
                                break;
                            case "ncontent":
                                news.setNcontent(item.getString("utf-8"));
                                break;
                            case "nsummary":
                                news.setNsummary(item.getString("utf-8"));
                                break;
                        }
                    } else {  //文件表单字段
                        String fileName = item.getName();//上传文件名
                        String ext = fileName.substring(fileName.lastIndexOf(".") + 1);//从文件名最后一个.开始 截取后缀名
                        List<String> stringList = Arrays.asList("png", "jpeg", "gif");//将后缀名放到集合中
                        //判断文件类型是不是要求的文件类型 如果不是就不会继续执行后面的上传操作
                        if (!stringList.contains(ext)) {
                            out.println("上传的文件类型不对 ，只能上传png，jpg，bmp文件");
                            return;
                        }

                        if (fileName != null && !fileName.equals("")) {
                            File fullFile = new File(fileName);
                            File saveFile = new File(uploadFilePath, fullFile.getName());
                            System.out.println(saveFile.getAbsolutePath());
                            try {
                                item.write(saveFile);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            //uploadFileName = fullFile.getName();
                            out.print("<script>alert('上传成功后的文件名是：" + fileName + "')</script>");
                            news.setNpicPath(saveFile.getAbsolutePath());
                        }
                    }
                }
            } catch (FileUploadBase.SizeLimitExceededException e) {
                out.print("<script>alert('上传的最大文件限制是：" + upload.getSizeMax() + "');location.href='newspages/news_add.jsp'</script>");
                e.printStackTrace();
            }
            news.setNcreateDate(new Date());
            int i = newsService.addNews(news);
            if (i == 1) {

                out.println("<script>alert('添加成功！');location.href='../newspages/admin.jsp'</script>");
                return;
            } else {
                out.println("<script>alert('添加失败请联系管理员！');location:href='../newspages/news_add.jsp'</script>");
                return;
            }

        }

    }
%>

</body>
</html>
