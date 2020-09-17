package com.hisoft.news.entity;

import java.util.Date;

public class Comment {
    private int cid;
    private int cnid;
    private String ccontent;
    private Date cdate;
    private String cip;
    private String cauthor;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getCnid() {
        return cnid;
    }

    public void setCnid(int cnid) {
        this.cnid = cnid;
    }

    public String getCcontent() {
        return ccontent;
    }

    public void setCcontent(String ccontent) {
        this.ccontent = ccontent;
    }

    public java.util.Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    public String getCip() {
        return cip;
    }

    public void setCip(String cip) {
        this.cip = cip;
    }

    public String getCauthor() {
        return cauthor;
    }

    public void setCauthor(String cauthor) {
        this.cauthor = cauthor;
    }

    public Comment() {
    }

    public Comment(int cid, int cnid, String ccontent, Date cdate, String cip, String cauthor) {
        this.cid = cid;
        this.cnid = cnid;
        this.ccontent = ccontent;
        this.cdate = cdate;
        this.cip = cip;
        this.cauthor = cauthor;
    }
}
