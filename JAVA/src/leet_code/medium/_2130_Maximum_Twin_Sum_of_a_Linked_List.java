package leet_code.medium;

import java.util.ArrayList;

public class _2130_Maximum_Twin_Sum_of_a_Linked_List {
	 public class ListNode {
		 int val;
		 ListNode next;
		 ListNode() {}
		 ListNode(int val) { this.val = val; }
		 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 }

	class Solution {
		public int pairSum(ListNode head) {
			ArrayList<Integer> arr = new ArrayList<>();

			while (head != null) {
				arr.add(head.val);
				head = head.next;
			}

			System.out.println(arr);

			int answer = 0;
			for (int i = 0; i < arr.size() / 2; i++) {
				answer = Math.max(answer, arr.get(i) + arr.get(arr.size() - i - 1));
			}

			return answer;
		}
	}
}
