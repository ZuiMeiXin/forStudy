package com.hisoft.news.dao.impl;

import com.hisoft.news.dao.UserDao;
import com.hisoft.news.entity.NewsUser;
import com.hisoft.news.util.JdbcUtil;

import java.sql.Connection;
import java.sql.*;
//获取数据库连接 获取查询的结果
public class UserDaoImpl implements UserDao {
    @Override
    public NewsUser findNewsUser(NewsUser newsUser) throws SQLException, ClassNotFoundException {
        Connection conn = JdbcUtil.getConnection();
        PreparedStatement ps = conn.prepareStatement("select * from news_users where uname =? and upwd = ?");
        ps.setString(1, newsUser.getUname());
        ps.setString(2, newsUser.getUpwd());
        ResultSet rs = ps.executeQuery();
        NewsUser newsUser1 = null;
        if (rs.next()) {
            newsUser1 = new NewsUser(rs.getString("uname"), rs.getString("upwd"));
        }
        JdbcUtil.closeAll(conn, ps, rs);
        return newsUser1;
    }
}
