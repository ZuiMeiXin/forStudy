package com.hisoft.user;

import com.hisoft.equip.Equip;
import lombok.Data;

import java.util.List;

@Data
public class User {
    private String name;
    private Equip equip;

    public void show(){
        System.out.println(name+"穿上了"+equip.getUp()+","+equip.getLeg()+","+equip.getShoot());
    }
}
