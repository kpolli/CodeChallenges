package com.code.challenges.leetcode;

import java.util.ArrayList;
import java.util.List;

public class RotateRight {

	public static class ListNode {
		public int val;
		public ListNode next;

		public ListNode() {
		}

		public ListNode(int val) {
			this.val = val;
		}

		public ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static ListNode rotateRight(ListNode head, int k) {
		return rotateRight(head, new ArrayList<>(), k, 0);
		
	}
	
	private static ListNode rotateRight(ListNode head, List<ListNode> nodes, int k, int count) {
		if (head == null) {	
			return null;
		}
		nodes.add(head);
		//int num = nodes.size();
		ListNode next = rotateRight(head.next, nodes, k, count + 1);
		int num = nodes.size();
		int mode = k % num;
		int index =  count - mode;
		if (index < 0) {
			index = nodes.size() + index;
		}
		ListNode resp = nodes.get(index);
		resp.next = next;
		return resp;
	}
	
	public static void main(String[] args) {
		
		ListNode leaf2 = new ListNode(2);
		ListNode leaf1 = new ListNode(1, leaf2);
		ListNode head = new ListNode(0, leaf1);
		ListNode ans = rotateRight(head, 4);
		System.out.println(ans.val);
	}
}
