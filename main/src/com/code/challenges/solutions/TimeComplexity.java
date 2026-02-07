package solutions;

import java.util.Scanner;

public class TimeComplexity {
	
	/*
	 * Various ways to check if number is a prime number
	 * */

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        for(int a0 = 0; a0 < p; a0++){
            int n = in.nextInt();
            boolean b = isPrime(n);
            if (b) {
            	System.out.println("Prime");
            } else {
            	System.out.println("Not prime");
            }
        }
    }
	
	private static boolean isPrime(int n){
		if (n < 2) return false;
	    //if not, then just check the odds
	    for(int i=2;i*i<=n/2;i+=2) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}
	
	private static boolean is_prime(int n){
	    return java.math.BigInteger.valueOf(n).isProbablePrime(1);
	    
	}

}
