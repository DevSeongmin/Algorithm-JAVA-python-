package leet_code.medium;

import leet_code.common.ListNode;

public class _2095_Delete_the_Middle_Node_of_a_Linked_List {
	class Solution {
		public ListNode deleteMiddle(ListNode head) {


			if (head.next == null) return null;

			ListNode node = head;

			int cnt = 0;
			while (node != null){
				node = node.next;
				cnt++;
			}

			int delIdx = cnt / 2;

			node = head;

			for (int i = 0; i < delIdx - 1; i++) {
				node = node.next;
			}

			node.next = node.next.next;
			return head;
		}
	}
}
