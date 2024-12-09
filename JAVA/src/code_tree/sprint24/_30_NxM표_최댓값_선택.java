package code_tree.sprint24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _30_NxM표_최댓값_선택 {
	static int Y, X;
	static ArrayList<Integer> picks;
	static int[][] BOARD;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		BOARD = new int[Y][X];

		for (int i = 0; i < Y; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < X;j ++) {
				BOARD[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		picks = new ArrayList();
		combi(0, 0);
		System.out.println(answer);

	}
	static void combi(int idx, int depth) {

		if (depth == 3) {
			int sum = 0;
			for (int i = 0; i < Y; i++) {
				int maxVal = 0;
				for (int j = 0; j < X; j++) {
					if (picks.contains(j)) continue;
					maxVal = Math.max(maxVal, BOARD[i][j]);
				}
				sum += maxVal;
			}
			answer = Math.max(answer, sum);

			return;
		}

		for (int i = idx; i < X; i++) {
			picks.add(i);
			combi(i+1, depth + 1);
			picks.remove(picks.size() - 1);
		}
	}
}