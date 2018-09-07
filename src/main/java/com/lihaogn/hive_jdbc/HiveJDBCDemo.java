package com.lihaogn.hive_jdbc;

import com.lihaogn.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class HiveJDBCDemo {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;


        String sql = "select * from student";

        try {
            //获取连接
            conn = JDBCUtils.getConnection();
            // 创建运行环境
            st = conn.createStatement();
            // 运行hql
            rs = st.executeQuery(sql);
            // 处理数据
            while (rs.next()) {
                String name = rs.getString(1);
                double score = rs.getDouble(3);
                System.out.println(name + score);
            }

            JDBCUtils.release(conn, st, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
