package com.code.challenges.leetcode;

public class RaisedPower {
	
	public static double myPow(double x, int n) {
        double y = 0;
        if (n > 0) {
        	y = x;
        } else {
        	y = 1/x;
        	x = 1/x;
        }
        
        int temp = n == Integer.MIN_VALUE ? Integer.MAX_VALUE: Math.abs(n);
        
        for(int i = 1; i < temp; i++) {
            y *= x;
        }
        return y;
    }
	
	public static void main(String[] args) {
		System.out.println(Math.pow(2, -2));
		System.out.println(myPow(2, -2));
	}

}
