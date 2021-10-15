package com.example.demo3.common;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.chrono.JapaneseDate;

public class TimeApi {

    public static void main(String[] args) {

        // Instantの生成
        Instant i1 = Instant.now();

        // Instantとlong値との相互変換
        Instant i2 = Instant.ofEpochMilli(1600705425827L);
        long l = i2.toEpochMilli();

        // ZonedDateTimeの生成方法
        ZonedDateTime z1 = ZonedDateTime.now();
        ZonedDateTime z2 = ZonedDateTime.of(2020, 1, 2, 3, 4, 5, 6, ZoneId.of("Asia/Tokyo"));

        // InstantとZoneDateTimeの相互変換
        Instant i3 = z2.toInstant();
        ZonedDateTime z3 = i3.atZone(ZoneId.of("Europe/London"));

        // ZonedDateTimeの利用方法
        System.out.println("東京:" + z2.getYear() + z2.getMonth() + z2.getDayOfMonth());
        System.out.println("ロンドン:" + z3.getYear() + z3.getMonth() + z3.getDayOfMonth());
        if (z2.isEqual(z3)) {
            System.out.println("これらは同じ瞬間を指しています");
        }

        // LocalDateTimeの生成方法
        LocalDateTime l1 = LocalDateTime.now();
        LocalDateTime l2 = LocalDateTime.of(2021, 10, 13, 9, 5, 0, 0);

        // LocalDateTimeとZoneDateTimeの相互変換
        ZonedDateTime z4 = l2.atZone(ZoneId.of("Asia/Tokyo"));
        LocalDateTime l3 = z4.toLocalDateTime();

        System.out.println(l3);

        // 文字列からLocalDateを生成
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate ldate = LocalDate.parse("2000/10/13", fmt);

        System.out.println(ldate);
                
        // 1000日後を計算する
        LocalDate ldatep = ldate.plusDays(1000);
        String str = ldatep.format(fmt);

        System.out.println("1000日後は" + str);

        // 現在日付との比較
        LocalDate now = LocalDate.now();

        if (now.isAfter(ldatep)) {
            System.out.println("1000日後は過去日付です");
        }

        LocalDate d1 = LocalDate.of(2020, 1, 1);
        LocalDate d2 = LocalDate.of(2020, 1, 4);

        // 3日間を表すPeriodを2通りの方法で生成
        Period p1 = Period.ofDays(3);
        System.out.println(p1);
        
        Period p2 = Period.between(d1, d2);
        System.out.println(p2);
        
        // d2のさらに3日後を計算する
        LocalDate d3 = d2.plus(p2);
        
        System.out.println(d3);
    }

}
