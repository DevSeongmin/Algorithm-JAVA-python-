package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14925_목장건설하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		int[][] board = new int[y][x];

		for (int i = 0; i < y; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < x; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if (tmp == 0)
					board[i][j] = 1;
				else
					board[i][j] = -1;
			}
		}

		for (int i = 1; i < y; i++) {
			for (int j = 1; j < x; j++) {
				if (board[i][j] == -1)
					continue;

				board[i][j] = Math.max(
					Math.min(board[i - 1][j - 1], Math.min(board[i - 1][j], board[i][j - 1])) + 1,
					1);
			}
		}

		int answer = 0;

		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				answer = Math.max(answer, board[i][j]);
			}
		}

		System.out.println(answer);

	}
}
