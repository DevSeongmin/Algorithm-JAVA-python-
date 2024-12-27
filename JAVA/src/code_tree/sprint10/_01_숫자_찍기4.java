package code_tree.sprint10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _01_숫자_찍기4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] board = new int[N][N];
		int dir = 0;
		int[] dy = {0, 1, 0, -1};
		int[] dx = {1, 0, -1, 0};
		int curX = 0;
		int curY = 0;

		for (int i = 1; i <= N*N; i++) {
			board[curY][curX] = i;

			int ny = curY + dy[dir];
			int nx = curX + dx[dir];

			if (!(0 <= ny && ny < N && 0 <= nx && nx < N)
				|| board[ny][nx] != 0) {
				dir = (dir+1) % 4;
			}

			curY += dy[dir];
			curX += dx[dir];
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
}