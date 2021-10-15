package com.example.demo3.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcTest {                                                                                                                                                                                                                             
        
        public static long testJdbc(String str) {
            
            List<String> nameList = new ArrayList<String>();
                    
            Connection conn = null;
            Statement stmt = null;
            ResultSet rset = null;
            
            //接続文字列
            String url = "jdbc:postgresql://localhost:5432/postgres";
            String user = "postgres";
            String password = "postgres";
            
            try {
         
                //PostgreSQLへ接続
                conn = DriverManager.getConnection(url, user, password);

                //SELECT文の実行
                stmt = conn.createStatement();
                String sql = "SELECT * from jdbc_test";
                rset = stmt.executeQuery(sql);

                //SELECT結果の受け取り
                while(rset.next()){
                    nameList.add(rset.getString("name"));
                    System.out.println(rset.getString("name"));
                }
                
            }
            catch (SQLException e){
                e.printStackTrace();
            }
            finally {
                try {
                    if(rset != null)rset.close();
                    if(stmt != null)stmt.close();
                    if(conn != null)conn.close();
                }
                catch (SQLException e){
                    e.printStackTrace();
                }
            }
            // return nameList.stream().filter(n -> n.equals(str)).count();
               return nameList.stream().distinct().count();
        }
}
