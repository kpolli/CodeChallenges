package com.code.challenges.leetcode;

import java.util.Arrays;

public class NextPermutation {

	public static void nextPermutation(int[] nums) {
		int pivot = findDescending(nums) - 1;
		
		if (pivot != - 1) {
			int index = findAscending(nums, nums[pivot]);
			swap(nums, pivot, index);
		}
		reverseArray(nums, pivot +1);
		System.out.println("pivot is " + pivot);
		System.out.println(Arrays.toString(nums));
	}
	
	static int findDescending(int [] nums) {
		for (int i = nums.length-1; i > 0; i--) {
			if(nums [i] > nums[i-1]) {
				return i;
			}
		}
		return 0;
	}
	
	static int findAscending(int [] nums, int target) {
		for (int i = nums.length-1; i > 0; i--) {
			if(nums [i] > target) {
				return i;
			}
		}
		return 0;
	}

	static void reverseArray(int[] arr, int ind) {
		int end = arr.length-1;
		while (ind < end) {
			swap(arr, ind++, end--);
		}
	}

	static void swap(int[] nums, int i, int j) {
		int temp = nums[j];
		nums[j] = nums[i];
		nums[i] = temp;
	}

	public static void main(String[] args) {
		int[] nums = {3,2,1};
		nextPermutation(nums);
	}
}
