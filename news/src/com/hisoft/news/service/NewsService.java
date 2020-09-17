package com.hisoft.news.service;

import com.hisoft.news.entity.News;
import com.hisoft.news.util.Page;

import java.util.List;
import java.util.Map;

public interface NewsService {
    /*通过页号查询所有的新闻*/
    Map<String, Object> queryAllNews(int currPageNo);

    /*查询所有新闻*/
    List<News> queryAllNews();

    /*通过主题id查询新闻*/
    List<News> queryNewsByTid(int tid);

    /*查询新闻数量*/
    int queryNewsCount(Integer tid);

    /*查询分页新闻*/
    Map<String, Object>  queryIndexList(String gn, String gj, String yl);


    /*通过新闻id查询新闻*/
    News queryNewsByNid(int nid);

    /*通过主题名字查询新闻*/
    List<News> queryAllNewsByTopic(String tname);


    /*根据新闻id删除新闻以及新闻下的评论*/
    int deleteNewsByNid(int nid);

    /*添加新闻*/
    int addNews(News news);
    /*根据主题id和页号查询所有的新闻*/
    Page queryAllNews(Integer tid, int currPageNo);

}
