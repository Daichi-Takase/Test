package com.example.demo3.common;
 
import java.util.Arrays;
import java.util.List;

public class HelloCommon {

    List<String> list =  Arrays.asList("hoge", "fuga", "piyo");
    
	public static int execAdd(int a, int b) {
		return a + b;
	}

	public boolean isZandaka(double a, double b) {
		return a - b >= 0;
	}
        
}
