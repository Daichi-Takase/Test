package com.example.demo3.service;

import com.example.demo3.dao.JdbcTestDao;
import com.example.demo3.dto.JdbcTestDto;
import java.util.List;
import java.util.Iterator;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTestMain {
    public static void main(String[] args) {
        Connection conn = null;

        //接続文字列
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "postgres";
        
        try {
            //PostgreSQLへ接続
            conn = DriverManager.getConnection(url, user, password);

            JdbcTestDao jdbcTestDao = new JdbcTestDao(conn);

            List<JdbcTestDto> profileData = jdbcTestDao.getAll();

            for(Iterator it = profileData.iterator(); it.hasNext(); ) {
                System.out.println(it.next());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}