package com.hisoft.news.service.impl;

import com.hisoft.news.dao.CommentsDao;
import com.hisoft.news.dao.NewsDao;
import com.hisoft.news.dao.TopicDao;
import com.hisoft.news.dao.impl.CommentsDaoImpl;
import com.hisoft.news.dao.impl.NewsDaoImpl;
import com.hisoft.news.dao.impl.TopicDaoImpl;
import com.hisoft.news.entity.News;
import com.hisoft.news.entity.Topic;
import com.hisoft.news.service.NewsService;
import com.hisoft.news.util.JdbcUtil;
import com.hisoft.news.util.Page;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewsServiceImpl implements NewsService {
    private Connection connection = null;
    private NewsDao newsDao = null;
    private CommentsDao commentsDao = null;

    /*根据页号查询所有的新闻*/
    @Override
    public Map<String, Object> queryAllNews(int currPageNo) {
        connection = JdbcUtil.getConnection();
        newsDao = new NewsDaoImpl(connection);
        Page page = new Page();
        Map<String, Object> map = new HashMap<>();
        List<News> news = newsDao.queryAllNews(currPageNo);
        int totalCount = 0;
        try {
            totalCount = newsDao.queryAllnewsCount(null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        page.setTotalCount(totalCount);
        if (currPageNo < 1) {
            currPageNo = 1;
        } else if (currPageNo > page.getTotalPageCount()) {
            currPageNo = page.getTotalPageCount();
        }
        page.setCurrPageNo(currPageNo);
        page.setNewsList(news);
        map.put("page", page);
        JdbcUtil.closeAll(connection, null, null);
        return map;
    }

    /*通过主题id查询所有的新闻*/
    @Override
    public List<News> queryNewsByTid(int tid) {
        connection = JdbcUtil.getConnection();
        newsDao = new NewsDaoImpl(connection);
        List<News> news = null;
        try {
            connection.setAutoCommit(false);
            news = newsDao.queryNewsByTid(tid);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            news = null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeAll(connection, null, null);
        }
        return news;
    }

    /*查询新闻数量*/
    @Override
    public int queryNewsCount(Integer tid) {
        connection = JdbcUtil.getConnection();
        newsDao = new NewsDaoImpl(connection);
        int allnewsCount = 0;
        try {
            allnewsCount = newsDao.queryAllnewsCount(tid);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeAll(connection, null, null);
        }
        return allnewsCount;
    }

    /*查询左侧的国内新闻  国际新闻 娱乐新闻*/
    @Override
    public Map<String, Object> queryIndexList(String gn, String gj, String yl) {
        connection = JdbcUtil.getConnection();
        NewsDao newsDao = new NewsDaoImpl(connection);
        Map<String, Object> map = new HashMap<>();
        List<News> list1 = null;
        List<News> list2 = null;
        List<News> list3 = null;
        try {
            list1 = newsDao.queryAllNewsByTopic(gn);
            list2 = newsDao.queryAllNewsByTopic(gj);
            list3 = newsDao.queryAllNewsByTopic(yl);
            map.put("list1", list1);
            map.put("list2", list2);
            map.put("list3", list3);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeAll(connection, null, null);
        }
        return map;
    }

    /*通过新闻id查询新闻*/
    @Override
    public News queryNewsByNid(int nid) {
        connection = JdbcUtil.getConnection();
        newsDao = new NewsDaoImpl(connection);
        News news = null;
        try {
            connection.setAutoCommit(false);
            news = newsDao.queryNewsByNid(nid);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            news = null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeAll(connection, null, null);
        }
        return news;
    }

    /*通过主题名称查询所有的新闻*/
    @Override
    public List<News> queryAllNewsByTopic(String tname) {
        connection = JdbcUtil.getConnection();
        newsDao = new NewsDaoImpl(connection);
        List<News> news = null;
        try {
            connection.setAutoCommit(false);
            news = newsDao.queryAllNewsByTopic(tname);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            news = null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeAll(connection, null, null);
        }
        return news;
    }

    /*通过新闻id删除新闻以及新闻下的评论*/
    @Override
    public int deleteNewsByNid(int nid) {
        connection = JdbcUtil.getConnection();
        newsDao = new NewsDaoImpl(connection);
        commentsDao = new CommentsDaoImpl(connection);
        int result = 0;
        try {
            connection.setAutoCommit(false);
            commentsDao.deleteCommentByNid(nid);//删除评论
            result = newsDao.deleteNewsByNid(nid);//删除新闻
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            JdbcUtil.closeAll(connection, null, null);
        }
        return result;
    }

    //    查询所有的新闻
    @Override
    public List<News> queryAllNews() {
        connection = JdbcUtil.getConnection();
        newsDao = new NewsDaoImpl(connection);
        List<News> news = null;
        try {
            connection.setAutoCommit(false);
            news = newsDao.queryAllNews();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            news = null;
        } finally {
            JdbcUtil.closeAll(connection, null, null);
        }
        return news;
    }

    //添加新闻
    @Override
    public int addNews(News news) {
        connection = JdbcUtil.getConnection();
        newsDao = new NewsDaoImpl(connection);
        int i = -1;
        try {
            connection.setAutoCommit(false);
            i = newsDao.addNews(news);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            JdbcUtil.closeAll(connection, null, null);
        }
        return i;
    }

    /*根据主题id，当前页号查询对应的新闻*/
    @Override
    public Page queryAllNews(Integer tid, int currPageNo) {
        connection = JdbcUtil.getConnection();
        newsDao = new NewsDaoImpl(connection);
        Page page = new Page();
        try {
            newsDao.queryAllnewsCount(tid);
            List<News> newsList = newsDao.queryPageNews(tid, currPageNo, page.getPageSize());
            int allnewsCount = newsDao.queryAllnewsCount(tid);
            page.setTotalCount(allnewsCount);
            page.setNewsList(newsList);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.closeAll(connection,null,null);
        }
        return page;
    }


}
