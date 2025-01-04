package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Lv3_부대복귀 {
	class Solution {

		ArrayList<Integer>[] graph;

		public int[] solution(int n, int[][] roads, int[] sources, int destination) {

			graph = new ArrayList[n+1];

			for (int i = 1; i <= n; i++) {
				graph[i] = new ArrayList();
			}

			for (int[] road : roads) {
				int a = road[0];
				int b = road[1];

				graph[a].add(b);
				graph[b].add(a);
			}

			int[] dists = new int[n+1];
			Arrays.fill(dists, Integer.MAX_VALUE);
			dists[destination] = 0;


			PriorityQueue<Node> pq = new PriorityQueue();
			pq.add(new Node(destination, 0));
			dists[destination] = 0;


			while (!pq.isEmpty()) {
				Node cur = pq.poll();

				for (int next : graph[cur.n]) {
					if (dists[next] > dists[cur.n] + 1) {
						dists[next] = dists[cur.n]  + 1;
						pq.add(new Node(next, dists[next]));
					}
				}
			}

			int[] answers = new int[sources.length];

			for (int i = 0; i < sources.length; i++) {
				answers[i] = dists[sources[i]] == Integer.MAX_VALUE ? -1 : dists[sources[i]];
			}

			return answers;
		}

		static class Node implements Comparable<Node> {
			int n, w;
			public Node(int n, int w) {
				this.n = n;
				this.w = w;
			}

			@Override
			public int compareTo(Node o) {
				return Integer.compare(this.w, o.w);
			}
		}
	}
}
