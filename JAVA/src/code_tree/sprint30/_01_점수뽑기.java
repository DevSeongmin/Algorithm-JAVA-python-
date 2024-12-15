package code_tree.sprint30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _01_점수뽑기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] scores = new int[4][N];

		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N ; j++) {
				scores[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		HashMap<Integer, Integer> map = new HashMap();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int sum  = scores[0][i] + scores[1][j];
				map.put(sum, map.getOrDefault(sum, 0) + 1);
			}
		}

		int answer = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int sum  = scores[2][i] + scores[3][j];
				answer += map.getOrDefault(K- sum, 0);
			}
		}

		System.out.println(answer);
	}
}
