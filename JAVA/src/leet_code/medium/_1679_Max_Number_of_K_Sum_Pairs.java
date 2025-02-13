package leet_code.medium;

import java.util.Arrays;

public class _1679_Max_Number_of_K_Sum_Pairs {
	class Solution {
		public int maxOperations(int[] nums, int k) {
			Arrays.sort(nums);
			int left  = 0;
			int right = nums.length - 1;
			int answer = 0;
			while (left < right) {
				int sum = nums[left] + nums[right];
				if (sum == k) {
					answer++;
					left++;
					right--;
				} else if (sum > k) {
					right--;
				} else if (sum < k) {
					left++;
				}
			}

			return answer;
		}
	}
}
