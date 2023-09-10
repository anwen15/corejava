package com.myssm.basedao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connutil {
    private static ThreadLocal<Connection> t=new ThreadLocal<>();

    public static final String DRIVER = "com.mysql.jdbc.Driver" ;
    public static final String URL = "jdbc:mysql://localhost:3306/qqzonedb?useUnicode=true&characterEncoding=utf-8&useSSL=false";
    public static final String USER = "root";
    public static final String PWD = "531184" ;
    public static Connection createconn() {
        try {
            //1.加载驱动
            Class.forName(DRIVER);
            //2.通过驱动管理器获取连接对象
            return DriverManager.getConnection(URL, USER, PWD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null ;
    }
    public static Connection getconn() {
        Connection conn = t.get();
        if (conn == null) {
            conn=connutil.createconn();
            t.set(conn);
        }
        return t.get();
    }
    public static void closeconn() throws SQLException {
        Connection conn = t.get();
        if (conn == null) {
            return;
        }else {
            conn.close();
            t.set(null);
        }
    }
}

