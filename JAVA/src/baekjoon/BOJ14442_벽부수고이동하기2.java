package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ14442_벽부수고이동하기2 {

	static int Y, X;

	static int[] moveY = {-1, 1, 0, 0};
	static int[] moveX = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		Y = Integer.parseInt(input[0]);
		X = Integer.parseInt(input[1]);
		int K = Integer.parseInt(input[2]);

		int[][] map = new int[Y][X];
		boolean[][][] visited = new boolean[K + 1][Y][X];

		for (int i = 0; i < Y; i++) {
			input = br.readLine().split("");
			for (int j = 0; j < X; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}

		Queue<Node> q = new LinkedList<>();
		Node startNode = new Node(0, 0, K, 1);
		q.add(startNode);
		visited[K][0][0] = true;

		while (!q.isEmpty()) {
			Node curNode = q.poll();

			if (curNode.y == Y - 1 && curNode.x == X - 1) {
				System.out.println(curNode.cnt);
				System.exit(0);
			}

			for (int i = 0; i < 4; i++) {
				int ny = curNode.y + moveY[i];
				int nx = curNode.x + moveX[i];

				if (!isIn(ny, nx))
					continue;

				if (map[ny][nx] == 0 && !visited[curNode.k][ny][nx]) {
					visited[curNode.k][ny][nx] = true;
					q.add(new Node(ny, nx, curNode.k, curNode.cnt + 1));
				}

				if (map[ny][nx] == 1 && curNode.k > 0 && !visited[curNode.k - 1][ny][nx]) {
					visited[curNode.k - 1][ny][nx] = true;
					q.add(new Node(ny, nx, curNode.k - 1, curNode.cnt + 1));
				}

			}

		}

		System.out.println(-1);

	}

	static boolean isIn(int y, int x) {
		return 0 <= x && x < X && 0 <= y && y < Y;
	}

	static class Node {
		int y, x, k, cnt;

		public Node(int y, int x, int k, int cnt) {
			this.y = y;
			this.x = x;
			this.k = k;
			this.cnt = cnt;
		}
	}

}
