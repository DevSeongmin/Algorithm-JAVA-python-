package leet_code.medium;

public class _790_Domino_and_Tromino_Tiling {
	class Solution {
		static final int MOD = 1000000007;

		public int numTilings(int n) {
			if (n == 1) return 1;
			if (n == 2) return 2;
			if (n == 3) return 5;

			int[] dp = new int[n];
			dp[0] = 1;
			dp[1] = 2;
			dp[2] = 5;

			for (int i = 3; i < n; i++) {
				dp[i] = ((dp[i-1] * 2) % MOD + dp[i-3]) % MOD;
			}

			return dp[n-1];
		}
	}
}
