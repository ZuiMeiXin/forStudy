package com.hisoft.news.dao;

import com.hisoft.news.entity.Topic;

import java.sql.SQLException;
import java.util.List;

public interface TopicDao {
    Topic findTopicByName(String name);

    int addTopic(Topic topic);

    List<Topic> findAllTopics() throws SQLException, ClassNotFoundException;

    Topic findTopicById(int tid) throws SQLException, ClassNotFoundException;

    int updateTopic(Topic topic) throws SQLException, ClassNotFoundException;

    int deleteTopic(int tid) throws SQLException, ClassNotFoundException;
}
