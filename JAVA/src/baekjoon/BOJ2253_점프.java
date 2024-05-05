package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2253_점프 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int end = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		HashSet<Integer> small = new HashSet<>();

		for (int i = 0; i < n; i++) {
			small.add(Integer.parseInt(br.readLine()));
		}

		HashSet<Node> visited = new HashSet<>();
		Queue<Node> q = new LinkedList<>();

		Node start = new Node(1, 1, 1);
		visited.add(start);
		q.add(start);

		while (!q.isEmpty()) {
			Node cur = q.poll();

			int pos = cur.pos + cur.jump;

			if (pos > end || small.contains(pos))
				continue;

			if (pos == end) {
				System.out.println(cur.cnt);
				return;
			}

			for (int i = 1; i > -2; i--) {
				int nextJump = cur.jump + i;

				if (nextJump < 1)
					continue;

				Node nextNode = new Node(pos, nextJump, cur.cnt + 1);

				if (visited.contains(nextNode)) {
					continue;
				}
				q.add(nextNode);
				visited.add(nextNode);
			}
		}
		System.out.println(-1);

	}

	static class Node {
		int pos;
		int jump;
		int cnt;

		public Node(int pos, int jump, int cnt) {
			this.pos = pos;
			this.jump = jump;
			this.cnt = cnt;
		}

		@Override
		public boolean equals(Object o) {
			Node node = (Node)o;
			return pos == node.pos && jump == node.jump;
		}

		@Override
		public int hashCode() {
			return Objects.hash(pos, jump);
		}
	}
}
