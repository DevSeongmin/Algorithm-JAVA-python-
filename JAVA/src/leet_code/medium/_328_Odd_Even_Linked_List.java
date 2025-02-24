package leet_code.medium;

public class _328_Odd_Even_Linked_List {
	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	class Solution {
		public ListNode oddEvenList(ListNode head) {
			if (head == null || head.next == null) return head;

			ListNode oddHead = new ListNode(head.val);
			ListNode oddNode = oddHead;

			ListNode evenHead = new ListNode(head.next.val);
			ListNode evenNode = evenHead;

			ListNode node = head.next.next;

			int cnt = 0;

			while (node != null) {
				cnt++;
				if (cnt % 2 == 1) {
					oddNode.next = node;
					oddNode = node;
				} else {
					evenNode.next = node;
					evenNode = node;
				}
				node = node.next;
			}

			evenNode.next = null;
			oddNode.next = evenHead;

			return oddHead;
		}
	}
}
