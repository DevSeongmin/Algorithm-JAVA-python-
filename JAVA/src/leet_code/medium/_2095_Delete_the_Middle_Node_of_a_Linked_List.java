package leet_code.medium;

public class _2095_Delete_the_Middle_Node_of_a_Linked_List {
	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
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
