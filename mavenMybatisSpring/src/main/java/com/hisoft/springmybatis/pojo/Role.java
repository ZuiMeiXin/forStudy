package com.hisoft.springmybatis.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Role {
    private int id;
    private String roleCode;
    private String roleName;
    private int createdBy;
    private Date creationDate;
    private int modifyBy;
    private Date modifyDate;
}
