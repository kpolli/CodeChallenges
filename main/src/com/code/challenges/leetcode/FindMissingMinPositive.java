package com.code.challenges.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FindMissingMinPositive {

	public static int firstMissingPositive(int[] nums) {
        int min = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            map.put(temp, 1);
            if (temp == min){
                while (map.containsKey(min)){
                	System.out.println(min++);
                }
            }
        }
        return min;
    }
	
	public static void main(String[] args) {
		int [] num = {1,3,4,5,-1};
		System.out.println(firstMissingPositive(num));
	}
}
