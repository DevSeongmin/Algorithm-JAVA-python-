package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ1613_역사 {

	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		int[][] graph = new int[N + 1][N + 1];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = 1;
		}

		for (int tmp = 1; tmp <= N; tmp++) {
			for (int s = 1; s <= N; s++) {
				for (int e = 1; e <= N; e++) {
					if (graph[s][e] == 1) continue;

					if (graph[s][tmp] == 1 && graph[tmp][e] == 1) {
						graph[s][e] = 1;
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		int i = Integer.parseInt(br.readLine());

		while(i-->0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (graph[a][b] == 1) {
				sb.append(-1);
			} else if (graph[b][a] == 1) {
				sb.append(1);
			} else {
				sb.append(0);
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
}
