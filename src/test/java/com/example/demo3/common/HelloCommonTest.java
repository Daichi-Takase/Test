package com.example.demo3.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.refEq;

import org.junit.jupiter.api.Test;

class HelloCommonTest {

	@Test
	void test1() {
		int result = HelloCommon.execAdd(1,2);
		assertEquals(3, result);
	}

	@Test
	void test2() {
		int result = HelloCommon.execAdd(3,4);
		assertEquals(7, result);
	}
        
	@Test
	void test3() {
		int result = HelloCommon.execAdd(5,6);
		assertEquals(11, result);
	}

}
