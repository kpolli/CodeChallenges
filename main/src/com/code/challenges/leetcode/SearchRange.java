package com.code.challenges.leetcode;

import java.util.Arrays;

public class SearchRange {
	
	public static int[] searchRange(int[] nums, int target) {
        int pivot = nums.length/2;
		int begin = 0, end = nums.length;
        boolean found = false;
        boolean notExist = false;
        while (!found && !notExist) {
            if (nums[pivot] == target) {
                begin = pivot;
                end = pivot;
                while (begin > -1 && nums[begin] == target){
                    begin--;
                }
                begin +=1;
                while (end < nums.length && nums[end] == target){
                    end++;
                }
                end -=1;
                found = true;
            } else if (pivot == begin || pivot == end) {
            	notExist = true;
            } else if (nums[pivot] < target) {
                begin = pivot;
                pivot = (end + begin) / 2;
            } else if (nums[pivot] > target){
                end = pivot;
                pivot = (end - begin) / 2;
            } 
        }
        int [] response = new int[2];
        if (notExist) {
        	response[0] = -1;
        	response[1] = -1;
        } else {
        	response[0] = begin;
        	response[1] =  end;
        }
        return response;
    }
	
	public static void main(String[] args) {
		int[] nums = {5,7,7,8,8,10};
		System.out.println(Arrays.toString(searchRange(nums, 10)));
	}

}
