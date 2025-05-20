package leet_code.medium;

public class _130_Surrounded_Regions {
	class Solution {
		int Y, X;
		int[] dy = {-1, 1, 0, 0};
		int[] dx = {0, 0, -1, 1};

		public void solve(char[][] board) {
			Y = board.length;
			X = board[0].length;


			for (int i = 0; i < Y; i++) {
				dfs(i, 0, board);
				dfs(i, X-1, board);
			}

			for (int i = 0; i < X; i++) {
				dfs(0, i, board);
				dfs(Y-1, i, board);
			}

			for (int i = 0; i < Y; i++) {
				for (int j = 0; j < X; j++) {
					board[i][j] = board[i][j] ==  'T' ? 'O' : 'X';
				}
			}
		}

		boolean isIn(int y, int x) {
			return 0 <= y && y < Y && 0 <= x && x < X;
		}

		void dfs(int y, int x, char[][] board) {
			if (!isIn(y ,x)) return;
			if (board[y][x] != 'O') return;

			board[y][x] = 'T';

			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];

				dfs(ny,nx, board);
			}
		}
		class Pair{
			int y, x;

			public Pair(int y, int x) {
				this.y = y;
				this.x = x;
			}
		}
	}
}
