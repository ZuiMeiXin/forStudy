<%@ page import="java.sql.*" %>
<%@ page import="com.hisoft.news.entity.NewsUser" %>
<%@ page import="com.hisoft.news.dao.UserDao" %>
<%@ page import="com.hisoft.news.dao.impl.UserDaoImpl" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>控制页面</title>
</head>
<body>

<%
    request.setCharacterEncoding("utf-8");


    String username = (String) request.getParameter("uname");
    String userpass = (String) request.getParameter("upwd");
//    out.println(username);
//服务器 验证
    if (username.equals("")) {
        request.setAttribute("message", "用户名不能为空");
        request.getRequestDispatcher("index.jsp").forward(request, response);
        return;
    }
    if (userpass.equals("")) {
        request.setAttribute("message", "密码不能为空");
        request.getRequestDispatcher("index.jsp").forward(request, response);
        return;
    }
    NewsUser newsUser1 = new NewsUser(username, userpass);
    UserDao userDao = new UserDaoImpl();
    NewsUser findUser = userDao.findNewsUser(newsUser1);
    if (findUser != null) {
        session.setAttribute("uname", username);
        request.getRequestDispatcher("newspages/admin.jsp").forward(request, response);
    } else {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }







//    写死的数据库连接 不该写在jsp中 代码冗余
//    if (!"".equals(username) && !"".equals(userpass)){
//        Class.forName("com.mysql.jdbc.Driver");
//        Connection conn= DriverManager.getConnection("jdbc:mysql:///news","root","root");
//        Statement sta = conn.createStatement();
//        ResultSet rs = sta.executeQuery("select * from news_users where uname ='"+username+"' and upwd ='"+userpass+"'");
//        if (rs.next()){
//            session.setAttribute("uname",username);
//            response.sendRedirect("newspages/admin.jsp");
//        }else{
//            request.getRequestDispatcher("index.jsp").forward(request,response);
//        }
//    }else{
//        out.println("<script>alert('用户名和密码不能为空');location.href='index.jsp';</script>");
//    }
%>


</body>
</html>
