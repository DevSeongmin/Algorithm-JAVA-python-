package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1446_지름길 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int END = Integer.parseInt(st.nextToken());

		ArrayList<ShortPath>[] shortPathes = new ArrayList[10001];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());

			if (shortPathes[start] == null) {
				shortPathes[start] = new ArrayList<>();
			}
			shortPathes[start].add(new ShortPath(start, end, distance));
		}

		int[] DP = new int[END + 1];
		Arrays.fill(DP, Integer.MAX_VALUE);

		Node StartNode = new Node(0, 0);

		PriorityQueue<Node> pq = new PriorityQueue<>();

		pq.add(StartNode);

		while (!pq.isEmpty()) {
			Node curNode = pq.poll();

			if (curNode.pos == END) {
				System.out.println(curNode.cost);
				break;
			}

			if (shortPathes[curNode.pos] != null) {
				for (ShortPath shortPath : shortPathes[curNode.pos]) {
					if (shortPath.end <= END && curNode.cost + shortPath.distance < DP[shortPath.end]) {
						pq.add(new Node(shortPath.end, curNode.cost + shortPath.distance));
					}
				}
			}

			if (DP[curNode.pos + 1] > curNode.cost + 1) {
				pq.add(new Node(curNode.pos + 1, curNode.cost + 1));
				DP[curNode.pos + 1] = curNode.cost + 1;
			}
		}

	}

	static class Node implements Comparable<Node> {
		int pos, cost;

		public Node(int pos, int cost) {
			this.pos = pos;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
	}

	static class ShortPath {
		int start;
		int end;
		int distance;

		public ShortPath(int start, int end, int distance) {
			this.start = start;
			this.end = end;
			this.distance = distance;
		}
	}
}
