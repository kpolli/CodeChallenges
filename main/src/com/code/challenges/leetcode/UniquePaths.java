package com.code.challenges.leetcode;

import java.util.HashMap;
import java.util.Map;

public class UniquePaths {
	
	public static int uniquePaths(int m, int n) {
        int [][] arr = new int [m][n];
        Map<String, Integer> pathMapped = new HashMap<>();
        int down = uniquePaths(arr, 1, 0, pathMapped);
        int right = uniquePaths(arr, 0, 1, pathMapped);
        return down + right;
    }
	
	public static int uniquePaths(int[][] arr, int m, int n, Map<String, Integer> map) {
		if (m == arr.length - 1 && n == arr[0].length - 1) {
			map.put(m + "-" + n, 1);
			return 1;
		} else if (m >= arr.length || n >= arr[0].length || arr[m][n] == 1) {
			map.put(m + "-"+ n, 0);
			return 0;
		}
		int ta = m + 1;
		String a = ta+"-"+n;
		int countDown = 0;
		if (map.containsKey(a)) {
			countDown = map.get(a);
			
		} else {
			countDown = uniquePaths(arr, ta, n, map);
		}
		//map.put(m + "-" + n, countDown);
		int tb = n + 1;
		String b = m+"-"+tb;
		int countRight = 0;
		if (map.containsKey(b)) {
			countDown = map.get(b);
			
		} else {
			countRight = uniquePaths(arr, m, tb, map);
		}
		map.put(m + "-" + n, countDown + countRight);
		return countDown + countRight;
        
    }
	
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        Map<String, Integer> pathMapped = new HashMap<>();
        int down = uniquePaths(obstacleGrid, 1, 0, pathMapped);
        int right = uniquePaths(obstacleGrid, 0, 1, pathMapped);
        return down + right;
    }
	
	public static void main(String[] args) {
		System.out.println(uniquePaths(19,13));
		// 86493225
	}

}
