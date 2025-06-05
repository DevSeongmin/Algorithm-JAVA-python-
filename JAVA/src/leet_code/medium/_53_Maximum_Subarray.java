package leet_code.medium;

public class _53_Maximum_Subarray {
	class Solution {
		public int maxSubArray(int[] nums) {
			int answer = nums[0];
			int num = nums[0];

			for (int i = 1; i < nums.length; i++) {
				int n = nums[i];

				num = Math.max(n, num + n);
				answer = Math.max(num, answer);
			}

			return answer;
		}
	}
}
