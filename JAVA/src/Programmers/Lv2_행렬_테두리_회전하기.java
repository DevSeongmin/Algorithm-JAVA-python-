package Programmers;

public class Lv2_행렬_테두리_회전하기 {

	class Solution {

		static int[][] board;

		public int[] solution(int rows, int columns, int[][] queries) {

			board = new int[rows + 1][columns + 1];

			int num = 1;
			for (int i = 1; i <= rows; i++) {
				for (int j = 1; j <= columns; j++) {
					board[i][j] = num++;
				}
			}

			int[] answer = new int[queries.length];

			int answerIdx = 0;
			for (int[] q : queries) {
				answer[answerIdx++] = spin(q[0], q[1], q[2], q[3]);
			}

			return answer;
		}

		static int[] dy = {1, 0, -1, 0};
		static int[] dx = {0, 1, 0, -1};

		public int spin(int y1, int x1, int y2, int x2) {

			int startValue = board[y1][x1];
			int minValue = startValue;

			int curY = y1;
			int curX = x1;

			for (int i = 0; i < 4; i++) {
				while (nextIsIn(curY, curX, y1, x1, y2, x2, i)) {

					board[curY][curX] = board[curY + dy[i]][curX + dx[i]];
					minValue = Math.min(board[curY][curX], minValue);
					curY += dy[i];
					curX += dx[i];
				}
			}

			board[y1][x1 + 1] = startValue;

			return minValue;
		}

		public boolean nextIsIn(int curY, int curX, int y1, int x1, int y2, int x2, int i) {
			int ny = curY + dy[i];
			int nx = curX + dx[i];

			return y1 <= ny && ny <= y2 && x1 <= nx && nx <= x2;

		}

	}

}
