package goldmansacs;

public class TraderProfit {
	
	/**
	 * Get the max profit that can be made if one buys and sells stock but you can't buy unless you sell
	 * */

	static int traderProfit(int k, int n, int[] A) {
		
		return traderProfit(k, A,0);
    }
	
	static int traderProfit(int k, int [] A, int index){
		if (k == 0){
			return 0;
		}
		int profit = 0;
		for (int i = index; i < A.length - 1; i++){
			int amount = 0;
			for (int j = i + 1; j < A.length; j++){
				if (A[i] < A[j]){
					amount = A[j] - A[i];
					amount += traderProfit(k - 1,A, j + 1);
					if (amount > profit){
						profit = amount;
					}
				}
			} 
			
			
		}
		return profit;
	}

    public static void main(String[] args) {
            int[] arr = {20, 580, 420, 900};
            int result = traderProfit(3, 4, arr);
            System.out.println(result);
    }
}
