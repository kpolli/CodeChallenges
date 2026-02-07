package goldmansacs;

import java.util.Arrays;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TimeSeriesQueries {
	
	/***
	 * Get the minimum time a stock was/greater than a certain price or get the highest price a stock is after a certain time
	 * */
	
	static int getIndex(int var, int [] prices){
		if (prices.length == 1) return 0;
		int half = prices.length / 2; 
		int arr1 [] = Arrays.copyOfRange(prices, 0, half);
		int arr2 [] = Arrays.copyOfRange(prices, half, prices.length);
		if(IntStream.of(arr1).anyMatch(x -> x >= var)){
			return getIndex(var, arr1);
		} else if (IntStream.of(arr2).anyMatch(x -> x >= var)){
			return half + getIndex(var, arr2);
		} else {
			return -1;
		}
	}
	
	static int getMinTime(int var, int []times, int [] prices){
		// Split array into 2;
		//if arr1 has var do first if, else do second if
		int index = getIndex(var, prices);
		
		if (index == -1) return -1;
		else return times[index];
	}
	
	static int getMaxPrice(int var, int [] times, int [] prices){
		int max = getIndex(var, times);
		if (max == -1) return -1;
		else return prices[max];
		
	}
	
	static int getTimeSeries(int type, int var, int []times, int [] prices, int pivot){
		
		if (type == 1){
			
			for (int i = 0; i < prices.length; i++){
				if (prices[i] >= var){
					return times[i];
				}
			}			
		} else {
			int max = 0;
			List<Integer> list = IntStream.of(times).boxed().collect(Collectors.toList());
			IntStream.range(var, list.size())
			  .reduce((a,b)->list.get(a)<list.get(b)? b: a)
			  .ifPresent(ix->System.out.println("Index "+ix+", value "+list.get(ix)));
			for (int i = 0; i < times.length; i++){
				if (times[i] >= var && prices[i] > max){
					max = prices[i];
				}
			}
			if (max > 0){
				return max;
			}
			
		}
			
		return -1;
	}

    public static void main(String[] args) {
        int[] t = {1, 2, 4, 8, 10};
        int[] p = {5, 3, 12, 1, 10};
        //System.out.println(getTimeSeries(2, 3, t, p));
        int _type = 1;
        int v = 13;

        NavigableMap<Integer, Integer> map1 = new TreeMap<>();
        NavigableMap<Integer, Integer> map2 = new TreeMap<>();
        int max = 0;
        for (int i = 0; i < p.length; i++){
        	if (p[i] > max){
        		max = p[i];
        		map1.put(max, t[i]);
        	}
        }
        max = 0;
        for (int i = t.length - 1; i > 0; i--){
        	if (map2.isEmpty()){
        		map2.put(t[i], p[i]);
        		max = p[i];
        	} else {
        		if (max < p[i]){
        			max = p[i];
        			map2.put(t[i], p[i]);
        		} else{
        			map2.put(t[i], max);
        		}       			
        	}       	
        }
        
		if (_type == 1){
			if (map1.ceilingKey(v) != null) {
				System.out.println(map1.get(map1.ceilingKey(v)));
			}
			else System.out.println(-1);
			
		} else {
			if (t[t.length - 1] < v) {
				System.out.println(-1);
			} else {
			
				System.out.println(map2.get(map2.ceilingKey(v)));
			}
		}
    }
    


}
