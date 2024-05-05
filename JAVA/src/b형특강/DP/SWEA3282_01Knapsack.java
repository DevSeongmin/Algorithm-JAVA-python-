package b형특강.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA3282_01Knapsack {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int MAX_WEIGHT = Integer.parseInt(st.nextToken());

			Thing[] things = new Thing[N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				things[i] = new Thing(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			int[] DP = new int[MAX_WEIGHT + 1];

			for (int i = 0; i < N; i++) {
				for (int j = MAX_WEIGHT; j >= things[i].weight; j--) {
					DP[j] = Math.max(DP[j], DP[j - things[i].weight] + things[i].value);
				}
			}

			sb.append("#").append(tc).append(" ").append(DP[MAX_WEIGHT]).append("\n");
		}

		System.out.println(sb);

	}

	static class Thing {
		int weight;
		int value;

		public Thing(int weight, int value) {
			this.weight = weight;
			this.value = value;
		}
	}
}
