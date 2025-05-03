package leet_code.medium;

import leet_code.common.ListNode;

public class _86_Partition_List {
	class Solution {
		public ListNode partition(ListNode head, int x) {
			ListNode less = new ListNode(-1);
			ListNode lessDummy = less;

			ListNode greater = new ListNode(-1);
			ListNode greaterDummy = greater;

			while (head != null) {
				if (head.val < x){
					lessDummy.next = head;
					lessDummy = lessDummy.next;
				} else {
					greaterDummy.next = head;
					greaterDummy = greaterDummy.next;
				}
				head = head.next;
			}

			lessDummy.next = greater.next;
			greaterDummy.next = null;

			return less.next;
		}
	}
}
