package com.code.challenges.solutions;

public class MergeSort {
	
	static char [] mergeSort(char [] array) {
		if(array == null || array.length <= 1) {
			return array;
		}
		int half = array.length/2;
		return merge(mergeSort(split(array, 0, half)), mergeSort(split(array, half, array.length - half)));
		
	}
		
	static char[] merge(char[] a, char[] b) {
		char [] c = new char[a.length + b.length];
		int aa = 0, bb = 0, cc = 0; 
		while ((aa < a.length || bb < b.length) && cc < c.length) {
			if (aa < a.length && bb < b.length && a[aa] < b[bb]) {
				c[cc] = a[aa];
				aa++;
			
			} else if(bb >= b.length){
				c[cc] = a[aa];
				aa++;
			}else {
				c[cc] = b[bb];
				bb++;
			}
			cc++;
		}
		
		return c;
	}
	
	static char [] split(char[] arr, int piv, int size) {
		char [] half = new char[size];
		for(int i = 0; i < size; i++) {
			half[i] = arr[i + piv];
		}
		return half;
	} 
	
	public static void main(String [] args) {		
		char arr [] = {'o','u','z','w','a','b', 'c'};
		char [] ret = mergeSort(arr);
		for(int i = 0; i < ret.length; i++)
			System.out.print(ret[i] + " ");
	}

}
