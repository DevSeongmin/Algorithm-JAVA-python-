package leet_code.medium;

import java.util.HashSet;

public class _36_Valid_Sudoku {
	class Solution {
		public boolean isValidSudoku(char[][] board) {

			int n = 9;

			for (int i = 0; i < n; i++) {
				HashSet<Character> set = new HashSet<>();
				for (int j = 0; j < n; j++) {
					if (board[i][j] == '.') continue;

					if (set.contains(board[i][j])) {
						return false;
					}

					set.add(board[i][j]);
				}
			}

			for (int i = 0; i < n; i++) {
				HashSet<Character> set = new HashSet<>();
				for (int j = 0; j < n; j++) {
					if (board[j][i] == '.') continue;

					if (set.contains(board[j][i])) {
						return false;
					}
					set.add(board[j][i]);
				}
			}

			for (int i = 0; i < n; i+=3) {
				for (int j = 0; j < n; j+=3) {
					HashSet<Character> set = new HashSet<>();
					for (int k = 0; k < 3; k++) {
						for (int l = 0; l < 3; l++) {
							if (board[i+k][j+l] == '.') continue;

							if (set.contains(board[i+k][j+l])) {
								return false;
							}
							set.add(board[i+k][j+l]);
						}
					}
				}
			}
			return true;

		}
	}
}
