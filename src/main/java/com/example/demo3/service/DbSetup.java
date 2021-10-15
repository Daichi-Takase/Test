package com.example.demo3.service;

import static com.ninja_squad.dbsetup.Operations.*;
import com.ninja_squad.dbsetup.destination.DriverManagerDestination;
import com.ninja_squad.dbsetup.operation.Operation;
//import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.destination.Destination;

public class DbSetup{
    
    //接続文字列
    String url = "jdbc:postgresql://localhost:5432/postgres";
    String user = "postgres";
    String password = "postgres";

    Destination dest = new DriverManagerDestination(url, user, password);
    
    // deleteAllFromは複数指定も可能(可変長引数)
    public static final Operation DELETE_ALL = deleteAllFrom("character");

    // truncateを使う場合
    public static final Operation TRUNCATE = truncate("character");

    // 一部分だけ削除したいときはSQLを直接書く
    public static final Operation DELETE_PARTIAL = sql("delete from character where age < 20");

    public static final Operation INSERT =
    // テーブルの指定
    insertInto("character")

    // 全てのレコードに同じ値をセットする場合
    .withDefaultValue("gender", "女性")

    // 1行目の作成
    .row().column("headgear", "ヘッドバンド ホワイト")
          .column("clothing", "わかばイカT")
          .column("shoes", "キャンバス ホワイト")
          .end()

    // 2行目の作成
    .row().column("headgear", "フェイスゴーグル")
          .column("clothing", "スクールブレザー")
          .column("shoes", "パワードレッグス")
          .end()

    // Operationオブジェクトの作成
    .build();
    
    Operation ops = sequenceOf(DELETE_ALL, INSERT);
    
    //DbSetup dbSetup = new DbSetup(dest, ops);

}

