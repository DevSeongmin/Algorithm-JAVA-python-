package leet_code.medium;

import leet_code.common.ListNode;

public class _61_Rotate_List {
	class Solution {
		public ListNode rotateRight(ListNode head, int k) {

			int size = 0;
			ListNode node = head;

			while (node != null) {
				size++;
				node = node.next;
			}

			if (size <= 1 || k % size == 0) return head;

			k %= size;

			node = head;
			for (int i = 0; i < size - k - 1; i++) {
				node = node.next;
			}

			ListNode newHead = node.next;
			node.next = null;

			node = newHead;
			while (node.next != null) {
				node = node.next;
			}

			node.next = head;

			return newHead;
		}
	}
}
