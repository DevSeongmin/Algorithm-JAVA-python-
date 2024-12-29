package code_tree.sprint16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _02_최소_신장_트리 {

	static int N;
	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		PriorityQueue<Edge> pq = new PriorityQueue();

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			pq.add(new Edge(s, e, w));
		}

		init();
		int answer = 0;

		while(!pq.isEmpty()) {
			Edge edge = pq.poll();

			int a = edge.s;
			int b = edge.e;
			int w = edge.w;

			if (union(a, b)) {
				answer+=w;
			}
		}
		System.out.println(answer);
	}

	static void init() {
		parents = new int[N+1];
		for (int i = 0; i <= N; i++) {
			parents[i] = i;
		}
	}

	static int find(int v) {
		if (v == parents[v]) return v;

		return parents[v] = find(parents[v]);
	}

	static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);

		if (rootA == rootB) return false;

		parents[rootA] = rootB;
		return true;
	}
}

class Edge implements Comparable<Edge> {
	int s, e, w;

	public Edge(int s, int e, int w) {
		this.s = s;
		this.e = e;
		this.w = w;
	}

	public int compareTo(Edge o){
		return Integer.compare(this.w, o.w);
	}
}