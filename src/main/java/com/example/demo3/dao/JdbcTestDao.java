package com.example.demo3.dao;

import com.example.demo3.dto.JdbcTestDto;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class JdbcTestDao {
    private final Connection conn;

    public JdbcTestDao(Connection conn) {
        this.conn = conn;
    }

    public List<JdbcTestDto> getAll() {
        List<JdbcTestDto> data = new ArrayList<JdbcTestDto>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from jdbc_test";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                LocalDateTime timestamp = rs.getTimestamp("timestamp").toLocalDateTime();
                JdbcTestDto prf = new JdbcTestDto(id, name, timestamp);
                data.add(prf);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(pstmt != null) {
                    pstmt.close();
                }
                if(rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    //更新系
    public List<JdbcTestDto> setAll() {
        List<JdbcTestDto> data = new ArrayList<JdbcTestDto>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from jdbc_test";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                LocalDateTime timestamp = rs.getTimestamp("timestamp").toLocalDateTime();
                JdbcTestDto prf = new JdbcTestDto(id, name, timestamp);
                data.add(prf);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(pstmt != null) {
                    pstmt.close();
                }
                if(rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

}