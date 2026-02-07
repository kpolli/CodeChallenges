package com.code.challenges.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class UniqueSubsets {

	@SuppressWarnings("unchecked")
	public static List<List<Integer>> subsets(int[] nums) {
        Stack<List<Integer>> stack = new Stack<>();
        stack.push(new ArrayList<>());
        for (int i = 0; i < nums.length; i++){
            Stack<List<Integer>> tempstack = (Stack<List<Integer>>) stack.clone();
            while (!stack.isEmpty()){
                List<Integer> temp = new ArrayList<>(stack.pop());
                temp.add(nums[i]);
                tempstack.push(temp);
            }
            stack = (Stack<List<Integer>>) tempstack.clone();
        }
        return new ArrayList<>(stack);
    }
	
	public static void main(String[] args) {
		int [] nums = new int[1];
		nums[0] = 1;
		///nums[1] = 2;
		//nums [2] = 3;
		System.out.println(subsets(nums).toString());
	}
}
