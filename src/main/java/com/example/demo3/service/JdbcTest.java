package com.example.demo3.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JdbcTest {

    public static long testJdbc(String str) {

        //StreamAPI確認用リスト
        List<String> nameList = new ArrayList<String>();

        Connection conn = null;
        Statement stmt = null;
        ResultSet rset = null;
        PreparedStatement pstmt = null;

        //接続文字列
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "postgres";

        try {

            //PostgreSQLへ接続
            conn = DriverManager.getConnection(url, user, password);

            //自動コミットOFF
            conn.setAutoCommit(false);

            //SELECT文の実行
            stmt = conn.createStatement();
            String sql = "SELECT * from jdbc_test";
            rset = stmt.executeQuery(sql);

            //SELECT結果の受け取り
            while (rset.next()) {

                nameList.add(rset.getString("name"));
                System.out.println(rset.getString("name"));
                System.out.println(rset.getTimestamp("timestamp"));
                long l = rset.getTimestamp("timestamp").getTime();
                Date d = new Date(l);
                System.out.println(d);
                //LocalDateTime型
                LocalDateTime ldt = rset.getTimestamp("timestamp").toLocalDateTime();
                System.out.println(ldt);
            }

            //更新系（INSERT、UPDATE、DELETE文の実行）
            sql = "INSERT INTO jdbc_test VALUES (6, 'DDD')";
            stmt.executeUpdate(sql);
            conn.commit();
            System.out.println("レコードを追加しました");

            //更新系（INSERT、UPDATE、DELETE文の実行）
            sql = "UPDATE jdbc_test SET id = 7 WHERE id = 6";
            stmt.executeUpdate(sql);
            conn.commit();
            System.out.println("レコードを更新しました");

            pstmt = conn.prepareStatement("DELETE FROM jdbc_test WHERE name = ?");
            pstmt.setString(1, "DDD");
            int r = pstmt.executeUpdate();
            if (r != 0) {
                System.out.println(r + "件削除しました");
            } else {
                System.out.println("削除に該当するレコードはありませんでした");
            }
            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rset != null) {
                    rset.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
                if (conn != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        // return nameList.stream().filter(n -> n.equals(str)).count();
        return nameList.stream().distinct().count();
    }
}
