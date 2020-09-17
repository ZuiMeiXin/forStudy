package com.servlet.entity;

public class User {
    public int id;
    public String  name;
    public char gender;

    public User(int id, String name, char gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
}
