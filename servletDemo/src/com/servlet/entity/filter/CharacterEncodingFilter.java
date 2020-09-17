package com.servlet.entity.filter;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {
    private static final Logger logger = Logger.getLogger(CharacterEncodingFilter.class);
    private String charset;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.debug("过滤器被初始化");
        String charset = filterConfig.getInitParameter("charset");
        if (charset != null && charset.trim().length() > 0) {
            this.charset = charset;
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        request.setCharacterEncoding(charset);
        response.setCharacterEncoding(charset);
        response.setContentType("text/html;charset=" + charset);
        logger.debug("请求进入过滤器");
        //放行，进入下一个过滤器
        filterChain.doFilter(request, response);
        logger.debug("响应进入过滤器");
    }

    @Override
    public void destroy() {
        logger.debug("过滤器被销毁了");

    }
}
