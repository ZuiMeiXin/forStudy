package com.hisoft.news.dao.impl;

import com.hisoft.news.entity.News;
import com.hisoft.news.util.JdbcUtil;
import com.hisoft.news.util.JdbcUtil3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        int n = 11;
//        String m = "java";
//        String s = n + m;
//        System.out.println(s);

        List<News> news = queryAllNewsByTopic("国内");
        for (News news1 : news) {
            System.out.println(news1.getNcreateDate());

        }
    }

    public static List<News> queryAllNewsByTopic(String tname) throws SQLException, ClassNotFoundException {

        List<News> newsList = new ArrayList<>();
        News news = null;
        Connection connection = JdbcUtil3.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select ntitle,ncreateDate from news,topic where ntid=tid and  tname=?  limit 5 ");
        preparedStatement.setString(1, tname);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            news = new News();
            news.setNtitle(resultSet.getString("ntitle"));
            news.setNcreateDate(resultSet.getTimestamp("ncreateDate"));
            newsList.add(news);
        }
        JdbcUtil.closeAll(connection, preparedStatement, resultSet);
        return newsList;
    }


}
