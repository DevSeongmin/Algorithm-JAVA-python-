package leet_code.medium;

import leet_code.common.ListNode;

public class _148_Sort_List {
	class Solution {
		public ListNode sortList(ListNode head) {
			if (head == null || head.next == null) return head;

			ListNode prev = null;
			ListNode slow = head;
			ListNode fast = head;

			while (fast != null && fast.next != null) {
				prev = slow;
				slow = slow.next;
				fast = fast.next.next;
			}

			prev.next = null;

			ListNode left = sortList(head);
			ListNode right = sortList(slow);

			return merge(left, right);
		}

		ListNode merge(ListNode left, ListNode right) {
			ListNode dummy = new ListNode();
			ListNode node = dummy;

			while (left != null && right != null) {
				if (left.val < right.val) {
					node.next = left;
					left = left.next;
				} else {
					node.next = right;
					right = right.next;
				}

				node = node.next;
			}

			if (left == null) {
				node.next = right;
			}

			if (right == null) {
				node.next = left;
			}

			return dummy.next;
		}
	}
}
