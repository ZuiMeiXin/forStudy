package com.hisoft.news.dao.impl;

import com.hisoft.news.dao.TopicDao;
import com.hisoft.news.entity.Topic;
import com.hisoft.news.dao.BaseDao;
import com.hisoft.news.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TopicDaoImpl extends BaseDao implements TopicDao {
    public TopicDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public Topic findTopicByName(String name) {
        Topic topic = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement("select * from topic where tname = ? ");
            ps.setString(1, name);
            rs = ps.executeQuery();
            if (rs.next()) {
                topic = new Topic(rs.getString("tname"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeAll(null, ps, rs);
        }
        return topic;
    }

    @Override
    public int addTopic(Topic topic) {
        PreparedStatement ps = null;
        int exe = 0;
        try {
            ps = connection.prepareStatement("insert into topic(tname) value(?)");
            ps.setString(1, topic.getTname());
            exe = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ResultSet rs = null;
            JdbcUtil.closeAll(null, ps, rs);
        }
        return exe;
    }

    @Override
    public List<Topic> findAllTopics() throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = connection.prepareStatement("select * from topic");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Topic> topicList = new ArrayList<Topic>();
        Topic topic = null;
        while (resultSet.next()) {
            topic = new Topic(resultSet.getString("tname"), resultSet.getInt("tid"));
            topicList.add(topic);
        }
        JdbcUtil.closeAll(null, preparedStatement, resultSet);
        return topicList;
    }

    @Override
    public Topic findTopicById(int tid) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = connection.prepareStatement("select * from topic where tid = ?");
        preparedStatement.setInt(1, tid);
        ResultSet resultSet = preparedStatement.executeQuery();
        Topic topic = null;
        if (resultSet.next()) {
            topic = new Topic(resultSet.getString("tname"), resultSet.getInt("tid"));
        }
        JdbcUtil.closeAll(null, preparedStatement, resultSet);
        return topic;
    }

    @Override
    public int updateTopic(Topic topic) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = connection.prepareStatement("update topic set tname = ? where tid = ?");
        ps.setString(1, topic.getTname());
        ps.setInt(2, topic.getTid());
        int i = ps.executeUpdate();
        ResultSet rs = null;
        JdbcUtil.closeAll(null, ps, rs);
        return i;
    }

    @Override
    public int deleteTopic(int tid) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = connection.prepareStatement("delete from topic  where tid = ?");
        ps.setInt(1, tid);
        int i = ps.executeUpdate();
        //连接留到service层关闭
        JdbcUtil.closeAll(null, ps, null);
        return i;
    }

}
