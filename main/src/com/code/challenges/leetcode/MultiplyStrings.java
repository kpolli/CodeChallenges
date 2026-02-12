package com.code.challenges.leetcode;

public class MultiplyStrings {


	public static String multiply(String num1, String num2) {
        char [] n1 = num1.toCharArray();
        char [] n2 = num2.toCharArray();
        int carryOver = 0;
        int [] res = new int [n1.length + n2.length];
        StringBuilder answer = new StringBuilder();
        for (int i = n1.length-1; i > -1; i--) {
        	for (int j = n2.length-1; j > -1; j--) {
        		int col = (n2[j] - '0')  * (n1[i] - '0') + carryOver;
        		int p1 = i + j, p2 = i + j + 1;
        		int temp  = res[p2] + col;
        		res[p2] = temp % 10;
        		res[p1] += temp/10;
        	}
        }
        for (int t : res) {
        	if (!(answer.length() == 0 && t == 0)) {
        		answer.append(t);
        	}
        }
        if (answer.isEmpty()) {
        	return "0";
        }
        return answer.toString();
    }
	
	public static void main(String[] args) {
		System.out.println(multiply("123","377"));
	}
}
