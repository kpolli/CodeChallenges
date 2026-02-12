package com.code.challenges.leetcode;

import java.util.Arrays;

public class Rotate2DArray {

	public static void rotate(int[][] matrix) {
        int [][] response = Arrays.stream(matrix)
                .map(arr -> arr.clone())
                .toArray(s -> matrix.clone());
        for (int i = 0; i < response.length; i++){

            for (int j = 0; j < response[i].length; j++){
                matrix[i][j] = response[response.length - (j + 1)][i];
            }
        }
        System.out.println(matrix);
    } 
	
	public static void main(String[] args) {
		int [][] nums = {{1,2,3},{4,5,6},{7,8,9}};
		///nums[1] = 2;
		//nums [2] = 3;
		rotate(nums);
	}
}
