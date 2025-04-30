package leet_code.medium;

import java.util.ArrayList;

import leet_code.common.ListNode;

public class _2130_Maximum_Twin_Sum_of_a_Linked_List {
	class Solution {
		public int pairSum(ListNode head) {
			ArrayList<Integer> arr = new ArrayList<>();

			while (head != null) {
				arr.add(head.val);
				head = head.next;
			}

			int answer = 0;
			for (int i = 0; i < arr.size() / 2; i++) {
				answer = Math.max(answer, arr.get(i) + arr.get(arr.size() - i - 1));
			}

			return answer;
		}
	}
}
