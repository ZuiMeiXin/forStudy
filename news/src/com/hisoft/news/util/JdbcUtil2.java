package com.hisoft.news.util;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @program: MyWebProject
 * @description:
 * @author: wlg
 * @create: 2020-07-24 16:28:50
 **/
public class JdbcUtil2 {
    private static  String URL;
    private static  String USER;
    private static  String PASSWORD;
    private static  String CLASSDRIVER;

    static {
        //读取属性文件中的链接信息
        InputStream is = null;
        Properties pro = new Properties();
        try {
            is = new FileInputStream("news/resources/db.properties");
            pro.load(is);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        URL = pro.getProperty("url");
        USER = pro.getProperty("user");
        PASSWORD = pro.getProperty("password");
        CLASSDRIVER = pro.getProperty("classdriver");

        //1 加载驱动
        try {
            Class.forName(CLASSDRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     *
     * @return
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 释放资源
     */
    public static void closeAll(Connection conn, Statement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
