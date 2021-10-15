<<<<<<< HEAD
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
=======
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo3.service;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

}

>>>>>>> 2f78daa929cd5162a2ac51c4bf3f83af8428652d
