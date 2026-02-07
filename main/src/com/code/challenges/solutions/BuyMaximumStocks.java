package goldmansacs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class BuyMaximumStocks {
	
	/*
	 * A function given the max amount of stocks that one can buy if given the price of stock 
	 * each day for a period 
	 * */

	static long buyMaximumProducts(int n, long k, int[] a) {
		Map<Integer, List<Integer>> map = new TreeMap<>();
        long numOfStocks = 0;
        for (int i = 0; i < a.length; i++){
        	if (map.containsKey(a[i])){
        		List<Integer> list = map.get(a[i]);
        		list.add(i);
        		map.put(a[i], list);
        	} else{
        		List<Integer> list = new ArrayList<>();
        		list.add(i);
        		map.put(a[i], list);
        	}
        	
        }
        
        Iterator<Entry<Integer, List<Integer>>> it = map.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<Integer, List<Integer>> p = (Map.Entry<Integer, List<Integer>>) it.next();
			if (p.getKey() >= k){
				break;
			}
			for (int i = 0; i < p.getValue().size(); i++){
				long t = p.getValue().get(i) + 1;
				if (k >= p.getKey() * t){
					k = k -  (p.getKey() * t);
					numOfStocks += t;
				} else {
					while (k >= p.getKey() && t > 0){
						k = k - p.getKey();
						t--;
						numOfStocks++;
					}
				}
				
			}
		}
		return numOfStocks;
        
    }

    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 5, 9, 7, 7};
 
        long result = buyMaximumProducts(7, 100, arr);
        System.out.println(result);
    }

}
