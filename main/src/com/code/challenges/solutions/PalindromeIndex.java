package com.code.challenges.solutions;

import java.util.Stack;

public class PalindromeIndex {
	
	/*
	 * Various ways of checking if a string is a palindrome or anagram
	 * */

    static boolean isPalindrome(String s, int i){
        StringBuilder sb = new StringBuilder(s);
        if (i > -1)
            sb.deleteCharAt(i);
        String t = sb.toString();
        return sb.reverse().toString().equals(t);
    }

    static int palindromeIndex(String s){
        // Complete this function
        if (isPalindrome(s, -1))
            return -1;
        
        for (int i = 0; i < s.length(); i++){
            if (isPalindrome(s, i)){
                return i;
            }
        }
        return -1;
    }
    
    static int removeIndex(char a, char b, char c, char x, char y, char z){
    	
    	return 0;
    }
    
    static int palindromeInde(String s){
        // Complete this function
        for (int i = 0; i < s.length()/2; i++){
        	if (s.charAt(i) != s.charAt(s.length() - (i + 1))){
        		String sb = new StringBuilder(s).deleteCharAt(i).toString();
        		String sb1 = new StringBuilder(s).deleteCharAt(s.length() - (i + 1)).toString();
        		if (sb.equals(new StringBuilder(s).deleteCharAt(i).reverse().toString())){
        			return i;
        		} else if (sb1.equals(new StringBuilder(s).deleteCharAt(s.length() - (i + 1)).reverse().toString())) {
        			return s.length() - (i + 1);
        		}
        	}
        }
    	
    	return -1;
    }
    
    static int palindromeInd(String s){
        // Complete this function
    	Stack<Character> st = new Stack<>();
    	Stack<Character> st1 = new Stack<>();
        for (int i = 0; i < s.length()/2; i++){
        	st.add(s.charAt(i));
        	st1.add(s.charAt(s.length() - (i + 1)));
        }
        int count = 0;
        while (!st.isEmpty() && !st1.isEmpty()){
        	char c1 = st.pop();
        	char c2 = st1.pop();
        	if (c1 != c2){
        		if(c1 == st1.peek()){
        			return s.length()/2 + count;
        		} else if (c2 == st.peek()){
        			return s.length()/2 - count;
        		}
        		count++;
        	}
        }
    	
    	return -1;
    }
    
    static int anagram(String s){
        // Complete this function
        int count = 0;
        int[] letters = new int[26];
        if (s.length() % 2 != 0){
            return -1;
        }
        for (int j = 0; j < s.length()/2; j++){
            letters[s.charAt(j)-'a']++;
        }
        for (int j = s.length()/2; j<s.length(); j++){
            if(letters[s.charAt(j)-'a'] > 0)
                letters[s.charAt(j)-'a']--;
        }
        for (int j = 0; j<26; j++){
            count += letters[j];
        }
           	
    	return count;
    }
    
    static int makingAnagrams(String s1, String s2){
        int count = 0;
        int[] letters = new int[26];
        for (int j = 0; j < s1.length(); j++){
            letters[s1.charAt(j)-'a']++;
        }
        for (int j = 0; j < s2.length(); j++){
                letters[s2.charAt(j)-'a']--;
        }
        for (int j = 0; j<26; j++){
            count += Math.abs(letters[j]);
        }
           	
    	return count;
    }
    
    public static String longestPalindrome(String s) {
    	String str = "";
        for (int i = 0; i < s.length(); i++){
        	
        	String temp = getLongestPalindrome(s, i ,i);
        	if (temp.length()>str.length()) str = temp;
        	temp = getLongestPalindrome(s, i ,i + 1);
        	
        	if (temp.length()>str.length()) str = temp;
        }
    
    	return str;
    }
    
    static String getLongestPalindrome(String s, int l, int r){
    	if (l > r) return "";
    	while (l > -1 && r < s.length() && s.charAt(l) == s.charAt(r)){
    		l--;
    		r++;
    	}
    	return s.substring(l + 1, r);
    	
    }
    
    static boolean isPalindrome(String s){
        StringBuilder sb = new StringBuilder(s);
        String t = sb.toString();
        return sb.reverse().toString().equals(t);

    }

    public static void main(String[] args) {
    		
            System.out.println(longestPalindrome("abb"));
        
    }

}
