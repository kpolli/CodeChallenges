package com.code.challenges.solutions;

import java.util.Arrays;

public class UniqueNumber {
	
	/*
	 * Getting a unique number in a arr
	 * */
	
	public static void main(String[] args) {
		int arr[] = {4, 9, 95, 93, 57, 4, 57, 93, 9, 97, 97};
		System.out.println(uniqueNumber(arr));
	}

	public static int uniqueNumber(int [] arr) {
        Arrays.sort(arr);
        int unique = arr[arr.length - 1];
        for (int i = 1; i < arr.length; i += 2) {
            //if ()
            if (arr[i - 1] != arr[i]) {
                unique = arr[i - 1];
                break;
            } 
        }
        return unique;
    }
}
