package com.code.challenges.google;

import java.util.Deque;
import java.util.LinkedList;

public class DecompressString {	
	
	static String decompressString1(String input) {
		Deque<Character> stack = new LinkedList<>();
		for (int i = 0; i< input.length(); i++) {
			stack.offer(input.charAt(i));
		}
		return processStack(stack);
	}
	
	static String processStack(Deque<Character> st) {
		StringBuilder sb = new StringBuilder();
		int index = 0;
		while (!st.isEmpty()) {
			char ch = st.pop();
			if (Character.isDigit(ch)) {
				index = index * 10 + ch - '0';
			} else if (ch == ']') {
				break;
			} else if (ch == '[') {
				String temp = processStack(st);
				sb.append(temp.repeat(index));
				index = 0;
			} else {
				sb.append(ch);
			}
		}
		
		return sb.toString();
	}
	

	public static void main(String[] args) {
		
		System.out.println(decompressString1("2[3[a]b]"));
		System.out.println(decompressString1("3[abc]4[ab]c"));
		System.out.println(decompressString1("10[a]"));
		System.out.println(decompressString1("a[]b"));
		System.out.println(decompressString1("0[abc]"));
	}
}
