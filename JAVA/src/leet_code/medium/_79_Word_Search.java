package leet_code.medium;

public class _79_Word_Search {
	class Solution {

		int Y, X;
		String word;
		char[][] board;
		int[] dy = {-1, 1, 0, 0};
		int[] dx = {0, 0, -1, 1};

		public boolean exist(char[][] board, String word) {
			this.board = board;
			this.word = word;

			Y = board.length;
			X = board[0].length;

			for (int i = 0; i < Y; i++) {
				for (int j = 0; j < X; j++) {
					if (board[i][j] == word.charAt(0) && search(i, j, 0)) return true;
				}
			}

			return false;
		}

		boolean search(int y, int x, int depth) {
			if (depth == word.length()-1){
				return word.charAt(depth) == board[y][x];
			}

			char tmp = board[y][x];
			board[y][x] = '#';

			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];

				if (!isIn(ny, nx)) continue;
				if (board[ny][nx] != word.charAt(depth + 1)) continue;

				if (search(ny, nx, depth + 1)) return true;
			}

			board[y][x] = tmp;
			return false;
		}

		boolean isIn(int y, int x) {
			return 0 <= y && y < Y && 0 <= x && x < X;
		}
	}
}
