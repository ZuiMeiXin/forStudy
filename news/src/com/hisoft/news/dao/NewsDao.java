package com.hisoft.news.dao;

import com.hisoft.news.entity.News;

import java.sql.SQLException;
import java.util.List;

public interface NewsDao {
    /*查询所有的新闻*/
    List<News> queryAllNews(int currPageNo);

    /*查询所有新闻*/
    List<News> queryAllNews();
    /*通过主题id查询新闻*/
    List<News> queryNewsByTid(int tid) throws SQLException, ClassNotFoundException;

    /*通过新闻id查询新闻*/
    News queryNewsByNid(int nid) throws SQLException, ClassNotFoundException;

    /*通过主题查询新闻*/
    List<News> queryAllNewsByTopic(String tname) throws SQLException, ClassNotFoundException;

    /*根据新闻id删除新闻*/
    int deleteNewsByNid(int nid) throws SQLException;

    /*查询新闻总数*/
    int queryAllnewsCount(Integer tid) throws SQLException;

    /*通过主题id 页号 页面大小 分页查询*/
    List<News> queryPageNews(Integer tid, int currPageNo, int pageSize) throws SQLException;

    /*添加新闻*/
    int addNews(News news) throws SQLException;
}
