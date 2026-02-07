package com.code.challenges.leetcode;

public class JumpGame {
	
	public static int jump(int[] nums) {
		int end = 0, furthest = 0, count = 0;
		for (int i = 0; i < nums.length; i++) {
			furthest = Math.max(i, nums[i] + 1);
			if (furthest >= nums.length) {
				count++;
				break;
			}
			if (i == end) {
				count++;
				end = furthest;
			}
		}
        return count;
    }
	
	public static void main(String[] args) {
		int [] num = {1,1,1,1};
		System.out.println(jump(num));
	}

}
