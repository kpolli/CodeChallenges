package com.code.challenges.leetcode;

public class RegularExpressionMatch {
	
	public static boolean isMatch(String s, String p) {
		if (s == null || p == null) {
			return false;
		}
		boolean [][] response = new boolean [s.length() +1][p.length() + 1];
		response[0][0] = true;
		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == '*' && response[0][i-1]) {
				response[0][i+1] = true;
			}
		}
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < p.length(); j++) {
				if (i == s.length() - 1 && j == p.length()-1) {
					System.out.println("the last one");
				}
				char pp = p.charAt(j);
				char ss = s.charAt(i);
				if (pp == '.' || pp == ss) {
					response[i+1][j+1] = response[i][j];
				} else if (p.charAt(j) == '*') {
					if (p.charAt(j-1) != ss && p.charAt(j-1) != '.') {
						response[i+1][j+1] = response[i+1][j-1];
					} else {
						response[i+1][j+1] = (response[i+1][j] || response[i][j+1] || response[i+1][j-1] );
					}
				}
				
			}
		}
		
		return response[s.length()][p.length()];
	}
	
	public static boolean isMatch1(String s, String p) {
        if (s == null || p == null) {
			return false;
		}
        int i = 0, j = 0, pPosition = -1, sPosition = -1;
		while (i < s.length()) {
			if (j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
				i++;
				j++;
			} else if (j < p.length() && p.charAt(j) == '*') {
				sPosition = i;
				pPosition = j;
				j++;
			} else if (pPosition != -1) {
				j = pPosition + 1;
				i = ++sPosition;
				
			} else {
				return false;
			}
		}
		while (j < p.length() && p.charAt(j) == '*') {
			j++;
		}
		return j == p.length();
    }
	
	public static void main(String[] args) {
		//System.out.println(isMatch1("mississippi", "mis*is*ip*."));
		//System.out.println(isMatch("ab", ".*"));
		//System.out.println(isMatch1("aa", "*"));
		//System.out.println(isMatch("aa", "a"));
		//System.out.println(isMatch("aa", "a*"));
		//System.out.println(isMatch("aab", "c*a*b"));
		System.out.println(isMatch1("aab","c*a*b"));
	}

}
