package leet_code.esay;

public class _206_Reverse_Linked_List {

	public class ListNode {
	  int val;
	  ListNode next;
	  ListNode() {}
	  ListNode(int val) { this.val = val; }
	  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	class Solution {
		static ListNode myNode;
		static ListNode myHead;
		public ListNode reverseList(ListNode head) {

			myNode = null;
			myHead = null;

			recursion(head);

			if (myNode != null) {
				myNode.next = null;
			}

			return myHead;
		}

		static void recursion(ListNode node) {

			if (node == null) return;

			if (node.next != null) {
				recursion(node.next);
			}

			if (myNode == null) {
				myNode = node;
				myHead = node;
			} else {
				myNode.next = node;
				myNode = node;
			}
		}
	}
}
