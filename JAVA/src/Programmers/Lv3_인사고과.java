package Programmers;

import java.util.Arrays;

public class Lv3_인사고과 {
	class Solution {
		public int solution(int[][] scores) {

			int answer = 0;
			int N = scores.length;

			int[] wanho = new int[] {scores[0][0], scores[0][1]};
			int wanhoScore = wanho[0] + wanho[1];

			Arrays.sort(scores, (a, b) -> b[0] == a[0] ? a[1] - b[1] : b[0] - a[0]);

			int maxVal = scores[0][1];

			for (int i = 1; i < N; i++) {
				if (wanho[0] < scores[i][0] && wanho[1] < scores[i][1]) {
					return -1;
				}
				if (scores[i][1] < maxVal) {
					scores[i][0] = -1;
					scores[i][1] = -1;
				}
				maxVal = Math.max(maxVal, scores[i][1]);
			}

			for (int i = 0; i < N; i++) {

				if (scores[i][0] + scores[i][1] > wanhoScore) {
					answer++;
				}
			}

			return answer + 1;
		}
	}
}
