package com.hisoft.news.service.impl;

import com.hisoft.news.dao.NewsDao;
import com.hisoft.news.dao.TopicDao;
import com.hisoft.news.dao.impl.NewsDaoImpl;
import com.hisoft.news.dao.impl.TopicDaoImpl;
import com.hisoft.news.entity.News;
import com.hisoft.news.entity.Topic;
import com.hisoft.news.service.TopicService;
import com.hisoft.news.util.JdbcUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TopicServiceImpl implements TopicService {
    private Connection connection =null;

    //必须传入一个连接
    private TopicDao topicDao =null;

    private NewsDao newsDao =null;


    @Override
    public int deleteTopicByTid(int tid) {
        connection=JdbcUtil.getConnection();
        topicDao= new TopicDaoImpl(connection);
        newsDao=new NewsDaoImpl(connection);
        int result = -1;
        try {
            connection.setAutoCommit(false);
            List<News> news = newsDao.queryNewsByTid(tid);
            if (!news.isEmpty()) {
                return result;
            }
            result = topicDao.deleteTopic(tid);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            result = -2;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeAll(connection, null, null);
        }
        return result;
    }

    @Override
    public int addTopicByTname(String tname) {
        connection=JdbcUtil.getConnection();
        topicDao= new TopicDaoImpl(connection);
        newsDao=new NewsDaoImpl(connection);
        Topic topicBName = topicDao.findTopicByName(tname);
        int result = -1;//已经存在主题
        try {
            connection.setAutoCommit(false);
            if (topicBName != null) {
                return result;
            }
            Topic topic = new Topic(tname);
            result = topicDao.addTopic(topic);//添加成功 返回1
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
                result = 0;//添加失败返回0
            }
        } finally {
            JdbcUtil.closeAll(connection, null, null);
        }
        return result;
    }

    @Override
    public List<Topic> findAllTopics() {
        connection=JdbcUtil.getConnection();
        topicDao= new TopicDaoImpl(connection);
        newsDao=new NewsDaoImpl(connection);
        List<Topic> allTopics = new ArrayList<>();
        try {
            allTopics = topicDao.findAllTopics();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeAll(connection, null, null);
        }
        return allTopics;
    }

    @Override
    public Topic findTopicById(int tid) {
        connection=JdbcUtil.getConnection();
        topicDao= new TopicDaoImpl(connection);
        newsDao=new NewsDaoImpl(connection);
        Topic topicById = new Topic();
        try {
            topicById = topicDao.findTopicById(tid);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeAll(connection, null, null);
        }
        return topicById;
    }

    @Override
    public Topic findTopicByName(String tname) {
        connection=JdbcUtil.getConnection();
        topicDao= new TopicDaoImpl(connection);
        newsDao=new NewsDaoImpl(connection);
        Topic topic = null;
        topic = topicDao.findTopicByName(tname);
        JdbcUtil.closeAll(connection, null, null);
        return topic;
    }

    @Override
    public int updateTopic(String tname, int tid) {
        connection=JdbcUtil.getConnection();
        topicDao= new TopicDaoImpl(connection);
        newsDao=new NewsDaoImpl(connection);
        Topic topic = new Topic(tname, tid);
        int update = -1;//查询后 有重复的主题
        Topic topicByName = topicDao.findTopicByName(tname);
        if (topicByName != null) {
            return update;
        }
        try {
            connection.setAutoCommit(false);
            update=topicDao.updateTopic(topic);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {

                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
                update=0;//添加失败
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.closeAll(connection,null,null);
        }
        return update;
    }


}
