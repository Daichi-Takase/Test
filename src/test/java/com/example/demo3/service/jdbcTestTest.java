package com.example.demo3.service;

import org.junit.Ignore;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class jdbcTestTest {

    @Test
    void test1() {
        long result = JdbcTest.testJdbc("AAA");
        assertEquals(2, result);
    }

    @Test
    void test2() {
        long result = JdbcTest.testJdbc("CCC");
        assertEquals(1, result);
    }

    @Test
    void test3() {
        long result = JdbcTest.testJdbc("CCC");
        assertSame(1, result);
    }

    @Test
    void test4() {
        long result = JdbcTest.testJdbc("CCC");
        assertNull(result);
    }

    @Test
    void test5() {
        long result = JdbcTest.testJdbc("CCC");
        assertNotNull(result);
    }

    @Test
    void test6() {
        fail();
    }
}
