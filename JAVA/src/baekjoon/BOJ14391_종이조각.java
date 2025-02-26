package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ14391_종이조각 {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int Y = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		int[][] board = new int[Y][X];

		for (int i = 0; i < Y; i++) {
			String input = br.readLine();
			for (int j = 0; j < X; j++) {
				board[i][j] = input.charAt(j) - '0';
			}
		}

		int answer= 0;
		for (int bit = 0; bit < 1 << (Y * X); bit++) {

			int sum = 0;


			// 가로 카운팅
			for (int i = 0; i < Y; i++) {
				int num = 0;
				for (int j = 0; j < X; j++) {
					if ((bit & (1 << (i * X + j))) > 0) {
						num = (num * 10) + board[i][j];
					} else {
						sum += num;
						num =0;
					}
				}
				sum += num;
			}

			// 세로 카운팅
			for (int i = 0; i < X; i++) {
				int num = 0;
				for (int j = 0; j < Y; j++) {
					if ((bit & (1 << (j * X) + i)) == 0) {
						num = (num * 10) + board[j][i];
					} else {
						sum += num;
						num = 0;
					}
				}
				sum += num;
			}

			answer = Math.max(answer, sum);
		}
		System.out.println(answer);
	}
}
