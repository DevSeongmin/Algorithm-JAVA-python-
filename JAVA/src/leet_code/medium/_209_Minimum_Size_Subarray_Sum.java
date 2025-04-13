package leet_code.medium;

public class _209_Minimum_Size_Subarray_Sum {
	class Solution {
		public int minSubArrayLen(int target, int[] nums) {
			int answer = Integer.MAX_VALUE;

			int left = 0;
			int right = 0;
			int value = nums[0];

			while (right < nums.length) {

				if (value < target) {
					if (right == nums.length - 1) break;
					value += nums[++right];
				} else if (value >= target) {
					answer = Math.min(answer, right - left + 1);
					value -= nums[left++];
				}
			}

			return answer == Integer.MAX_VALUE ? 0 : answer;
		}
	}
}
