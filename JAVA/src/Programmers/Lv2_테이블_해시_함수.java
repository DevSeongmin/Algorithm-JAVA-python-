package Programmers;

import java.util.Arrays;

public class Lv2_테이블_해시_함수 {

	class Solution {
		public int solution(int[][] data, int col, int row_begin, int row_end) {
			int Y = data.length;
			int X = data[0].length;

			Arrays.sort(data, (a, b) -> a[col-1] == b[col-1] ? Integer.compare(b[0], a[0]) : Integer.compare(a[col-1], b[col-1]));

			int answer = 0;
			for (int i = row_begin - 1; i <= row_end - 1; i++) {
				int tmp = 0;
				for (int j = 0; j < X; j++) {
					tmp += (data[i][j] % (i+1));
				}
				answer ^= tmp;
			}

			return answer;
		}
	}
}
