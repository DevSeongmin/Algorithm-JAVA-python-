package Programmers;

public class Lv2_시소짝꿍 {
	class Solution {
		public long solution(int[] weights) {

			long answer = 0;
			long[] save = new long[2_002];

			for (int w : weights) {
				save[w]++;
			}

			for (int i = 100; i <= 1_000; i++) {
				if (save[i] > 1) {
					answer += (save[i] * (save[i] - 1)) / 2;
				}
			}

			for (int i = 100; i <= 1_000; i++) {

				if (save[i] == 0) {
					continue;
				}

				if (save[i * 2] > 0) {
					answer += save[i] * save[i * 2];
				}

				if (i % 2 == 0 && save[i / 2 * 3] > 0) {
					answer += save[i] * save[i / 2 * 3];
				}

				if (i % 3 == 0 && save[i / 3 * 4] > 0) {
					answer += save[i] * save[i / 3 * 4];
				}

			}

			return answer;
		}
	}
}
