package Programmers;

public class Lv3_최적의_행렬_곱셈 {
	class Solution {

		static int[][] matrix, dp;
		static int N;

		public int solution(int[][] matrix) {
			this.matrix = matrix;
			this.N = matrix.length;
			this.dp = new int[N][N];


			return solve(0, N-1);
		}

		static int solve(int start, int end) {
			if (start == end) return 0;
			if (dp[start][end] != 0) return dp[start][end];

			dp[start][end] = Integer.MAX_VALUE;


			for (int i = start; i < end; i++) {
				int cost = solve(start, i) + solve(i+1, end)
					+ matrix[start][0] * matrix[i][1] * matrix[end][1];

				dp[start][end] = Math.min(dp[start][end], cost);
			}

			return dp[start][end];
		}
	}
}
