package com.code.challenges.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PascalTriangleII {
	
	static Map<Integer, List<Integer>> staticmap = new HashMap<>();
    public static List<Integer> getRow(int rowIndex) {
        if (staticmap.containsKey(rowIndex)) {
            return staticmap.get(rowIndex);
        }
        List<Integer> response = new ArrayList<>();
        if (rowIndex == 0) {
        	response.add(1);
        	staticmap.put(0, response);
        }
        for(int i = 0; i <= rowIndex; i++) {
            if (staticmap.containsKey(i)){
                continue;
            } else {
                List<Integer> temp = null;
                if (staticmap.containsKey(i-1)) {
                    temp = staticmap.get(i-1);
                } else if (i < 0){
                    temp = new ArrayList<>();
                    temp.add(1);
                    staticmap.put(0, temp);
                    continue;
                }
                response = new ArrayList<>();
                for (int j = 0; j < temp.size(); j++) {
                    if (j > 0){
                        response.add(temp.get(j) + temp.get(j - 1));
                    } else {
                        response.add(temp.get(j));
                    }
                    
                }
                response.add(1);
                staticmap.put(i, response);
            }
        }
        return response;
    }
    
    public static void main(String[] args) {
		
		System.out.println(getRow(3));
		
	}

}
