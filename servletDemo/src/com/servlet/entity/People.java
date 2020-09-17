package com.servlet.entity;

import java.util.List;

public class People {
    private  String  name;
    private  String password;
    private  String gender;
    private  List<String> luange;

    public People() {
    }

    public People(String name, String password, String gender, List<String> luange) {
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.luange = luange;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<String> getLuange() {
        return luange;
    }

    public void setLuange(List<String> luange) {
        this.luange = luange;
    }
}
