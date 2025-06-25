package Programmers;

public class Lv2_두_원_사이의_정수_쌍 {
	class Solution {
		public long solution(int r1, int r2) {
			long answer = 0;

			int out = Math.max(r1, r2);
			int in = Math.min(r1, r2);

			for (int i = 0; i <= out; i++) {
				double outX = Math.sqrt((long) r2 * r2 - (long) i * i);
				double inX = Math.sqrt((long) r1 * r1 - (long) i * i);
				inX = Double.isNaN(inX) ? 0.0 : inX;

				outX = Math.floor(outX);
				inX = Math.ceil(inX);

				answer += (long) (outX - inX + 1);
			}

			return answer * 4 - (out - in + 1) * 4L;
		}
	}
}
