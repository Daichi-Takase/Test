package com.example.demo3.common;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.collection.IsEmptyCollection.*;
import static org.hamcrest.collection.IsIterableContainingInOrder.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

class HelloCommonTest {

    @Test
    void test1() {
        int result = HelloCommon.execAdd(1, 2);
        assertEquals(3, result);
    }

    @Test
    void test2() {
        int result = HelloCommon.execAdd(3, 4);
        assertEquals(7, result);
    }

    @Test
    void test3() {
        int result = HelloCommon.execAdd(5, 6);
        assertEquals(11, result);
    }

    @Test
    void test4() {
        HelloCommon h = new HelloCommon();
        boolean result = h.isZandaka(10000, 9999);
        assertTrue(result);
    }

    //assertThat確認
    class Testclass1 {

        public String getTestclass1() {
            return "1";
        }
    }

    @Test
    public void test5() {

        assertThat(true, is(true));
        assertThat("hoge", is("hoge"));

        List<String> list = Arrays.asList("hoge", "fuga", "piyo");
        assertThat(list, is(not(empty())));
        assertThat(list, is(contains("hoge", "fuga", "piyo")));

        String test2 = null;
        assertThat(test2, is(nullValue())); //成功
        String test3 = "null";
        assertThat(test3, is(notNullValue())); //成功

        Testclass1 t1 = new Testclass1();
        Testclass1 t2 = t1;
        assertThat(t1, is(sameInstance(t2))); //成功
        assertThat(t1, is(instanceOf(Testclass1.class))); //成功

        List<String> colors = new ArrayList<>();
        colors.add("赤");
        colors.add("黄");
        colors.add("青");
        assertThat(colors, hasItem("黄")); //成功
        assertThat(colors, hasItems("黄", "青")); //成功

        String test1 = "123testABC";
        assertThat(test1, containsString("test")); //成功
        assertThat(test1, startsWith("12")); //成功
        assertThat(test1, endsWith("BC")); //成功
    }

    /*
    @Test
    public void test6() throws Exception{
        SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd");
        Date d = f.parse("2021/10/13");
        assertThat(d, is(dateOf(2021, 10, 13)));
    }
     */

    //例外
    /*
        @Test(expected = Illegalargumentexception.class)
        public void 例外テスト() throws Exception {
            sut.doSomething();
        }
     */
}
