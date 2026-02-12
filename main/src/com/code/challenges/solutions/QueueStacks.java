package com.code.challenges.solutions;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class QueueStacks {
	
	/*
	 * Implementing a queue using 2 stacks
	 * */

	public static class MyQueue<T> {
        Stack<T> stackNewestOnTop = new Stack<T>();
        Stack<T> stackOldestOnTop = new Stack<T>();

        public void enqueue(T value) { // Push onto newest stack
            stackNewestOnTop.add(value);
       
        }

        public T peek() {
            T p;
            if (!stackOldestOnTop.empty())
                p = (T)stackOldestOnTop.peek();
            else
                p = (T)stackNewestOnTop.firstElement();
            return p;
        }

        public T dequeue() {
        	if (stackOldestOnTop.empty()) {
	            while (!stackNewestOnTop.empty()) {
	                stackOldestOnTop.add(stackNewestOnTop.pop());
	            }
        	}
            return stackOldestOnTop.pop();
        }
    }

    
    public static void main(String[] args) throws FileNotFoundException {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        String fi = "Queue.txt";
        File file = new File(fi);
       
        Scanner scan = new Scanner(file);
        int n = scan.nextInt();
        
        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
