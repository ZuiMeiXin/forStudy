package com.hisoft.springmybatis.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Provider {
    private int id;
    private String proCode;
    private String proName;
    private String proDesc;
    private String proContact;
    private String proPhone;
    private String proAddress;
    private String proFax;
    private int createBy;
    private Date creationDate;
    private Date modifyDate;
    private int modifyBy;
}
