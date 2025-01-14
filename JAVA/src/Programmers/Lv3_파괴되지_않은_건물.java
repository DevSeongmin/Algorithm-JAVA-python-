package Programmers;

public class Lv3_파괴되지_않은_건물 {
	class Solution {

		public int solution(int[][] board, int[][] skill) {

			int Y = board.length;
			int X = board[0].length;

			int[][] dp = new int[Y+1][X+1];

			int answer = 0;

			for (int[] s : skill) {
				int y1 = s[1];
				int x1 = s[2];
				int y2 = s[3];
				int x2 = s[4];
				int deltha = s[5] * (s[0] == 1 ? -1 : 1);


				dp[y1][x1] += deltha;
				dp[y2 + 1][x2 + 1] += deltha;
				dp[y1][x2 + 1] -= deltha;
				dp[y2 + 1][x1] -= deltha;
			}

			for (int i = 0; i < Y; i++) {
				for (int j = 0; j < X; j++) {

					if (i-1 >= 0) {
						dp[i][j] += dp[i-1][j];
					}

					if (j-1 >= 0) {
						dp[i][j] += dp[i][j-1];
					}

					if (i-1 >= 0 && j-1 >= 0) {
						dp[i][j] -= dp[i-1][j-1];
					}
				}
			}

			for (int i = 0; i < Y; i++) {
				for (int j = 0; j < X; j++) {
					if (dp[i][j] + board[i][j] > 0) answer++;
				}
			}
			return answer;
		}
	}
}
