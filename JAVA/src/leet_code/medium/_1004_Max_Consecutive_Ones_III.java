package leet_code.medium;

public class _1004_Max_Consecutive_Ones_III {
	class Solution {
		public int longestOnes(int[] nums, int k) {
			int left = 0;
			int right = 0;
			int zeroCnt = 0;
			int answer = 0;

			while (true) {
				if (nums[right] == 1) {
					right++;
				} else {
					if (zeroCnt < k) {
						right++;
						zeroCnt++;
					} else {
						right++;
						while (left <= right && nums[left] == 1) {
							left++;
						}
						left++;
					}
				}
				answer = Math.max(answer, right - left);
				if (right == nums.length) break;
			}
			return answer;
		}
	}

}
