package leet_code.medium;

class Solution {

	// 내 풀이
	public int maxProfit(int[] prices) {
		int l = prices.length;

		int[][] dp = new int[2][l];

		dp[0][0] = -prices[0];

		for (int i = 1; i < l; i++) {
			dp[0][i] = Math.max(dp[0][i-1], dp[1][i-1] - prices[i]);
			dp[1][i] = Math.max(dp[1][i-1], dp[0][i-1] + prices[i]);
		}

		return dp[1][l-1];
	}

	// DP의 이전값만 참고하므로 변수로 처리하여 메모리 최적화한 풀이
	public int maxProfit2(int[] prices) {

		int hold = -Integer.MAX_VALUE;
		int notHold = 0;

		for( int stockPrice : prices ){
			int prevHold = hold, prevNotHold = notHold;
			hold = Math.max(prevHold, prevNotHold - stockPrice);
			notHold = Math.max(prevNotHold, prevHold + stockPrice);

		}

		return notHold;
	}

	// 수수료가 없다는 것을 이용한 직관적인(그리디한) 풀이(천재 인도인 풀이)
	public int maxProfit3(int[] prices) {
		int profit = 0;

		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1]) {
				profit += prices[i] - prices[i - 1];
			}
		}

		return profit;
	}
}