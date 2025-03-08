package leet_code.medium;

import java.util.LinkedList;
import java.util.Queue;

import leet_code.common.Node;

public class _1926_Nearest_Exit_from_Entrance_in_Maze {

	static class Solution {

		static int Y, X;
		static int[] dy = {-1, 1, 0, 0};
		static int[] dx = {0, 0, -1, 1};

		public int nearestExit(char[][] maze, int[] entrance) {
			Y = maze.length;
			X = maze[0].length;
			int sy = entrance[0];
			int sx = entrance[1];
			boolean[][] visited = new boolean[Y][X];

			Node startNode = new Node(sy, sx, 0);
			visited[sy][sx] = true;

			Queue<Node> q = new LinkedList<>();
			q.add(startNode);

			while(!q.isEmpty()) {
				Node curNode = q.poll();
				System.out.println(curNode.y + "  " + curNode.x);
				if ( !(curNode.y == sy && curNode.x == sx) &&
					(curNode.x == 0 || curNode.x == X-1 ||
						curNode.y == 0 || curNode.y == Y-1)) {
					return curNode.cnt;
				}

				for (int i = 0; i < 4; i++) {
					int ny = curNode.y + dy[i];
					int nx = curNode.x + dx[i];

					if (!isIn(ny, nx)) continue;
					if (visited[ny][nx]) continue;
					if (maze[ny][nx] == '+') continue;

					q.add(new Node(ny, nx, curNode.cnt + 1));
					visited[ny][nx] = true;
				}
			}


			return -1;
		}

		static boolean isIn(int y, int x) {
			return 0 <= y && y < Y && 0 <= x && x < X;
		}
	}
}
