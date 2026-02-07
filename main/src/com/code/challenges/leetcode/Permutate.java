package com.code.challenges.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutate {

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> response = new ArrayList<>();
		if (nums == null)
			return response;
		permute(nums, response, new ArrayList<>());
		return response;
	}

	private static void permute(int[] nums, List<List<Integer>> response, List<Integer> tempList) {
		if (tempList.size() == nums.length) {
			response.add(new ArrayList<>(tempList));
			return;
		}
		for (int temp = 0; temp < nums.length; temp++) {
			if (!tempList.contains(nums[temp])) {
				tempList.add(nums[temp]);
				permute(nums, response, tempList);
				tempList.remove(tempList.size() - 1);
			}

		}
	}

	public static List<List<Integer>> permute2(int[] nums) {
		Set<List<Integer>> res = new HashSet<>();
		List<List<Integer>> response = new ArrayList<>();
		if (nums == null)
			return response;
		permute2(nums, res, new ArrayList<>());
		response.addAll(res);
		return response;
	}

	private static void permute2(int[] nums, Set<List<Integer>> response, List<Integer> tempList) {
		if (tempList.size() == nums.length) {
			List<Integer> convertedList = new ArrayList<>();
			for (int i = 0; i < tempList.size(); i++) {
				convertedList.add(nums[tempList.get(i)]);
			}
			response.add(new ArrayList<>(convertedList));
			
		}
		for (int temp = 0; temp < nums.length; temp++) {
			if (!tempList.contains(temp)) {
				tempList.add(temp);
				permute2(nums, response, tempList);
				tempList.remove(tempList.size() - 1);
			}

		}
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 3 };
		System.out.println(permute2(nums));
	}

}
