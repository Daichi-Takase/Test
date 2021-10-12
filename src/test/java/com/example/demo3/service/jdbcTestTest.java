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
