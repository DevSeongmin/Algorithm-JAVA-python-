package leet_code.medium;

public class _714_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee {
	class Solution {
		public int maxProfit(int[] prices, int fee) {
			int l = prices.length;
			int[][] dp = new int[2][l];

			dp[1][0] = 0;
			dp[0][0] = -prices[0] - fee;

			for (int i = 1; i < l; i++) {
				dp[0][i] = Math.max(dp[0][i-1], dp[1][i-1] - prices[i] - fee);
				dp[1][i] = Math.max(dp[1][i-1], dp[0][i-1] + prices[i]);
			}

			return dp[1][l-1];
		}
	}
}
