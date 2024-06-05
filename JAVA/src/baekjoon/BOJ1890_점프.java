package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1890_점프 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[][] board = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		long[][] DP = new long[N][N];
		DP[0][0] = 1;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				if (DP[i][j] == 0 || board[i][j] == 0)
					continue;

				int nextI = i + board[i][j];
				int nextJ = j + board[i][j];

				if (nextI < N) {
					DP[nextI][j] += DP[i][j];
				}

				if (nextJ < N) {
					DP[i][nextJ] += DP[i][j];
				}

			}
		}

		System.out.println(DP[N - 1][N - 1]);

	}
}
