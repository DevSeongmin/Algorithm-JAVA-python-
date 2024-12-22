package code_tree.sprint8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _04_달리기_훈련 {

	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		int[] ROUTES = new int[R + 1];
		ROUTES[0] = 1;

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= R; i++) {
			ROUTES[i] = Integer.parseInt(st.nextToken());
		}

		int[][] DP = new int[N+1][N+1];

		for (int i = 0; i < N+1; i++) {
			Arrays.fill(DP[i], INF);
			DP[i][i] = 0;
		}

		for (int i = 0; i < E; i++ ){
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			DP[s][e] = DP[e][s] = w;
		}

		for (int t = 1; t <= N; t++) {
			for (int s = 1; s <= N; s++) {
				for (int e = 1; e <= N; e++) {
					if (DP[s][t] == INF || DP[t][e] == INF) continue;

					DP[s][e] = Math.min(DP[s][e], DP[s][t] + DP[t][e]);
				}
			}
		}

		int answer = 0;

		for (int i = 0; i < R; i++) {
			answer += DP[ROUTES[i]][ROUTES[i+1]];
		}

		System.out.println(answer);
	}
}