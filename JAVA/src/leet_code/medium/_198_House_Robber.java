package leet_code.medium;

public class _198_House_Robber {
	class Solution {
		public int rob(int[] nums) {
			int l = nums.length;

			if (l == 1) {
				return nums[0];
			}

			for (int i = 0; i < l; i++) {
				int prepre = 0;
				int preprepre = 0;

				if (i - 2 >= 0) {
					prepre = nums[i-2];
				}

				if (i-3 >= 0) {
					preprepre = nums[i-3];
				}

				nums[i] += Math.max(prepre, preprepre);
			}

			return Math.max(nums[l-1], nums[l-2]);
		}
	}
}
