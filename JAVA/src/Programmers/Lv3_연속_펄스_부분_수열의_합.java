package Programmers;

public class Lv3_연속_펄스_부분_수열의_합 {
	class Solution {
		public long solution(int[] sequence) {
			int N = sequence.length;

			long[] plusFirstSeq = new long[N];
			long[] minusFirstSeq = new long[N];

			for (int i = 0; i < N; i++) {
				if (i % 2 == 0) {
					plusFirstSeq[i] = sequence[i];
					minusFirstSeq[i] = -sequence[i];
				} else {
					plusFirstSeq[i] = -sequence[i];
					minusFirstSeq[i] = sequence[i];
				}
			}

			long[] plusFirstDP = new long[N];
			long[] minusFirstDP = new long[N];
			plusFirstDP[0] = plusFirstSeq[0];
			minusFirstDP[0] = minusFirstSeq[0];

			long answer = Math.max(plusFirstDP[0],  minusFirstDP[0]);

			for (int i = 1; i< N; i++)  {
				plusFirstDP[i] =  Math.max(plusFirstSeq[i], plusFirstDP[i-1] + plusFirstSeq[i]);
				minusFirstDP[i] =  Math.max(minusFirstSeq[i], minusFirstDP[i-1] + minusFirstSeq[i]);
				answer = Math.max(answer,  Math.max(plusFirstDP[i], minusFirstDP[i]));
			}

			return answer;
		}
	}
}
