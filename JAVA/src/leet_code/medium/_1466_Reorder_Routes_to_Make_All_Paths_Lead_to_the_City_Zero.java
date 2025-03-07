package leet_code.medium;

import java.util.ArrayList;

public class _1466_Reorder_Routes_to_Make_All_Paths_Lead_to_the_City_Zero {
	class Solution {
		static boolean[] visited;
		static int cnt;
		static ArrayList<Integer>[] doubleGraph;

		public int minReorder(int n, int[][] connections) {

			doubleGraph = new ArrayList[n + 1];

			for (int i = 0; i < n + 1; i++) {
				doubleGraph[i] = new ArrayList<>();
			}

			for (int[] connection : connections) {
				int n1 = connection[0] + 1;
				int n2 = connection[1] + 1;

				doubleGraph[n1].add(n2);
				doubleGraph[n2].add(-n1);
			}

			cnt = 0;
			visited = new boolean[n + 1];
			dfs(1);

			return cnt;
		}
		static void dfs(int node) {
			visited[node] = true;

			for (int nNode : doubleGraph[node]) {

				if (nNode < 0) {
					nNode *= -1;
					if (visited[nNode]) continue;
					dfs(nNode);
				} else {
					if (visited[nNode]) continue;
					cnt++;
					dfs(nNode);
				}
			}
		}
	}
}
