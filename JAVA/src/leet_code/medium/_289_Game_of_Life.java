package leet_code.medium;

public class _289_Game_of_Life {

	/**
	 * 
	 * in-place로 해결하는게 핵심이다. 물론 추가적인 메모리를 사용하더라도 해결은 가능
	 * 1은 살아있는 상태 0 은 죽어있는 상태이다 비트 마스킹을 이용해서 
	 * X X 
	 * 위 처럼 두자리로 만들고 첫번째 비트는 다음 생에의 상태 두번째 자리 비트는 현재 상태를 나타냄으로 써 추가적인 공간을 사용하지 않고 해결할 수 있다.
 	 */	
	class Solution {
		static int Y, X;

		static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
		static int[] dx = {0, -1, 1, -1, 1, 0, -1, 1};

		public void gameOfLife(int[][] board) {
			Y = board.length;
			X = board[0].length;

			for (int i = 0; i < Y; i++) {
				for (int j = 0; j < X; j++) {

					int oneCount = 0;
					for (int d = 0 ; d < 8; d++) {
						int ny = i + dy[d];
						int nx = j + dx[d];

						if (!isIn(ny, nx)) {
							continue;
						}

						if ((board[ny][nx] & 1) == 1) oneCount++;
					}

					if (board[i][j] == 1 && (oneCount == 2 || oneCount == 3)) {
						board[i][j] =  3;
					}

					if (board[i][j] == 0 && oneCount == 3) {
						board[i][j] = 2;
					}
				}
			}

			for (int i = 0; i < Y; i++) {
				for (int j = 0; j < X; j++) {
					board[i][j] >>= 1;
				}
			}
		}

		static boolean isIn(int y, int x) {
			return 0 <= y && y < Y && 0 <= x && x < X;
		}
	}
}
