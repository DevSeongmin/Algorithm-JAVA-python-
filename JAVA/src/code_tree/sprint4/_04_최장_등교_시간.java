package code_tree.sprint4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
	int node, weight;

	public Node(int node, int weight){
		this.node = node;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node o){
		return Integer.compare(this.weight, o.weight);
	}
}

public class _04_최장_등교_시간 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		ArrayList<Node>[] graph = new ArrayList[N+1];

		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[e].add(new Node(s, w));
		}

		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[N] = 0;

		Node startNode = new Node(N, 0);

		PriorityQueue<Node> pq = new PriorityQueue();
		pq.add(startNode);

		while (!pq.isEmpty()) {
			Node curNode = pq.poll();
			for (Node nextNode : graph[curNode.node]){

				if (dist[nextNode.node] > dist[curNode.node] + nextNode.weight) {
					dist[nextNode.node] = dist[curNode.node] + nextNode.weight;
					pq.add(new Node(nextNode.node, dist[nextNode.node]));
				}
			}
		}

		int answer = -1;
		for (int i = 1; i <= N; i++) {
			answer = Math.max(answer, dist[i]);
		}

		System.out.println(answer);
	}
}