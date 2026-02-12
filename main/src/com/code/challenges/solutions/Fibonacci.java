package com.code.challenges.solutions;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
	
	/*
	 * Various ways of getting the fibonnaci of a number
	 * */
	
	public static int fibonnaci(int i){
		int x = 1, y = 0;
		for (int j = 2; j <= i; j++){
			int temp = y;
			y = x;
			x = x + temp;
		}
		return x;
	}
	
	public static int fib(int i) {
		if (i <= 1) {
			return i;
		}
		return fib(i - 1) + fib(i - 2);
	}
	static Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	public static int davisStairs(int i) {
		if (i == 0) {
			return 1;
		}
		if (i <= 2) {
			return i;
		}
		
		if (!map.containsKey(i)) {
			map.put(i, davisStairs(i - 1) + davisStairs(i - 2) + davisStairs(i - 3));
		}
		return map.get(i);
	}
	public static void main(String[] args) {
		//int x = fibonnaci(5);
		//System.out.println(x);
		//x = fib(5);
		//System.out.println(x);
		int y  = davisStairs(4);
		System.out.println(y);
	}
}
