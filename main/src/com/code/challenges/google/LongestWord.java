package com.code.challenges.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestWord {

	static String longestWord(String s, List<String> d) {
		Map<Character, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				map.get(c).add(i);
			} else {
				List<Integer> temp =new ArrayList<>();
				temp.add(i);
				map.put(c, temp);
			}
		}
		String maxLength = "";
		for (String ind : d) {
			int prevIndex = -1;
			boolean endLoop = false;
			
			for (int i = 0; i < ind.length(); i++) {
				if (!endLoop) {
					char c = ind.charAt(i);
					if (map.containsKey(c)) {
						List<Integer> temp = map.get(c);
						for (int j = 0; j < temp.size(); j++) {
							int t = temp.get(j);
							if (t > prevIndex) {
								prevIndex = t;
								break;
							} else if (t <= prevIndex && j < temp.size()-1){
								continue;
							} else {
								endLoop = true;
							}
							
						}
					} else {
						endLoop = true;
					}
					
				} else {
					break;
				}
				
			}
			if (ind.length() > maxLength.length() && !endLoop) {
				maxLength = ind;
			}
		}
		return maxLength;
	}
	
	public static void main(String[] args) {		
		System.out.println(longestWord("abppplee", Arrays.asList("able", "ale", "apple", "bale", "kangaroo", "abpppel")));
		System.out.println(longestWord("abpppleel", Arrays.asList("able", "ale", "apple", "bale", "kangaroo", "abpppel")));
		System.out.println(longestWord("abpppleel", Arrays.asList("able", "ale", "apple", "bale", "kangaroo", "abppplel")));
	
	}
}
