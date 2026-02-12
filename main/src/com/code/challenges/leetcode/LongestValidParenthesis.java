package com.code.challenges.leetcode;

import java.util.Stack;

public class LongestValidParenthesis {
	
	public static int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int longest = 0;
        st.add(-1);
        for (int i = 0; i < s.length(); i++) {
        	char ch = s.charAt(i);
        	if (ch == '(') {
        		st.add(i);
        	} else {
        		st.pop();
        		if (st.isEmpty()) {
        			st.add(i);
        		} else {
        			if(longest < i-st.peek()) {
        				longest = i-st.peek();
        			}
        		}
        	}
        }
        return longest;
    }

	public static void main(String[] args) {
		System.out.println(longestValidParentheses("("));
		System.out.println(longestValidParentheses("(()"));
		System.out.println(longestValidParentheses(")()())"));
		System.out.println(longestValidParentheses(""));
		System.out.println(longestValidParentheses("()(())"));
		System.out.println(longestValidParentheses("()(()"));
		System.out.println(longestValidParentheses("()(())()()))()()()"));
		// Use a stack, boolean and counter
		// stack is for open and close, counter adds number of valid brackets
		// boolean shows when an invalid bracket has been established and resets bracket count
	}
}
