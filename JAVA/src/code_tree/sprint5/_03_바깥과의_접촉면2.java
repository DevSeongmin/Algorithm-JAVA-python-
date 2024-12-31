package code_tree.sprint5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _03_바깥과의_접촉면2 {

	static int Y, X;
	static int[][] board;
	static boolean[][] visited;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		board = new int[Y][X];
		visited = new boolean[Y][X];

		for (int i = 0; i < Y; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < X; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int time = 0;
		while (true) {
			int cnt = calCnt();

			if (cnt == 0) {
				time = 0;
				break;
			}
			if (cnt >= 2) break;

			time++;
			melt();

		}

		System.out.println(time);
	}

	static void melt() {
		int[][] tmpBoard = new int[Y][X];

		for (int i = 0; i < Y; i++) {
			tmpBoard[i] = Arrays.copyOf(board[i], X);
		}

		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				if (board[i][j] == 0) continue;

				int zeroCnt = 0;
				for (int dir = 0; dir < 4; dir++) {
					int ny = i + dy[dir];
					int nx = j + dx[dir];

					if (!isIn(ny ,nx)) continue;

					if (board[ny][nx] == 0) zeroCnt++;
				}

				tmpBoard[i][j] = Math.max(board[i][j] - zeroCnt, 0);
			}
		}

		for (int i = 0; i < Y; i++) {
			board[i] = Arrays.copyOf(tmpBoard[i], X);
		}
	}

	static int calCnt() {

		int cnt = 0;

		visited = new boolean[Y][X];

		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {

				if (board[i][j] == 0) continue;
				if (visited[i][j]) continue;

				dfs(i, j);
				cnt++;
			}
		}
		return cnt;
	}


	static void dfs(int y, int x) {
		visited[y][x] = true;

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (!isIn(ny, nx)) continue;
			if (visited[ny][nx]) continue;
			if (board[ny][nx] == 0) continue;

			visited[ny][nx] = true;
			dfs(ny, nx);
		}
	}

	static boolean isIn(int y, int x) {
		return 0 <= y && y < Y && 0 <= x && x < X;
	}
}