package Programmers;

import java.util.Arrays;

public class Lv3_2차원_동전_뒤집기 {


	public int solution(int[][] beginning, int[][] target) {
		int Y = beginning.length;
		int X = beginning[0].length;
		int answer = Integer.MAX_VALUE;

		for (int bitMask = 0; bitMask < 1 << Y; bitMask++) {
			int[][] tmp = copyArray(beginning);

			int yFlipCount = 0;

			for (int y = 0; y < Y; y++) {
				if ((bitMask & (1 << y)) > 0) {
					flipX(tmp, y);
					yFlipCount++;
				}
			}

			int xFlipCount = 0;
			for (int x = 0; x < X; x++) {
				if (tmp[0][x] != target[0][x]) {
					flipY(tmp, x);
					xFlipCount++;
				}
			}

			if (ArraysEquals(tmp, target)) {
				answer = Math.min(answer, xFlipCount + yFlipCount);
			}
		}

		return answer == Integer.MAX_VALUE ? -1 : answer;
	}

	private boolean ArraysEquals(int[][] a, int[][] b) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (a[i][j] != b[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	private void flipY(int[][] tmp, int x) {
		for (int i = 0; i < tmp.length; i++) {
			tmp[i][x] ^= 1;
		}
	}

	private void flipX(int[][] tmp, int y) {
		for (int i = 0; i < tmp[y].length; i++) {
			tmp[y][i] ^= 1;
		}
	}

	private int[][] copyArray(int[][] beginning) {

		int[][] result = new int[beginning.length][beginning[0].length];

		for (int i = 0; i < beginning.length; i++) {
			result[i] = Arrays.copyOf(beginning[i], beginning[i].length);
		}

		return result;
	}
}
