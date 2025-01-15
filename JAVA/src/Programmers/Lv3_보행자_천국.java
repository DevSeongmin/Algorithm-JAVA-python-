package Programmers;

public class Lv3_보행자_천국 {
	class Solution {
		int MOD = 20170805;
		public int solution(int Y, int X, int[][] cityMap) {
			int answer = 0;

			int[][] goRightDP = new int[Y][X];
			int[][] goDownDP = new int[Y][X];

			goRightDP[0][0] = 1;
			goDownDP[0][0] = 1;

			for (int j = 1; j < X; j++) {
				if (cityMap[0][j] == 1) break;
				goRightDP[0][j] = 1;
			}

			for (int i = 1; i < Y; i++) {
				if (cityMap[i][0] == 1) break;
				goDownDP[i][0] = 1;
			}


			for (int i = 1; i < Y; i++) {
				for (int j = 1; j < X; j++) {

					if (cityMap[i][j] == 1) continue;

					if (cityMap[i-1][j] == 2) {
						goDownDP[i][j] = (goDownDP[i][j] + goDownDP[i-1][j]) % MOD;
					} else {
						goDownDP[i][j] = (goDownDP[i][j] + goDownDP[i-1][j]) % MOD;
						goDownDP[i][j] = (goDownDP[i][j] + goRightDP[i-1][j]) % MOD;
					}



					if (cityMap[i][j-1] == 2) {
						goRightDP[i][j] = (goRightDP[i][j] + goRightDP[i][j-1]) % MOD;
					} else {
						goRightDP[i][j] = (goRightDP[i][j] + goRightDP[i][j-1]) % MOD;
						goRightDP[i][j] = (goRightDP[i][j] + goDownDP[i][j-1]) % MOD;
					}
				}
			}


			return (goRightDP[Y-1][X-1] + goDownDP[Y-1][X-1]) % MOD;
		}
	}
}
