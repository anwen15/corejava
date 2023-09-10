package com.myssm.trans;

import com.myssm.basedao.connutil;

import java.sql.Connection;
import java.sql.SQLException;

public class transmanager {

    //开启事物
    public static void begintrans() throws SQLException {
        connutil.getconn().setAutoCommit(false);
    }
    //提交事物
    public static void commit() throws SQLException {

        Connection conn = connutil.getconn();
        conn.commit();
        connutil.closeconn();
    }
    //回滚事物
    public static void rollback() throws SQLException {
        Connection conn = connutil.getconn();
        conn.rollback();
        connutil.closeconn();
    }

}
