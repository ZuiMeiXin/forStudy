package com.hisoft.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private String userName;
    private String userCode;
    private String userPassword;
}
