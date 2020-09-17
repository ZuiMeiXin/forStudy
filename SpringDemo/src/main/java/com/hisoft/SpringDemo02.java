package com.hisoft;

import lombok.Data;

@Data
public class SpringDemo02 {
    private String name;
    private String says;
    private Address Address;

    public SpringDemo02(String name, String says, com.hisoft.Address address) {
        this.name = name;
        this.says = says;
        Address = address;
    }

    public SpringDemo02() {
    }

    public void print() {
        System.out.println(getAddress().getName()+"的"+name+"说："+says);
    }


}
