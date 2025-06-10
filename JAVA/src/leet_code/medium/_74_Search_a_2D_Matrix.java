package leet_code.medium;

public class _74_Search_a_2D_Matrix {
	class Solution {
		public boolean searchMatrix(int[][] matrix, int target) {

			int y = matrix.length;
			int x = matrix[0].length;

			int s = 0;
			int e = y * x - 1;

			while (s <= e) {
				int mid = (s + e) / 2;

				int val = matrix[mid / x][mid % x];

				if (val == target) return true;
				if (val < target) {
					s = mid + 1;
				}

				if (val > target) {
					e = mid -1;
				}
			}

			return false;
		}
	}
}
