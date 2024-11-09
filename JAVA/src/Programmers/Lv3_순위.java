package Programmers;

import java.util.ArrayList;

public class Lv3_순위 {

	class Solution {
		static boolean[] visited;
		static int cnt;

		public int solution(int n, int[][] results) {

			ArrayList<Integer>[] graph = new ArrayList[n + 1];
			ArrayList<Integer>[] rGraph = new ArrayList[n + 1];

			for (int i = 0; i < n + 1; i++) {
				graph[i] = new ArrayList();
				rGraph[i] = new ArrayList();
			}

			for (int[] result : results) {
				int s = result[0];
				int e = result[1];

				graph[s].add(e);
				rGraph[e].add(s);
			}

			int answer = 0;

			for (int i = 1; i <= n; i++) {
				cnt = 0;

				visited = new boolean[n + 1];
				dfs(graph, i);
				dfs(rGraph, i);

				if (cnt == n + 1)
					answer++;
			}
			return answer;
		}

		public static void dfs(ArrayList<Integer>[] graph, int node) {
			cnt++;
			visited[node] = true;

			for (int next : graph[node]) {
				if (!visited[next]) {
					dfs(graph, next);
				}
			}
		}
	}
}
