package com.code.challenges.leetcode;

public class ArrayToBTS {

	public class TreeNode {
		int val;
		public TreeNode left;
		public TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	public TreeNode sortedArrayToBST(int[] nums) {
		
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }
	
	public TreeNode sortedArrayToBST(int[] nums, int mid, int curr) {
		if (mid > curr) {
			return null;
		}
        int pivot = mid + (curr - mid)/2;
        TreeNode tree = new TreeNode(nums[pivot]);
        tree.left = sortedArrayToBST(nums, mid, pivot -1);
        tree.right = sortedArrayToBST(nums, pivot + 1, curr);
        return tree;
    }

	public static void main(String[] args) {
		int [] num = {-10,-3,0,5,9};
		
		ArrayToBTS bts = new ArrayToBTS();
		System.out.println(bts.sortedArrayToBST(num));
		int []num1 = {1,3};
		System.out.println(bts.sortedArrayToBST(num1));
		
	}
}
