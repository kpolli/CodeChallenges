package com.code.challenges.leetcode;

public class TrappingRainWater {
	
	static int trap(int[] height) {
		int [] depth = new int [height.length];
		int currentMax= 0;
        for (int i = height.length - 1; i > -1; --i) {
        	depth[i] = currentMax;
        	if (height[i] > currentMax) {
        		currentMax = height[i];
        	}
        }
        
        int depthCount = 0;
        currentMax = 0;
        for (int i = 0; i < height.length; ++i) {
        	if (currentMax > 0 && height[i] < currentMax && height[i] < depth[i]) {
        		if (currentMax > depth[i]) {
        			depthCount += depth[i] - height[i];
        		} else {
        			depthCount += currentMax - height[i];
        		}
        	}
        	
        	if (currentMax < height[i]) {
        		currentMax = height[i];
        	}
        }
        return depthCount;
    }

	public static void main(String[] args) {
		int [] str = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(str));
		int [] str1 = {4,2,0,3,2,5};
		System.out.println(trap(str1));
	}
	
}
