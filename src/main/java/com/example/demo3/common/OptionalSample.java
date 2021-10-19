package com.example.demo3.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalSample {

    //名前と血液型を格納するためのMap
    static Map<String, String> ageMap = new HashMap<String, String>();

    static void setAgeMap() {

        //Mapに３人のデータ(名前と血液型)を格納
        ageMap.put("ロビン", "A");
        ageMap.put("アリス", "B");
        ageMap.put("レオナルド", "O");
    }

    public static void main(String[] args) {
        
        //Mapにデータを格納
        setAgeMap();
        //検索キーとなる名前
        String input = "ロビン";
        //Mapから名前をキーに血液型を検索
        Optional<String> bloodtypeOptional = checkAgeOptional(input);
        //bloodTypeがnullでない場合のみ、名前と取得した血液型を表示
        bloodtypeOptional.ifPresent(bloodType -> System.out.println(input + "の血液型は" + bloodType + "型です。"));

        
        Optional<String> s = decorate("", '*');
        System.out.println(s.orElse("nullのため処理できません"));

        /*
        Optional.of(10)
                .map(OptionalSample::calc0)
                .map(OptionalSample::calc1)
                .map(OptionalSample::calc2)
                .ifPresent(System.out::println);
        */

        // Optional型でラップされたオブジェクト
        Optional<String> sampleOptional = Optional.of("abc");

        String sampleValue1 = sampleOptional.orElseThrow(
                () -> new RuntimeException("パラメータxxxに、nullは許容しません。")); // Optionalの値がnullの場合に実行するSupplierの処理

        String sampleValue2 = sampleOptional.orElseGet(
                () -> "nullだった場合の代わりの値"); // Optionalの値がnullの場合に実行するSupplierの処理

        sampleOptional.ifPresent(
                (str) -> System.out.println(str)); // Optionalの値がnullでない場合に実行するConsumerの処理

    }

    private static Optional<String> checkAgeOptional(String input) {

        return Optional.ofNullable(ageMap.get(input));
    }

    // 文字列sを文字cで挟んで装飾するメソッド
    // ・文字列sがnullまたは長さ0の場合は、nullを返す。
    // ・戻り値は「nullの可能性がある」ことを明示するために、
    //  単なるStringではなくOptional<String>とする。
    public static Optional<String> decorate(String s, char c) {
        String r;
        if (s == null || s.length() == 0) {
            r = null;
        } else {
            r = c + s + c;
        }
        return Optional.ofNullable(r);
    }

    private static int calc0(int x) {
        return x + 2;
    }

    private static int calc1(int x) {
        return x * 2;
    }

    private static int calc2(int x) {
        return x ^ 2;
    }

}
