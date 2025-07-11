package Programmers.pccp기출문제;

import java.util.LinkedList;
import java.util.Queue;

public class _2번_석유_시추 {

	class Solution {
		static int Y;
		static int X;
		static int[] dy = {-1, 1, 0, 0};
		static int[] dx = {0, 0, 1, -1};

		public int solution(int[][] land) {
			Y = land.length;
			X = land[0].length;
			int[] gases = new int[X];

			boolean[][] visited = new boolean[Y][X];

			for (int i = 0; i < Y; i++) {
				for (int j = 0; j < X; j++) {
					if (visited[i][j]) continue;
					if (land[i][j] == 0) continue;

					bfs(i, j, land, visited, gases);
				}
			}

			int answer = -1;
			for (int gas : gases) {
				answer = Math.max(answer, gas);
			}

			return answer;
		}

		static void bfs(int y, int x, int[][] land, boolean[][] visited, int[] gases) {
			Queue<Node> q = new LinkedList<>();
			q.add(new Node(y, x));
			visited[y][x] = true;

			int cnt = 0;
			int leftX = x;
			int rightX = x;

			while (!q.isEmpty()) {
				Node cur = q.poll();
				leftX = Math.min(leftX, cur.x);
				rightX = Math.max(rightX, cur.x);
				cnt++;

				for (int i = 0; i < 4; i++) {
					int nx = cur.x + dx[i];
					int ny = cur.y + dy[i];

					if (!isIn(ny, nx)) continue;
					if (visited[ny][nx]) continue;
					if (land[ny][nx] == 0) continue;

					q.add(new Node(ny, nx));
					visited[ny][nx] = true;
				}
			}

			for (int i = leftX; i <= rightX; i++) {
				gases[i] += cnt;
			}

		}

		static boolean isIn(int y, int x) {
			return 0 <= y && y < Y && 0 <= x && x < X;
		}

		static class Node {
			int y, x;
			public Node(int y, int x) {
				this.y = y;
				this.x = x;
			}
		}
	}
}
