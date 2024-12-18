package code_tree.sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Edge{
	int v;
	long w;

	public Edge(int v, long w){
		this.v = v;
		this.w = w;
	}
}

public class _03_트리의_지름_길이 {

	static int N;
	static long[] dist;
	static boolean[] visited;
	static ArrayList<Edge>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		dist = new long[N+1];
		visited= new boolean[N+1];
		graph = new ArrayList[N+1];

		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList();
		}

		for (int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph[s].add(new Edge(e, w));
			graph[e].add(new Edge(s, w));
		}

		dfs(1);

		long length = -1;
		int startIdx = -1;

		for (int i = 1; i <= N; i++) {
			if (dist[i] > length){
				length = dist[i];
				startIdx = i;
			}
		}

		dist = new long[N+1];
		visited = new boolean[N+1];
		dfs(startIdx);

		System.out.println(Arrays.stream(dist).max().getAsLong());
	}

	static void dfs(int v){

		for (Edge e : graph[v]){
			if (visited[e.v]) continue;

			visited[e.v] = true;
			dist[e.v] = dist[v] + e.w;
			dfs(e.v);
		}
	}
}
