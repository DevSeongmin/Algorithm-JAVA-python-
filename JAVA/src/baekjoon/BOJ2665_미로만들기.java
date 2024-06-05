package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2665_미로만들기 {
	static int N;
	static int[] moveX = {-1, 1, 0, 0};
	static int[] moveY = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		int[][] board = new int[N][N];
		boolean[][][] visited = new boolean[N * 2 + 1][N][N];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				board[i][j] = line.charAt(j) - '0';
			}
		}

		Queue<Node> q = new LinkedList<>();

		q.add(new Node(0, 0, 0));
		visited[0][0][0] = true;

		int answer = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			Node curNode = q.poll();

			if (curNode.y == N - 1 && curNode.x == N - 1) {
				answer = Math.min(answer, curNode.depth);
			}

			for (int i = 0; i < 4; i++) {
				int ny = curNode.y + moveY[i];
				int nx = curNode.x + moveX[i];

				if (!isIn(nx, ny))
					continue;

				if (board[ny][nx] == 1 && !visited[curNode.depth][ny][nx]) {
					q.add(new Node(ny, nx, curNode.depth));
					visited[curNode.depth][ny][nx] = true;
				}

				if (curNode.depth < N * 2 && board[ny][nx] == 0 && !visited[curNode.depth + 1][ny][nx]) {
					if (!visited[curNode.depth + 1][ny][nx]) {
						q.add(new Node(ny, nx, curNode.depth + 1));
						visited[curNode.depth + 1][ny][nx] = true;
					}
				}

			}
		}

		System.out.println(answer);

	}

	static boolean isIn(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < N;
	}

	static class Node {
		int y, x, depth;

		public Node(int y, int x, int depth) {
			this.y = y;
			this.x = x;
			this.depth = depth;
		}
	}
}
