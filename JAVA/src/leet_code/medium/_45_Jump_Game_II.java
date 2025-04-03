package leet_code.medium;

import java.util.Arrays;

public class _45_Jump_Game_II {
	class Solution {
		public int jump(int[] nums) {
			int l = nums.length;
			if (l == 1) return 0;

			int[] dp = new int[l];
			Arrays.fill(dp, Integer.MAX_VALUE);

			dp[0] = 0;

			for (int i = 0; i < l; i++) {
				if (dp[i] == Integer.MAX_VALUE) continue;

				for (int j = i+1; j <= i + nums[i]; j++) {
					dp[j] = Math.min(dp[j], dp[i]+1);
					if (j == l-1) return dp[j];
				}
			}

			return -1;
		}
	}
	
	// leetCode 최적화 풀이 솔루션
	public int jump(int[] nums) {
		int near = 0, far = 0, jumps = 0;

		while (far < nums.length - 1) {
			int farthest = 0;
			for (int i = near; i <= far; i++) {
				farthest = Math.max(farthest, i + nums[i]);
			}
			near = far + 1;
			far = farthest;
			jumps++;
		}

		return jumps;
	}


}
