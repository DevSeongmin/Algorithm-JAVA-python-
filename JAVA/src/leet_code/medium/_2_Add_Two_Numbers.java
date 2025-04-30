package leet_code.medium;

import leet_code.common.ListNode;

public class _2_Add_Two_Numbers {
	class Solution {
		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			ListNode node = new ListNode();
			ListNode answer = node;

			int carry = 0;
			while (l1 != null || l2 != null) {
				int val = carry;

				if (l1 != null) {
					val += l1.val;
					l1 = l1.next;
				}

				if (l2 != null) {
					val += l2.val;
					l2 = l2.next;
				}

				carry = val / 10;
				val %= 10;

				node.next = new ListNode(val);
				node = node.next;
			}

			if (carry != 0) {
				node.next = new ListNode(carry);
			}

			return answer.next;
		}
	}
}
