package code_tree.sprint5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _02_빙글빙글_회전판 {

	static int Y, X, Q;
	static int[][] board;
	static int[] dy = {0, 1, 0, -1};
	static int[] dx = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		board = new int[Y][X];

		for (int i = 0 ; i < Y; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0 ; j < X; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int q = 0; q < Q; q++) {
			st = new StringTokenizer(br.readLine());

			int y1 = Integer.parseInt(st.nextToken()) - 1;
			int x1 = Integer.parseInt(st.nextToken()) - 1;
			int y2 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());

			spin(y1, x1, y2, x2);

			setAverage(y1, x1, y2, x2);

		}

		for (int i = 0 ; i < Y; i++) {
			for (int j = 0 ; j < X; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void spin(int y1, int x1, int y2, int x2) {

		int cy = y1;
		int cx = x1;

		int initValue = board[y1][x1];
		int dir = 0;

		while (true) {

			int ny = cy + dy[dir];
			int nx = cx + dx[dir];

			if (
				!(y1 <= ny && ny < y2
					&& x1 <= nx && nx < x2)
			) {
				dir++;
				if (dir >= 4) break;

				ny = cy + dy[dir];
				nx = cx + dx[dir];
			}

			board[cy][cx] = board[ny][nx];
			cy = ny;
			cx = nx;
		}


		board[y1+1][x1] = initValue;
	}

	static void setAverage(int y1, int x1, int y2, int x2){
		int[][] tmpBoard = new int[Y][X];

		for (int i = 0; i < Y; i++) {
			tmpBoard[i] = Arrays.copyOf(board[i], X);
		}

		for (int y = y1; y < y2; y++) {
			for (int x = x1; x < x2; x++) {

				int value = board[y][x];
				int cnt = 1;

				for (int i = 0; i < 4; i++) {
					int ny = y + dy[i];
					int nx = x + dx[i];

					if (!isIn(ny, nx)) continue;

					value += board[ny][nx];
					cnt++;
				}

				if (value % cnt == 0) {
					value = value/cnt;
				} else {
					value = value/cnt + 1;
				}

				tmpBoard[y][x] = value;
			}
		}



		board = tmpBoard;
	}

	static boolean isIn(int y, int x) {
		return 0 <= y && y < Y && 0 <= x && x < X;
	}
}