package leet_code.medium;

public class _547_Number_of_Provinces {
	class Solution {
		static boolean[] visited;
		static int[][] graph;
		public int findCircleNum(int[][] isConnected) {
			graph = isConnected;
			visited = new boolean[isConnected.length];

			int cnt = 0;

			for (int i = 0; i < isConnected.length; i++) {
				if (visited[i]) continue;
				cnt++;
				dfs(i);
			}
			return cnt;
		}

		static void dfs(int node) {
			visited[node] = true;

			for (int i = 0; i < graph[node].length; i++) {
				if (graph[node][i] == 0) continue;
				if (visited[i]) continue;
				dfs(i);
			}
		}
	}
}
