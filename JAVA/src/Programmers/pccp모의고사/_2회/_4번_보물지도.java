package Programmers.pccp모의고사._2회;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _4번_보물지도 {

	class Solution {

		static int[] dy = {-1, 0, 1, 0};
		static int[] dx = {0, -1, 0, 1};
		static int Y, X;

		public int solution(int n, int m, int[][] hole) {
			Y = m;
			X = n;

			boolean[][] isHole = new boolean[Y][X];

			for (int[] h : hole) {
				int y = h[1] - 1;
				int x = h[0] - 1;

				isHole[y][x] = true;
			}

			int[][][] minimumTimeMap = new int[2][Y][X];
			for (int i = 0; i < Y; i++) {
				Arrays.fill(minimumTimeMap[0][i], Integer.MAX_VALUE);
				Arrays.fill(minimumTimeMap[1][i], Integer.MAX_VALUE);
			}

			Node start = new Node(0, 0, 0, 0);
			Queue<Node> q = new LinkedList<>();
			minimumTimeMap[0][0][0] = 0;
			q.add(start);

			while (!q.isEmpty()) {
				Node cur = q.poll();

				for (int i = 0; i < 4; i++) {
					int ny = cur.y + dy[i];
					int nx = cur.x + dx[i];

					if (!isIn(ny, nx)) continue;
					if (isHole[ny][nx]) continue;
					if (cur.time + 1 >= minimumTimeMap[cur.isJump][ny][nx]) continue;

					q.add(new Node(ny, nx, cur.time + 1, cur.isJump));
					minimumTimeMap[cur.isJump][ny][nx] = cur.time+1;
				}

				if (cur.isJump == 1) continue;

				for (int i = 0; i < 4; i++) {
					int ny = cur.y + dy[i] * 2;
					int nx = cur.x + dx[i] * 2;

					if (!isIn(ny, nx)) continue;
					if (isHole[ny][nx]) continue;
					if (cur.time + 1 >= minimumTimeMap[1][ny][nx]) continue;

					q.add(new Node(ny, nx, cur.time + 1, 1));
					minimumTimeMap[1][ny][nx] = cur.time + 1;
				}
			}

			int answer = Math.min(minimumTimeMap[0][Y-1][X-1], minimumTimeMap[1][Y-1][X-1]);

			return answer == Integer.MAX_VALUE ? -1 : answer;
		}

		static boolean isIn(int y, int x) {
			return 0 <= y && y < Y && 0 <= x && x < X;
		}
	}

	class Node {
		int y, x, time, isJump;

		public Node(int y, int x, int time, int isJump) {
			this.y = y;
			this.x = x;
			this.time = time;
			this.isJump = isJump;
		}
	}
}
