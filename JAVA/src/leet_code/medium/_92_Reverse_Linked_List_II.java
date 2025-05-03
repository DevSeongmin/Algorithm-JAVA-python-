package leet_code.medium;

import java.util.ArrayList;

import leet_code.common.ListNode;

public class _92_Reverse_Linked_List_II {
	class Solution {

		public ListNode reverseBetween(ListNode head, int left, int right) {
			left -= 1;
			right -= 1;

			ArrayList<ListNode> arr = new ArrayList<>();

			while (head != null) {
				arr.add(head);
				head = head.next;
			}

			while (left < right) {
				swap(arr, left, right);
				left++;
				right--;
			}

			head = arr.get(0);
			ListNode node = head;

			for (int i = 1; i < arr.size(); i++) {
				node.next = arr.get(i);
				node = node.next;
			}
			node.next = null;

			return head;
		}

		static void swap(ArrayList<ListNode> arr, int left, int right) {
			ListNode tmp = arr.get(left);
			arr.set(left, arr.get(right));
			arr.set(right, tmp);
		}
	}
}
