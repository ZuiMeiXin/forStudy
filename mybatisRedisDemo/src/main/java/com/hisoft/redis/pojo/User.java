package com.hisoft.redis.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private String userCode;
    private String userName;
    private String gender;
}
