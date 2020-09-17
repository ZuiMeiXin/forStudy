package com.hisoft;

import lombok.Data;

@Data
public class SpringDemo {
    private String who;

//    打印
    public void print(){
        System.out.println("Hello,"+who);
    }
}
