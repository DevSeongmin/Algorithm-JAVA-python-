package b형특강.pro;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class UserSolution {
	public final int MAX_N = 20;
	public final int MAX_HASH = 9999;

	public int n;
	public int[][] initMap = new int[MAX_N + 2][MAX_N + 2];
	public int[][] modifiedMap = new int[MAX_N + 2][MAX_N + 2];
	public List<Candidate>[] candidate = new List[MAX_HASH + 1];
	public boolean[][] check = new boolean[MAX_N + 2][MAX_N + 2];
	public int[] dx = {1, 0, -1, 0};
	public int[] dy = {0, 1, 0, -1};

	public void init(int N, int[][] mMap) {
		n = N;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				modifiedMap[i + 1][j + 1] = initMap[i + 1][j + 1] = mMap[i][j];
		for (int i = 0; i <= MAX_HASH; i++)
			candidate[i] = new ArrayList<>();

		for (int length = 2; length <= 5; length++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j + length - 1 <= n; j++) {
					int hash = 0;
					for (int k = 0; k + 1 < length; k++)
						hash = hash * 10 + (initMap[i][j + k + 1] - initMap[i][j + k] + 5);
					candidate[hash].add(new Candidate(i, j, true, false));

					int reverseHash = 0;
					for (int k = length - 1; k - 1 >= 0; k--)
						reverseHash = reverseHash * 10 + (initMap[i][j + k - 1] - initMap[i][j + k] + 5);
					if (reverseHash != hash)
						candidate[reverseHash].add(new Candidate(i, j, true, true));
				}
			}
			for (int i = 1; i + length - 1 <= n; i++) {
				for (int j = 1; j <= n; j++) {
					int hash = 0;
					for (int k = 0; k + 1 < length; k++)
						hash = hash * 10 + (initMap[i + k + 1][j] - initMap[i + k][j] + 5);
					candidate[hash].add(new Candidate(i, j, false, false));

					int reverseHash = 0;
					for (int k = length - 1; k - 1 >= 0; k--)
						reverseHash = reverseHash * 10 + (initMap[i + k - 1][j] - initMap[i + k][j] + 5);
					if (reverseHash != hash)
						candidate[reverseHash].add(new Candidate(i, j, false, true));
				}
			}
		}
	}

	public int numberOfCandidate(int M, int[] mStructure) {
		if (M == 1)
			return n * n;

		int hash = 0;
		for (int i = 0; i + 1 < M; i++)
			hash = hash * 10 + (mStructure[i] - mStructure[i + 1] + 5);
		return candidate[hash].size();
	}

	public int unsubmergedArea(int[][] mMap, int mSeaLevel) {
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i <= n + 1; i++) {
			for (int j = 0; j <= n + 1; j++) {
				if (i == 0 || i == n + 1 || j == 0 || j == n + 1) {
					q.add(new int[] {i, j});
					check[i][j] = true;
				} else
					check[i][j] = false;
			}
		}
		while (!q.isEmpty()) {
			int[] front = q.poll();
			for (int i = 0; i < 4; i++) {
				int[] rear = {front[0] + dx[i], front[1] + dy[i]};
				if (rear[0] >= 1 && rear[0] <= n && rear[1] >= 1 && rear[1] <= n) {
					if (!check[rear[0]][rear[1]] && mMap[rear[0]][rear[1]] < mSeaLevel) {
						q.add(rear);
						check[rear[0]][rear[1]] = true;
					}
				}
			}
		}
		int ret = 0;
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= n; j++)
				if (!check[i][j])
					ret++;
		return ret;
	}

	public int maxArea(int M, int[] mStructure, int mSeaLevel) {
		int ret = -1;
		if (M == 1) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					modifiedMap[i][j] = initMap[i][j] + mStructure[0];
					ret = Math.max(ret, unsubmergedArea(modifiedMap, mSeaLevel));
					modifiedMap[i][j] = initMap[i][j];
				}
			}
			return ret;
		}

		int hash = 0;
		for (int i = 0; i + 1 < M; i++)
			hash = hash * 10 + (mStructure[i] - mStructure[i + 1] + 5);

		for (Candidate wall : candidate[hash]) {
			if (wall.isHorizontal) {
				int height =
					mStructure[0] + (wall.isReverse ? initMap[wall.r][wall.c + M - 1] : initMap[wall.r][wall.c]);
				for (int i = 0; i < M; i++)
					modifiedMap[wall.r][wall.c + i] = height;
				ret = Math.max(ret, unsubmergedArea(modifiedMap, mSeaLevel));
				if (M >= 0)
					System.arraycopy(initMap[wall.r], wall.c, modifiedMap[wall.r], wall.c, M);
			} else {
				int height =
					mStructure[0] + (wall.isReverse ? initMap[wall.r + M - 1][wall.c] : initMap[wall.r][wall.c]);
				for (int i = 0; i < M; i++)
					modifiedMap[wall.r + i][wall.c] = height;
				ret = Math.max(ret, unsubmergedArea(modifiedMap, mSeaLevel));
				for (int i = 0; i < M; i++)
					modifiedMap[wall.r + i][wall.c] = initMap[wall.r + i][wall.c];
			}
		}
		return ret;
	}

	public class Candidate {
		int r;
		int c;
		boolean isHorizontal;
		boolean isReverse;

		public Candidate(int r, int c, boolean isHorizontal, boolean isReverse) {
			this.r = r;
			this.c = c;
			this.isHorizontal = isHorizontal;
			this.isReverse = isReverse;
		}
	}
}
