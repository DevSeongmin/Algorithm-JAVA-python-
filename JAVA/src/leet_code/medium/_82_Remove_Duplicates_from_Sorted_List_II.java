package leet_code.medium;

import leet_code.common.ListNode;

public class _82_Remove_Duplicates_from_Sorted_List_II {

	class Solution {
		public ListNode deleteDuplicates(ListNode head) {
			ListNode res = new ListNode(-1, null);
			ListNode dummy = res;

			while (head != null) {

				if (head.next == null || (head.val != head.next.val)) {
					dummy.next = head;
					dummy = dummy.next;
					head = head.next;
					continue;
				}

				while (head.next != null && head.val == head.next.val) {
					head = head.next;
				}
				head = head.next;
			}

			dummy.next = null;

			return res.next;
		}
	}
}
