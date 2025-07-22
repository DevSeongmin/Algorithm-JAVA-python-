package Programmers;

public class Lv2_혼자서_하는_틱택토 {

	class Solution {
		public int solution(String[] board) {

			TickTackToBoard myBoard = new TickTackToBoard(board);

			return myBoard.isAvailableStatus() ? 1 : 0;
		}
	}

	class TickTackToBoard{
		char[][] board;
		int oCnt;
		int xCnt;
		boolean oFinished;
		boolean xFinished;

		public TickTackToBoard(String[] board) {
			this.board = new char[board.length][];

			for (int i = 0; i < board.length; i++) {
				this.board[i] = board[i].toCharArray();
			}

			setOcntAndXcnt();
			setOFinished();
			setXFinished();
		}

		private void setOcntAndXcnt() {
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board.length; j++) {
					if (board[i][j] == 'O') {
						oCnt++;
					}
					if (board[i][j] == 'X') {
						xCnt++;
					}
				}
			}
		}

		private void setOFinished() {
			for (int i = 0; i < 3; i++) {
				if (board[i][0] == 'O' && board[i][1] == 'O' && board[i][2] == 'O') {
					oFinished = true;
					return;
				}

				if (board[0][i] == 'O' && board[1][i] == 'O' && board[2][i] == 'O') {
					oFinished = true;
					return;
				}
			}

			if (board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O') {
				oFinished = true;
				return;
			}

			if (board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O') {
				oFinished = true;
				return;
			}
		}

		private void setXFinished() {
			for (int i = 0; i < 3; i++) {
				if (board[i][0] == 'X' && board[i][1] == 'X' && board[i][2] == 'X') {
					xFinished = true;
					return;
				}

				if (board[0][i] == 'X' && board[1][i] == 'X' && board[2][i] == 'X') {
					xFinished = true;
					return;
				}
			}

			if (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X') {
				xFinished = true;
				return;
			}

			if (board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X') {
				xFinished = true;
				return;
			}
		}

		public boolean isAvailableStatus() {
			if (xCnt > oCnt) return false;
			if (oCnt - xCnt > 1) return false;

			if (xFinished && oFinished) return false;

			if (xFinished && oCnt != xCnt) return false;
			if (oFinished && oCnt != xCnt + 1) return false;

			return true;
		}
	}

}
