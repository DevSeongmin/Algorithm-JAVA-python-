package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ5972_택배배송 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		ArrayList<Node>[] graph = new ArrayList[N + 1];

		for (int i = 0; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph[s].add(new Node(e, w));
			graph[e].add(new Node(s, w));
		}

		PriorityQueue<Node> pq = new PriorityQueue();
		pq.add(new Node(1, 0));
		dist[1] = 0;

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			for (Node next : graph[cur.node]) {
				if (dist[next.node] > dist[cur.node] + next.weight) {
					dist[next.node] = dist[cur.node] + next.weight;
					pq.add(new Node(next.node, dist[next.node]));
				}
			}
		}

		System.out.println(dist[N]);
	}

	static class Node implements Comparable<Node> {
		int node, weight;

		public Node(int node, int weight) {
			this.node = node;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
}
