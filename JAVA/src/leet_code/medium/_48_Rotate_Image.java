package leet_code.medium;

public class _48_Rotate_Image {
	class Solution {
		public void rotate(int[][] matrix) {

			int N = matrix.length;

			for (int i = 0; i < N; i++) {
				for (int j = i; j < N; j++) {
					int tmp = matrix[i][j];
					matrix[i][j] = matrix[j][i];
					matrix[j][i] = tmp;
				}
			}

			for (int i = 0; i < N; i++) {
				int left = 0;
				int right = N-1;

				while (left < right) {
					int tmp = matrix[i][left];
					matrix[i][left] = matrix[i][right];
					matrix[i][right] = tmp;
					left++;
					right--;
				}
			}
		}
	}
}
