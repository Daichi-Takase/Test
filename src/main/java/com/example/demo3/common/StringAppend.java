package com.example.demo3.common;
 
public class StringAppend {

	public static String append1(String str) throws InterruptedException {
		
		String result = "";

		for (int i = 0; i < 10000; i++){
			result += str;
			Thread.sleep(1);
		}
		System.out.println(result);
		return result;
	}

	public static String append2(String str) throws InterruptedException {
		
		StringBuffer resultSb = new StringBuffer();

		for (int i = 0; i < 10000; i++){
			resultSb.append(str);
			Thread.sleep(1);
		}
		String result = resultSb.toString();
		System.out.println(result);
		return result;
	}

}