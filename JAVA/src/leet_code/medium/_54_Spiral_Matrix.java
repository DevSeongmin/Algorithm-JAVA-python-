package leet_code.medium;

import java.util.ArrayList;
import java.util.List;

public class _54_Spiral_Matrix {
	class Solution {
		static int Y, X;
		static int[] dy = {0, 1, 0, -1};
		static int[] dx = {1, 0, -1, 0};

		public List<Integer> spiralOrder(int[][] matrix) {
			Y = matrix.length;
			X = matrix[0].length;

			boolean[][] visited = new boolean[Y][X];

			ArrayList<Integer> answer = new ArrayList<>();

			int cy = 0;
			int cx = 0;
			int dir = 0;

			for (int i = 0; i < Y * X; i++) {

				answer.add(matrix[cy][cx]);
				visited[cy][cx] = true;

				if (!isIn(cy + dy[dir], cx + dx[dir]) || visited[cy + dy[dir]][cx + dx[dir]]) {
					dir++;
					dir %= 4;
				}

				cy += dy[dir];
				cx += dx[dir];
			}

			return answer;
		}
		static boolean isIn(int y, int x) {
			return 0 <= y && y < Y && 0 <= x && x < X;
		}
	}
}
