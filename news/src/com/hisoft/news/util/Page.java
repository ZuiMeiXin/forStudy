package com.hisoft.news.util;

import com.hisoft.news.entity.News;

import java.util.List;

public class Page {
    private int currPageNo = 1; // 当前页码
    private int pageSize = 5;    // 页面大小，即每页显示记录数
    private int totalCount;          // 记录总数
    private int totalPageCount; // 总页数
    List<News> newsList;         // 每页新闻集合


    public int getCurrPageNo() {
        return currPageNo;
    }

    public void setCurrPageNo(int currPageNo) {
        this.currPageNo = currPageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        this.totalPageCount = (totalCount % pageSize == 0) ? (totalCount / pageSize) : (totalCount / pageSize + 1);
    }

    public int getTotalPageCount() {
        return totalPageCount;
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }

    public Page(int currPageNo, int pageSize, int totalCount, int totalPageCount, List<News> newsList) {
        this.currPageNo = currPageNo;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.totalPageCount = totalPageCount;
        this.newsList = newsList;
    }

    public Page() {
    }
}
