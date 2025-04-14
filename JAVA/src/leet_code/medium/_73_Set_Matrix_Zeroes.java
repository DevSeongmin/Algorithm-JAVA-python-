package leet_code.medium;

/**
 * 추가 적인 공간을 사용하지 않고 푸는게 핵심
 */
public class _73_Set_Matrix_Zeroes {
	class Solution {
		public void setZeroes(int[][] matrix) {

			int Y = matrix.length;
			int X = matrix[0].length;

			boolean yFlag = false;
			boolean xFlag = false;

			for (int i = 0; i < Y; i++) {
				if (matrix[i][0] == 0) yFlag = true;
			}

			for (int i = 0; i < X; i++) {
				if (matrix[0][i] == 0) xFlag = true;
			}

			for (int i = 1; i < Y; i++) {
				for (int j = 1; j < X; j++) {
					if (matrix[i][j] == 0) {
						matrix[i][0] = 0;
						matrix[0][j] = 0;
					}
				}
			}

			for (int i = 1; i < Y; i++) {
				for (int j = 1; j < X; j++) {
					if (matrix[i][0] == 0 || matrix[0][j] == 0) {
						matrix[i][j] = 0;
					}
				}
			}

			if (xFlag) {
				for (int i = 0; i < X; i++) {
					matrix[0][i] = 0;
				}
			}

			if (yFlag) {
				for (int i = 0; i < Y; i++) {
					matrix[i][0] = 0;
				}
			}
		}
	}
}
