package hsat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lv2_진정한_효도 {
	public class Main {

		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			int[][] board = new int[3][3];

			for (int i = 0; i < 3; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 3; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int answer = Integer.MAX_VALUE;

			for (int i = 0; i < 3; i++) {

				for (int target = 1; target<= 3; target++) {
					int value1 = 0;
					int value2 = 0;
					for (int j = 0; j < 3; j++) {
						value1 += Math.abs(target - board[i][j]);
						value2 += Math.abs(target - board[j][i]);
					}
					answer = Math.min(answer, value1);
					answer = Math.min(answer, value2);
				}
			}
			System.out.println(answer);
		}
	}
}
