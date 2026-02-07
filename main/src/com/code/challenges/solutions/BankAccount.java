package goldmansacs;

import java.util.Scanner;

public class BankAccount {
	
	/*
	 * A function to determine if a user should use his checking account
	 * to pay for goods or use a special bank account. It checks the charge of buying
	 * each item + fee and compares it to if he pays a on time fee
	 * */

    static String feeOrUpfront(int n, int k, int x, int d, int[] p) {
        // Complete this function
    	
    	float currAccCharge = 0;
    	for (int i = 0; i < p.length; i++){
    		currAccCharge += Math.max(x * p[i] / 100.0f, k);    		
    	}
    	return currAccCharge > d ? "upfront" : "fee";
    }

    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
       // int q = in.nextInt();
        //for(int a0 = 0; a0 < q; a0++){
         //   int n = in.nextInt();
         //   int k = in.nextInt();
          //  int x = in.nextInt();
          //  int d = in.nextInt();
            int[] p = {10, 20, 30, 20, 10};
            //for(int p_i = 0; p_i < n; p_i++){
              //  p[p_i] = in.nextInt();
           // }
            String result = feeOrUpfront(5, 5, 20, 20, p);
            System.out.println(result);
       // }
        //in.close();
    }

}
