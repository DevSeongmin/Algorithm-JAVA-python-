package leet_code.medium;

import java.util.LinkedList;
import java.util.Queue;

public class _994_Rotting_Oranges {
	class Solution {
		static int Y, X;
		static int[] dy = {-1, 1, 0, 0};
		static int[] dx = {0, 0, -1, 1};

		public int orangesRotting(int[][] grid) {
			Y = grid.length;
			X = grid[0].length;

			Queue<int[]> q = new LinkedList<>();

			boolean initCheck = true;
			for (int i = 0; i < Y; i++) {
				for (int j = 0; j < X; j++) {
					if (grid[i][j] == 2) {
						q.add(new int[] {i, j});
						grid[i][j] = 0;
					} else if (grid[i][j] == 1) {
						initCheck= false;
					}
				}
			}

			if (initCheck) return 0;

			int time = -1;

			while (!q.isEmpty()) {
				int qSize = q.size();

				for (int qi = 0; qi < qSize; qi++) {
					int[] curNode = q.poll();

					for (int i = 0; i < 4; i++) {
						int ny = curNode[0] + dy[i];
						int nx = curNode[1] + dx[i];

						if (!isIn(ny, nx)) continue;
						if (grid[ny][nx] != 1) continue;

						grid[ny][nx] = 0;
						q.add(new int[] {ny, nx});
					}
				}
				time++;
			}

			for (int i = 0; i < Y; i++) {
				for (int j = 0; j < X; j++) {
					if (grid[i][j] == 1) return -1;
				}
			}

			return time;
		}
		static boolean isIn(int y, int x) {
			return 0 <= y && y < Y && 0 <= x && x < X;
		}
	}
}
