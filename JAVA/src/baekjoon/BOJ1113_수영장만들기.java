package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ1113_수영장만들기 {

	static int[] moveX = {-1, 1, 0, 0};
	static int[] moveY = {0, 0, -1, 1};
	static int[][] pool;
	private static int X, Y;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력
		String[] input = br.readLine().split(" ");
		Y = Integer.parseInt(input[0]);
		X = Integer.parseInt(input[1]);

		// 2차원 배열로 높이 입력
		pool = new int[Y][X];
		for (int i = 0; i < Y; i++) {
			String line = br.readLine();
			for (int j = 0; j < X; j++) {
				pool[i][j] = line.charAt(j) - '0';
			}
		}

		int answer = 0;
		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				int limit = bfs(i, j);
				if (limit != -1) {
					answer += fill(i, j, limit);
				}
			}
		}
		System.out.println(answer);

	}

	static int bfs(int y, int x) {

		int limit = Integer.MAX_VALUE;

		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(y, x));
		boolean[][] visited = new boolean[Y][X];
		visited[y][x] = true;

		while (!q.isEmpty()) {
			Node cur = q.poll();

			if (isBorder(cur.y, cur.x)) {
				return -1;
			}

			for (int i = 0; i < 4; i++) {
				int ny = cur.y + moveY[i];
				int nx = cur.x + moveX[i];

				if (visited[ny][nx])
					continue;

				if (pool[ny][nx] <= pool[y][x]) {
					q.add(new Node(ny, nx));
					visited[ny][nx] = true;
				} else {
					limit = Math.min(limit, pool[ny][nx]);
				}
			}

		}
		return limit;
	}

	static int fill(int y, int x, int limit) {
		int cnt = 0;

		cnt += limit - pool[y][x];
		pool[y][x] = limit;

		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(y, x));

		while (!q.isEmpty()) {
			Node cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int ny = cur.y + moveY[i];
				int nx = cur.x + moveX[i];

				if (pool[ny][nx] < limit) {
					cnt += limit - pool[ny][nx];
					pool[ny][nx] = limit;
					q.offer(new Node(ny, nx));
				}
			}
		}
		return cnt;

	}

	static boolean isBorder(int y, int x) {
		return y == 0 || y == Y - 1 || x == 0 || x == X - 1;
	}

	static class Node {
		int y, x;

		Node(int y, int x) {
			this.y = y;
			this.x = x;
		}

		@Override
		public String toString() {
			return "Node{" +
				"y=" + y +
				", x=" + x +
				'}';
		}
	}
}
