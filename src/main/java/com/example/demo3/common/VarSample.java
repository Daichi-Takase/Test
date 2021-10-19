/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo3.common;

/**
 *
 * @author toisu
 */
public class VarSample {

    public static void main(String[] args) {

        var value = 123;
        var str = "あいうえお";
        var long_val = 123L;
        var float_val = 123f;
        var double_val = 123d;

        var human = new Object() { // varで宣言する
            String name = "山田太郎";
            int age = 18;
        };
        System.out.println("名前 " + human.name + "  年齢 " + human.age);
    }
}
