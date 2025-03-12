package leet_code.medium;

public class _1143_Longest_Common_Subsequence {
	class Solution {
		public int longestCommonSubsequence(String text1, String text2) {
			int l1 = text1.length();
			int l2 = text2.length();

			int[][] dp = new int[l1+1][l2+1];

			for (int i =  1; i <= l1; i++) {
				for (int j = 1; j <= l2; j++) {
					char c1 = text1.charAt(i-1);
					char c2 = text2.charAt(j-1);

					if (c1 == c2) {
						dp[i][j] = dp[i-1][j-1] + 1;
					} else {
						dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
					}
				}
			}

			return dp[l1][l2];
		}
	}
}
