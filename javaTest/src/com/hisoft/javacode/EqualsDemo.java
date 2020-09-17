package com.hisoft.javacode;

public class EqualsDemo {
    public static void main(String[] args) {
        byte a = 8;
        int b = 8;
        Byte byter = 8;
        Integer integer = 8;
        String string = new String("username");
        String string1 = "username";
        StringBuffer stringBuffer = new StringBuffer("username");
        System.out.println(a == b);//基本数据类型比较的是值
        System.out.println(byter.equals(integer));
        System.out.println(string==string1);//false
        System.out.println(string.equals(string1));//true
        System.out.println(string.equals(stringBuffer));//false
    }
}
