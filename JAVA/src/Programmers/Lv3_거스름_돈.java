package Programmers;

public class Lv3_거스름_돈 {
	class Solution {
		public int solution(int n, int[] money) {
			int[] dp = new int[n + 1];
			dp[0] = 1;

			for (int coin : money) {
				for (int amount = coin; amount <= n; amount++) {
					dp[amount] = (dp[amount] + dp[amount - coin]) % 1000000007;
				}
			}

			return dp[n];
		}
	}
}
