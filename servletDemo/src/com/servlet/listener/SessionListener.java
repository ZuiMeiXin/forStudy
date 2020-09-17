package com.servlet.listener;

import org.apache.log4j.Logger;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;



@WebListener

public class SessionListener implements HttpSessionAttributeListener {
    private static final Logger logger = Logger.getLogger(SessionListener.class);

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        logger.debug("添加了session属性值\t" + "属性名为" + se.getName() + "属性值为" + se.getValue());

    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        logger.debug("删除了session属性值" + "属性名为" + se.getName() + "属性值为" + se.getValue());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        logger.debug("替换了session属性值" + "旧的属性名为" + se.getName() + "旧的属性值为" + se.getValue());
    }
}
