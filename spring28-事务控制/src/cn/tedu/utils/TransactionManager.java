package cn.tedu.utils;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionManager {
    private TransactionManager(){}

    private static Connection conn = JDBCUtils.getConn();

    /**
     * 开启事务
     */
    public static void startTran(){
        try {
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 提交事务
     */
    public static void commitTran(){
        try {
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 回滚事务
     */
    public static void rollbackTran(){
        try {
            conn.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static Connection getConn(){
        return conn;
    }
    public static void release(){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
