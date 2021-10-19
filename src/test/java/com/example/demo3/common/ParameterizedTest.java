package com.example.demo3.common;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

public class ParameterizedTest {

    @RunWith(Theories.class)
    public static class 数値の場合 {

        @DataPoint
        public static int INT_PARAM_1 = 3;
        @DataPoint
        public static int INT_PARAM_2 = 4;

        @Theory
        public void testCase(int num) throws Exception {
            System.out.println("入力値：" + num);
        }
    }

    /*
    @RunWith(Theories.class)
    public static class 文字列の場合 {

        @DataPoint
        public static String STR_PARAM_1 = "Hello";
        @DataPoint
        public static String STR_PARAM_2 = "World";

        @Theory
        public void testCase(String str) throws Exception {
            System.out.println("入力値：" + str);
        }
    }

    @RunWith(Theories.class)
    public static class 数値と文字列の場合 {

        @DataPoint
        public static int INT_PARAM_1 = 3;
        @DataPoint
        public static int INT_PARAM_2 = 4;
        @DataPoint
        public static String STR_PARAM_1 = "Hello";
        @DataPoint
        public static String STR_PARAM_2 = "World";

        @Theory
        public void testCase(int num, String str) throws Exception {
            System.out.println("入力値：" + num + "、" + str);
        }
    }

    @RunWith(Theories.class)
    public static class 数値と数値の場合 {

        @DataPoint
        public static int INT_PARAM_1 = 3;
        @DataPoint
        public static int INT_PARAM_2 = 4;

        @Theory
        public void testCase(int num1, int num2) throws Exception {
            System.out.println("入力値：" + num1 + "、" + num2);
        }
    }
    
    @DataPoints
    public static Fixture[] INT_PARAMS = {
        new Fixture(1, 2, 3),
        new Fixture(0, 2, 2),};

    @DataPoint
    public static Fixture INT_PARAM_1 = new Fixture(1, 2, 3);
    @DataPoint
    public static Fixture INT_PARAM_2 = new Fixture(0, 2, 2);

    @Theory
    public void testCase(Fixture params) throws Exception {
        assertThat(params.x + params.y, is(params.expected));

    }

    static class Fixture {

        int x;
        int y;
        int expected;

        Fixture(int x, int y, int expected) {
            this.x = x;
            this.y = y;
            this.expected = expected;
        }
    }
     */

}
