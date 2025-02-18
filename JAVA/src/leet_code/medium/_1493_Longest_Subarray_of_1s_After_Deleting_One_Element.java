package leet_code.medium;

import java.util.ArrayList;

public class _1493_Longest_Subarray_of_1s_After_Deleting_One_Element {
	class Solution {
		public int longestSubarray(int[] nums) {
			ArrayList<Integer> arr = new ArrayList();

			arr.add(0);
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] == 0) arr.add(i+1);
			}
			arr.add(nums.length + 1);

			int answer = 0;

			if (arr.size() == 2) {
				return nums.length - 1;
			}

			for (int i = 2; i < arr.size(); i++) {
				answer = Math.max(answer, arr.get(i) - arr.get(i-2) - 2);
			}

			return answer;
		}
	}
}
