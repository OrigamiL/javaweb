package com.weifang.javaweb.servlet.util;

import java.sql.*;
import java.util.ResourceBundle;

public class JDBCUtil {
    static ResourceBundle bundle = ResourceBundle.getBundle("com.weifang.javaweb.servlet.resource.jdbc");
    public static String driver = bundle.getString("driver");
    public static String url = bundle.getString("url");
    public static String user = bundle.getString("user");
    public static String password = bundle.getString("password");
    static {
        try {
            //注册驱动
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection () throws SQLException {
        //获取连接对象
        return DriverManager.getConnection(url,user,password);
    }

    //关闭连接
    public static void close (Connection conn, Statement ps, ResultSet rs) {
        if (rs!=null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps!=null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn!=null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
