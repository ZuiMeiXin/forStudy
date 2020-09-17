package com.hisoft.news.entity;

import java.util.Date;
import java.util.List;

public class News {
    private int nid;//新闻的id号
    private int ntid;//
    private String ntitle;//新闻的标题
    private String nauthor;//新闻的作者
    private Date ncreateDate;//新闻的发布时间
    private String npicPath;
    private String ncontent;
    private Date nmodifyDate;
    private String nsummary;

    private List<Comment> comment;//评论的内容
    private String ntname;//新闻的题目名称

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }

    public String getNtname() {
        return ntname;
    }

    public void setNtname(String ntname) {
        this.ntname = ntname;
    }


    public int getNid() {
        return nid;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

    public String getNtitle() {
        return ntitle;
    }

    public void setNtitle(String ntitle) {
        this.ntitle = ntitle;
    }

    public String getNauthor() {
        return nauthor;
    }

    public void setNauthor(String nauthor) {
        this.nauthor = nauthor;
    }

    public Date getNcreateDate() {
        return ncreateDate;
    }

    public void setNcreateDate(Date ncreateDate) {
        this.ncreateDate = ncreateDate;
    }

    public int getNtid() {
        return ntid;
    }

    public void setNtid(int ntid) {
        this.ntid = ntid;
    }

    public String getNpicPath() {
        return npicPath;
    }

    public void setNpicPath(String npicPath) {
        this.npicPath = npicPath;
    }

    public String getNcontent() {
        return ncontent;
    }

    public void setNcontent(String ncontent) {
        this.ncontent = ncontent;
    }

    public Date getNmodifyDate() {
        return nmodifyDate;
    }

    public void setNmodifyDate(Date nmodifyDate) {
        this.nmodifyDate = nmodifyDate;
    }

    public String getNsummary() {
        return nsummary;
    }

    public void setNsummary(String nsummary) {
        this.nsummary = nsummary;
    }

    public News(String ntitle, String nauthor, Date ncreateDate) {
        this.ntitle = ntitle;
        this.nauthor = nauthor;
        this.ncreateDate = ncreateDate;
    }

    public News(String ntitle, String nauthor) {
        this.ntitle = ntitle;
        this.nauthor = nauthor;
    }


    public News(String ntitle, String nauthor, String ncontent, Date nmodifyDate, String nsummary, List<Comment> comment, String ntname) {
        this.ntitle = ntitle;
        this.nauthor = nauthor;
        this.ncontent = ncontent;
        this.nmodifyDate = nmodifyDate;
        this.nsummary = nsummary;
        this.comment = comment;
        this.ntname = ntname;
    }

    public News(int nid, int ntid, String ntitle, String nauthor, Date ncreateDate, String npicPath, String ncontent, Date nmodifyDate, String nsummary, List<Comment> comment, String ntname) {
        this.nid = nid;
        this.ntid = ntid;
        this.ntitle = ntitle;
        this.nauthor = nauthor;
        this.ncreateDate = ncreateDate;
        this.npicPath = npicPath;
        this.ncontent = ncontent;
        this.nmodifyDate = nmodifyDate;
        this.nsummary = nsummary;
        this.comment = comment;
        this.ntname = ntname;
    }

    public News() {
    }
}
