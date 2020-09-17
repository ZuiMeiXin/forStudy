package com.hisoft.springmybatis.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class User {
    private int id;
    private String userCode;
    private String userName;
    private String userPassword;
    private int gender;
    private Date birthday;
    private String phone;
    private String address;
    private int userRole;
    private int createBy;
    private Date creationDate;
    private int modifyBy;
    private Date modifyDate;
}
