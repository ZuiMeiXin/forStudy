package com.hisoft.news.entity;

public class Topic {
    private String tname;
    private int tid;


    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public Topic(String tname) {
        this.tname = tname;
    }

    public Topic(String tname, int tid) {
        this.tname = tname;
        this.tid = tid;
    }


    public Topic() {
    }
}
