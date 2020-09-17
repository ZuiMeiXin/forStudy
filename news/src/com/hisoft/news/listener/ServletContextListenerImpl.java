package com.hisoft.news.listener;

import com.hisoft.news.entity.Topic;
import com.hisoft.news.service.TopicService;
import com.hisoft.news.service.impl.TopicServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;

public class ServletContextListenerImpl implements ServletContextListener {

    private static final Logger logger = Logger.getLogger(ServletContextListenerImpl.class);


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        TopicService topicService = new TopicServiceImpl();
        List<Topic> allTopics = topicService.findAllTopics();
        sce.getServletContext().setAttribute("allTopics", allTopics);
    }
}
