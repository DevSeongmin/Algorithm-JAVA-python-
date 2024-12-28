package code_tree.sprint15;

import java.util.*;
import java.io.*;

class Node {
	int y,x,cnt;

	public Node(int y, int x, int cnt) {
		this.y = y;
		this.x = x;
		this.cnt = cnt;
	}
}

public class _02_점프하며_이동하기 {

	static int N;
	static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] dx = {-2, -1, 1, 2, -2, -1, 1, 2};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		Node startNode = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
		Node endNode = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

		Set<String> visited = new HashSet();
		Queue<Node> q = new LinkedList();

		visited.add(startNode.y + " " + startNode.x);
		q.add(startNode);

		while(!q.isEmpty()) {
			Node cur = q.poll();

			if (cur.y == endNode.y && cur.x == endNode.x) {
				System.out.println(cur.cnt);
				return;
			}

			for (int i = 0; i < 8; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];

				if (!isIn(ny, nx)) continue;
				if (visited.contains(ny + " " + nx)) continue;

				visited.add(ny + " " + nx);
				q.add(new Node(ny, nx, cur.cnt + 1));
			}
		}
		System.out.println(-1);
	}

	static boolean isIn(int y, int x) {
		return 0 < y && y <= N && 0 < x && x <= N;
	}
}