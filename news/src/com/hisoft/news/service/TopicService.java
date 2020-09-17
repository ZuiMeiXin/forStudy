package com.hisoft.news.service;

import com.hisoft.news.entity.Topic;

import java.util.List;

/**
 * 主题的业务层接口
 */
public interface TopicService {
    /**
     * 删除主题
     * @param tid
     * @return
     */
    int deleteTopicByTid(int tid);
    /**
     * 添加主题
     */
    int addTopicByTname(String tname);
    /**
     * 查询所有的主题
     */
    List<Topic> findAllTopics();
/*根据标题id查询主题*/
    Topic findTopicById(int tid);
    /*根据主题名查询主题*/
    Topic findTopicByName(String tname );
    /*修改一个主题*/
    int updateTopic(String tname,int tid);
}
