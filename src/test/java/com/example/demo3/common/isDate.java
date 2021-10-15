/*
・Dateクラスを比較検証する時、年、月、日までを比較対象とする
・想定値と実測値を以下のフォーマットで出力する
　フォーマット：is "想定値(yyyy/mm/dd)" but actual is "実測値(yyyy/mm/dd)"
 */
package com.example.demo3.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import java.time.*;

// 1. Matcherクラスの宣言
/* 
public class [任意のクラス名] extends BaseMatcher<[実測値の型]> {
}
 */
public class isDate extends BaseMatcher<Date> {

    // 3. 想定値を保持する仕組みの実装
    // 想定値を保持するメンバ
    private final int yyyy;
    private final int mm;
    private final int dd;

    // 実測値を保持するメンバ
    Object actual;

    // 想定値をセットするコンストラクタ
    isDate(int yyyy, int mm, int dd) {
        this.yyyy = yyyy;
        this.mm = mm;
        this.dd = dd;
    }

    // 4. 検証処理の実装
    @Override
    public boolean matches(Object actual) {
        // 渡された実測値をMatcherクラスのメンバとして保持する
        this.actual = actual;
        // 型チェック(お約束的に書く)
        if (!(actual instanceof Date)) {
            return false;
        }
        // 以下は独自実装のため、目的に合わせた実装をする
        Calendar cal = Calendar.getInstance();
        cal.setTime((Date) actual);
        if (yyyy != cal.get(Calendar.YEAR)) {
            return false;
        }
        if (mm != cal.get(Calendar.MONTH)) {
            return false;
        }
        if (dd != cal.get(Calendar.DATE)) {
            return false;
        }
        return true;
    }

    // 5. エラーメッセージの実装
    @Override
    public void describeTo(Description desc) {
        // 想定値の出力
        desc.appendValue(String.format("%d/%02d/%02d", yyyy, mm, dd));
        // 実測値の出力
        if (actual != null) {
            desc.appendText(" but actual is ");
            desc.appendValue(
                    new SimpleDateFormat("yyyy/MM/dd").format((Date) actual));
        }
    }

    // 2. 検証メソッドの実装
    /*
    public static Matcher<[実測値の型]> [任意のメソッド名]([初期化に必要な値]) {
        return [Matcherクラスのコンストラクタ];
    }
     */
    public static Matcher<Date> dateOf(int yyyy, int mm, int dd) {
        return new isDate(yyyy, mm, dd);
    }
}
