package com.hisoft.news.entity;

public class NewsUser {
    private Integer uid;
    private String uname;
    private String upwd;

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public NewsUser(String uname, String upwd) {
        this.uname = uname;
        this.upwd = upwd;
    }

    public NewsUser(Integer uid, String uname, String upwd) {
        this.uid = uid;
        this.uname = uname;
        this.upwd = upwd;
    }

    public NewsUser() {
    }

    @Override
    public String toString() {
        return "NewsUser{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", upwd='" + upwd + '\'' +
                '}';
    }
}
