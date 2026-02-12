package com.code.challenges.leetcode;

import java.util.Deque;
import java.util.LinkedList;

import com.code.challenges.leetcode.MergeLinkedLists.ListNode;

public class ReverseKGroupLinkedList {

	public static ListNode reverseKGroup(ListNode head, int k) {
		
		ListNode l = reverseKGroup(head, new ListNode(), k, new LinkedList<>());
		return l.next;
	}
	
	public static ListNode reverseKGroup(ListNode head, ListNode node, int k, Deque<ListNode> st) {
		boolean reversed = false;
		// reverse the order
		if (st.size() == k) {
			while(!st.isEmpty()) {
				ListNode temp = st.pollLast();
				temp.next = null;
				node.next = temp;
				node = node.next;
			}
			
			reversed = true;
		}
		// reached the end so return;
		if (head == null) {
			// check if st is full and add rest to 
			if (!reversed) {
				node.next = st.pollFirst();
			}
			return node.next;
		}
		
		st.add(head);
		reverseKGroup(head.next, node, k, st);
		return node;
	}
	
	public static void main(String[] args) {
		ListNode leaf5 = new ListNode(5);
		ListNode leaf4 = new ListNode(4, leaf5);
		ListNode leaf3 = new ListNode(3, leaf4);
		ListNode leaf2 = new ListNode(2, leaf3);
		ListNode leaf1 = new ListNode(1, leaf2);
		ListNode ans = reverseKGroup(leaf1, 5);
		System.out.println(ans.val);
	}
}
