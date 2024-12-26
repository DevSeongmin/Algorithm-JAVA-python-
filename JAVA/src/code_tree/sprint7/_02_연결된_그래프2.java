package code_tree.sprint7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _02_연결된_그래프2 {

	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		graph = new ArrayList[V+1];

		for (int i = 1; i <= V; i++) {
			graph[i] = new ArrayList();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			graph[s].add(e);
		}

		int[] cnts = new int[V+1];
		int maxValue = -1;

		for (int v = 1; v <= V; v++) {

			visited = new boolean[V+1];
			cnt = 0;
			dfs(v);
			cnts[v] = cnt;
			maxValue = Math.max(maxValue, cnt);
		}

		for (int i = 1; i <= V;i ++) {
			if (cnts[i] == maxValue) System.out.print(i + " ");
		}
	}

	static void dfs(int v){
		cnt++;
		visited[v] = true;

		for (int nextV : graph[v]) {
			if (visited[nextV]) continue;

			dfs(nextV);
		}
	}
}