package com.boot.test;

import java.sql.*;

/**
 * @author : WangW
 * @Date : 2020/10/21 15:25
 * @description :
 */
public class Test {

    static String URL = "jdbc:mysql://localhost:3306/test?characterEncoding=utf-8&serverTimezone=UTC";
    static String USER = "root";
    static String PASSWORD = "123456";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2.获得数据库链接
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            // 3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
            //预编译
            String sql="select code, name, parment, type, create_time, update_time from dim_own_org_tree_yy_f_v " +
                    "where type = ?";
            String sql_t = "INSERT INTO auth_data_permission VALUES " +
                    "(?, null, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);

            PreparedStatement ps = conn.prepareStatement(sql_t);

            Integer[] parent_Id_old = {1};
            Integer[] parent_Id_now = {};

            for (int i = 0; i < 5; i++){
                statement.setInt(1, i);
                ResultSet rs = statement.executeQuery();

                int j = 0;
                while (rs.next()) {
                    ps.setString(1, rs.getString("code"));
                    ps.setInt(2, parent_Id_old[j]);
                    ps.execute();
                    System.out.println(rs.getString("code"));
                    System.out.println(rs.getString("name"));
                    System.out.println(rs.getString("parment"));
                    System.out.println(rs.getInt("type"));
                    System.out.println(rs.getDate("create_time"));
                    System.out.println(rs.getDate("update_time"));
                    j++;
                }

                parent_Id_old.clone();
                parent_Id_old = parent_Id_now;
                parent_Id_now.clone();

                rs.close();
            }

//			String sql="select * from userinfo where UserName='"+name+"'";
//			Statement statement = conn.createStatement();
//			ResultSet rs = statement.executeQuery(sql);
            // 4.处理数据库的返回结果(使用ResultSet类)


            // 关闭资源
            conn.close();
            statement.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
