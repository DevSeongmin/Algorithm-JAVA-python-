package Programmers;

import java.util.Arrays;

public class Lv3_합승_택시_요금 {
	class Solution {

		static final int INF = Integer.MAX_VALUE;

		public int solution(int n, int s, int a, int b, int[][] fares) {
			int[][] graph = new int[n+1][n+1];

			for (int i = 1; i <= n; i++) {
				Arrays.fill(graph[i], INF);
				graph[i][i] = 0;
			}

			for (int[] fare : fares) {
				int n1 = fare[0];
				int n2 = fare[1];
				int w = fare[2];

				graph[n1][n2] = w;
				graph[n2][n1] = w;
			}

			for (int k = 1; k <= n; k++) {
				for (int start = 1; start <= n; start++) {
					for (int end = 1; end <= n; end++) {
						if (graph[start][k] == INF || graph[k][end] == INF) continue;

						graph[start][end] = Math.min(graph[start][end], graph[start][k] + graph[k][end]);
					}
				}
			}

			int answer = INF;

			for (int i = 1; i <= n; i++) {
				answer = Math.min(answer, graph[s][i] + graph[i][a] + graph[i][b]);
			}

			return answer;
		}
	}

}
