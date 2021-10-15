/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo3.common;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author toisu
 */
public class CollectionTest {

    public static void main(String[] args) throws Exception {

        //BigDecimal確認
        BigDecimal b1 = new BigDecimal("1.23");
        BigDecimal b2 = new BigDecimal("4.56");

        BigDecimal addResult = b2.add(b1);
        BigDecimal subtractResult = b2.subtract(b1);
        BigDecimal multiplyResult = b2.multiply(b1);
        BigDecimal divideResult = b2.divide(b1, 2, BigDecimal.ROUND_HALF_UP);

        //Java10以降の丸め処理は、RoundingModeを使用
        BigDecimal divideResult_new = b2.divide(b1, RoundingMode.HALF_UP);

        System.out.println("足し算(add)の結果= " + addResult);
        System.out.println("引き算(subtract)の結果= " + subtractResult);
        System.out.println("掛け算(multiply)の結果= " + multiplyResult);
        System.out.println("割り算(divide)の結果= " + divideResult);
        System.out.println("割り算(divide)の結果（新）= " + divideResult_new);

        //丸め処理一覧
        BigDecimal b3 = new BigDecimal("1.23456");

        //ROUND_UP	0から離れるように丸めるモード
        BigDecimal upResult = b3.setScale(2, BigDecimal.ROUND_UP);
        BigDecimal upResult_new = b3.setScale(2, RoundingMode.UP);

        //ROUND_DOWN	0に近づくように丸めるモード
        BigDecimal downResult = b3.setScale(2, BigDecimal.ROUND_DOWN);
        BigDecimal downResult_new = b3.setScale(2, RoundingMode.DOWN);

        //ROUND_CEILING	正の無限大に近づくように丸めるモード
        BigDecimal ceilingResult = b3.setScale(2, BigDecimal.ROUND_CEILING);
        BigDecimal ceilingResult_new = b3.setScale(2, RoundingMode.CEILING);

        //ROUND_FLOOR	負の無限大に近づくように丸めるモード
        BigDecimal floorResult = b3.setScale(2, BigDecimal.ROUND_FLOOR);
        BigDecimal floorResult_new = b3.setScale(2, RoundingMode.FLOOR);

        //ROUND_HALF_UP	もっとも近い数字に丸めるモード(両隣の数字が等距離の場合は切り上げ)
        BigDecimal halfUpResult = b3.setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal halfUpResult_new = b3.setScale(2, RoundingMode.HALF_UP);

        //ROUND_HALF_DOWN	もっとも近い数字に丸めるモード(両隣の数字が等距離の場合は切り捨て)
        BigDecimal halfDownResult = b3.setScale(2, BigDecimal.ROUND_HALF_DOWN);
        BigDecimal halfDownResult_new = b3.setScale(2, RoundingMode.HALF_DOWN);

        //ROUND_HALF_EVEN	もっとも近い数字に丸めるモード(両隣の数字が等距離の場合は偶数側に丸める)
        BigDecimal halfEvenResult = b3.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        BigDecimal halfEvenResult_new = b3.setScale(2, RoundingMode.HALF_EVEN);

        //ROUND_UNNECESSARY	演算の結果が正確であり、丸めが必要ないことを表す丸めモード
        BigDecimal unnecessaryResult = new BigDecimal("1").setScale(2, BigDecimal.ROUND_UNNECESSARY);
        BigDecimal unnecessaryResult_new = new BigDecimal("1").setScale(2, RoundingMode.UNNECESSARY);

        System.out.println("ROUND_UPの結果= " + upResult);
        System.out.println("ROUND_UPの結果（新）= " + upResult_new);

        System.out.println("ROUND_DOWNの結果= " + downResult);
        System.out.println("ROUND_DOWNの結果（新）= " + downResult_new);
        System.out.println("ROUND_CEILINGの結果= " + ceilingResult);
        System.out.println("ROUND_CEILINGの結果（新）= " + ceilingResult_new);
        System.out.println("ROUND_FLOORの結果= " + floorResult);
        System.out.println("ROUND_FLOORの結果（新）= " + floorResult_new);
        System.out.println("ROUND_HALF_UPの結果= " + halfUpResult);
        System.out.println("ROUND_HALF_UP（新）の結果= " + halfUpResult_new);
        System.out.println("ROUND_HALF_DOWNの結果= " + halfDownResult);
        System.out.println("ROUND_HALF_DOWN（新）の結果= " + halfDownResult_new);
        System.out.println("ROUND_HALF_EVENの結果= " + halfEvenResult);
        System.out.println("ROUND_HALF_EVEN（新）の結果= " + halfEvenResult_new);
        System.out.println("ROUND_UNNECESSARYの結果= " + unnecessaryResult);
        System.out.println("ROUND_UNNECESSARY（新）の結果= " + unnecessaryResult_new);

        //LinkedList確認
        List<String> list = new LinkedList<>();

        list.add("東京都");
        list.add("大阪府");
        list.add("神奈川県");

        list.add(1, "千葉県");

        System.out.println(list.size());
        System.out.println(list.get(0));
        System.out.println(list.get(2));

        for (String s : list) {
            System.out.println(s);
        }

        //enum確認
        Fruit fruit_type = Fruit.Orange;
        System.out.println(fruit_type);

        //Set確認
        Set<String> colors1 = new HashSet<String>();
        colors1.add("赤");
        colors1.add("青");
        colors1.add("黄");
        colors1.add("赤");
        System.out.println("色は" + colors1.size() + "種類");

        Set<String> colors2 = new HashSet<String>();
        colors2.add("赤");
        colors2.add("青");
        colors2.add("黄");
        for (String s : colors2) {
            System.out.print(s + "→");
        }

        Set<String> words = new TreeSet<String>();
        words.add("dog");
        words.add("cat");
        words.add("wolf");
        words.add("panda");
        for (String s : words) {
            System.out.print(s + "→");
        }

        //Map確認
        Map<String, Integer> prefs1 = new HashMap<String, Integer>();
        prefs1.put("京都府", 255);
        prefs1.put("東京都", 1261);
        prefs1.put("熊本県", 181);
        int tokyo = prefs1.get("東京都");
        System.out.println("東京都の人口は、" + tokyo);
        prefs1.remove("京都府");
        prefs1.put("熊本県", 182);
        int kumamoto = prefs1.get("熊本県");
        System.out.println("熊本県の人口は、" + kumamoto);

        Map<String, Integer> prefs2 = new HashMap<String, Integer>();
        prefs2.put("京都府", 255);
        prefs2.put("東京都", 1261);
        prefs2.put("熊本県", 182);
        for (String key : prefs2.keySet()) {
            int value = prefs2.get(key);
            System.out.println(key + "の人口は、" + value);
        }

    }

    protected enum Fruit {
        Orange,
        Apple,
        Melon
    };
}
