package baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1956_운동 {
	public static void main(String[] args) throws IOException {

		int INF = 10_000 * 401;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		int[][] graph = new int[N+1][N+1];
		for (int i = 0; i <= N; i++) {
			Arrays.fill(graph[i], INF);
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph[a][b] = w;
		}


		for (int t = 1; t <= N; t++) {
			for (int s = 1; s <= N; s++) {
				for (int e = 1; e <= N; e++) {
					graph[s][e] = Math.min(graph[s][e], graph[s][t] + graph[t][e]);
				}
			}
		}

		int answer = INF;

		for (int i = 1; i <= N; i++) {
			answer = Math.min(answer, graph[i][i]);
		}

		System.out.println(answer == INF ? -1 : answer);
	}
}
