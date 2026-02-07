package com.code.challenges.leetcode;

import java.util.PriorityQueue;

public class MergeLinkedLists {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	private static ListNode mergeKLists(ListNode[] lists) {
		PriorityQueue<ListNode> queue = new PriorityQueue<>((n1, n2) -> {
				return Integer.compare(n1.val, n2.val);
		});
		for (int i = 0; i < lists.length; i++) {
			ListNode node = lists[i];
			if (node != null) {
				queue.add(node);
			}
		}
		ListNode n = new ListNode();
		n = queue.poll();
		ListNode response = n;
		while (!queue.isEmpty()) {
			n.next = queue.poll();
			n = n.next;
			if (response.next != null) {
                queue.add(response.next);
            }
		}
		return response;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(-1);
		ListNode n2 = new ListNode(-1, n1);
		ListNode n3 = new ListNode(-1, n2);
		ListNode n4 = new ListNode(-2, n3);
		ListNode[] node = new ListNode[2];
		node[0] = n4;
		System.out.println(mergeKLists(node).val);
	}
}
