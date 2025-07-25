package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Lv3_미로_탈출_명령어 {

	class Solution {
		static int[] dy = {1, 0, 0, -1};
		static int[] dx = {0, -1, 1, 0};
		static char[] direction = {'d', 'l', 'r', 'u'};

		static int Y, X;

		public String solution(int n, int m, int x, int y, int r, int c, int k) {
			Y = n;
			X = m;

			int startY = x - 1;
			int startX = y - 1;
			int endY = r - 1;
			int endX = c - 1;

			Node startNode = new Node(startY, startX, 0, "");

			boolean[][][] visited = new boolean[k+1][n][m];
			Queue<Node> q = new LinkedList<>();

			visited[0][0][0] = true;
			q.add(startNode);

			while (!q.isEmpty()) {
				Node curNode = q.poll();


				if (curNode.y == endY && curNode.x == endX && curNode.depth == k) {
					return curNode.path;
				}

				if (curNode.depth >= k) continue;

				for (int i = 0; i < 4; i++) {
					int ny = curNode.y + dy[i];
					int nx = curNode.x + dx[i];
					int nDepth = curNode.depth + 1;

					if (!isIn(ny, nx)) continue;
					if (visited[nDepth][ny][nx]) continue;

					int dist = getManhatanDist(ny, nx, endY, endX);
					int remain = k - nDepth;
					if (dist > remain || (remain - dist) % 2 != 0) continue;

					visited[nDepth][ny][nx] = true;
					q.add(new Node(ny,nx,nDepth, curNode.path + direction[i]));
				}
			}


			return "impossible";
		}

		static int getManhatanDist(int y1, int x1, int y2, int x2) {
			return Math.abs(y1 - y2) + Math.abs(x1 - x2);
		}

		static boolean isIn(int y, int x) {
			return 0 <= y && y < Y && 0 <= x && x < X;
		}

		class Node{
			int y, x, depth;
			String path;

			public Node(int y, int x, int depth, String path) {
				this.y = y;
				this.x = x;
				this.depth = depth;
				this.path = path;
			}
		}
	}
}
