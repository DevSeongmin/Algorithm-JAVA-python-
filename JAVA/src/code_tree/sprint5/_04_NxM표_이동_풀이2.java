package code_tree.sprint5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _04_NxM표_이동_풀이2 {
	static final int MOD = 1000000007;
	static int Y, X;
	static int[][] board;
	static int[][] dp;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};

	static int findPaths(int y, int x) {
		if (y == Y-1 && x == X-1) return 1;

		if (dp[y][x] != -1) return dp[y][x];

		dp[y][x] = 0;

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (!isIn(ny, nx)) continue;
			if (board[y][x] <= board[ny][nx]) continue;

			dp[y][x] = (dp[y][x] + findPaths(ny, nx)) % MOD;
		}

		return dp[y][x];
	}

	static boolean isIn(int y, int x) {
		return 0 <= y && y < Y && 0 <= x && x < X;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		board = new int[Y][X];
		dp = new int[Y][X];

		for (int i = 0; i < Y; i++) {
			Arrays.fill(dp[i], -1);
		}

		for (int i = 0; i < Y; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < X; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(findPaths(0, 0));
	}
}