package leet_code.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class _909_Snakes_and_Ladders {
	class Solution {
		public int snakesAndLadders(int[][] board) {
			int N = board.length;

			int left = 0;
			int right = N-1;

			while (left < right) {
				int[] tmp = board[left];
				board[left] = board[right];
				board[right] = tmp;
				left++;
				right--;
			}

			int cnt = 0;
			int[] myBoard = new int[N*N];
			Arrays.fill(myBoard, -1);

			for (int i = 0; i < N; i++) {
				if (i % 2 == 0) {
					for (int j = 0; j < N; j++) {
						if (board[i][j] != -1){
							myBoard[cnt] = board[i][j] - 1;
						}
						cnt++;
					}
				} else {
					for (int j = N-1; j >= 0; j--) {
						if (board[i][j] != -1) {
							myBoard[cnt] = board[i][j] - 1;
						}
						cnt++;
					}
				}
			}

			Queue<Horse> q = new LinkedList<>();
			HashSet<Integer> visited = new HashSet<>();

			Horse start = new Horse(0, 0);
			q.add(start);
			visited.add(0);

			while (!q.isEmpty()) {
				Horse cur = q.poll();

				if (cur.idx == N * N -1) return cur.cnt;

				for (int i = 6; i > 0; i--) {
					int nextIdx = cur.idx + i;

					if (nextIdx >= N * N) continue;

					if (myBoard[nextIdx] != -1) {
						nextIdx = myBoard[nextIdx];
					}

					if (visited.contains(nextIdx)) continue;

					if (!visited.contains(nextIdx)){
						q.add(new Horse(nextIdx, cur.cnt+1));
						visited.add(nextIdx);
					}
				}
			}
			return -1;
		}

		class Horse{
			int idx;
			int cnt;
			public Horse(int idx, int cnt) {
				this.idx = idx;
				this.cnt = cnt;
			}
		}
	}
}
