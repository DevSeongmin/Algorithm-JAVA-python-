package hsat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Lv3_출퇴근길 {

	public class Main {

		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			ArrayList<Integer>[] graph = new ArrayList[N+1];
			ArrayList<Integer>[] graphR = new ArrayList[N+1];

			for (int i =1; i <= N; i++) {
				graph[i] = new ArrayList();
				graphR[i] = new ArrayList();

			}

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());

				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				graph[s].add(e);
				graphR[e].add(s);

			}

			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			boolean[] fromStartVisited = new boolean[N+1];
			fromStartVisited[end] = true;
			dfs(graph, start, fromStartVisited);

			boolean[] fromEndVisited = new boolean[N+1];
			fromEndVisited[start] = true;
			dfs(graph, end, fromEndVisited);

			boolean[] toStartVisited = new boolean[N+1];
			dfs(graphR, start, toStartVisited);


			boolean[] toEndVisited = new boolean[N+1];
			dfs(graphR, end, toEndVisited);

			int cnt = 0;

			for (int i = 1; i<= N; i++) {

				if (fromStartVisited[i] && fromEndVisited[i] && toStartVisited[i] && toEndVisited[i]){
					cnt++;
				}
			}
			System.out.println(cnt-2);
		}

		static void dfs(ArrayList<Integer>[] graph, int node, boolean[] visited){
			if (visited[node] == true) return;

			visited[node] = true;

			for (int nextNode : graph[node]) {
				dfs(graph, nextNode, visited);
			}
		}
	}
}
