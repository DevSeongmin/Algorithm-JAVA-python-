package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16174_점프왕_쩰리_Large {

	static int[] dy = {1, 0};
	static int[] dx = {0, 1};
	static int N;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());

		int[][] board = new int[N][N];
		boolean[][] visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited[0][0] = true;
		dfs(0, 0, board, visited);

	}
	static void dfs(int y, int x, int[][] board, boolean[][] visited) {

		for (int i = 0; i < 2; i++) {
			int ny = y + dy[i] * board[y][x];
			int nx = x + dx[i] * board[y][x];

		if (!isIn(ny, nx)) continue;
		if (visited[ny][nx]) continue;


		}
	}

	static boolean isIn(int y, int x) {
		return 0 <= y && y < N && 0 <= x && x < N;
	}
}
