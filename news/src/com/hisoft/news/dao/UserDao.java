package com.hisoft.news.dao;

import com.hisoft.news.entity.NewsUser;

import java.sql.SQLException;

public interface UserDao {
    public NewsUser findNewsUser(NewsUser newsUser) throws SQLException, ClassNotFoundException;
}
