package Programmers;

import java.util.ArrayList;

public class Lv2_우박수열_정적분 {

	class Solution {
		public double[] solution(int k, int[][] ranges) {
			double[] answer = new double[ranges.length];

			ArrayList<Integer> arr = new ArrayList<>();

			arr.add(k);

			while (k != 1) {
				k = k % 2 == 0 ? k/2 : k*3+1;
				arr.add(k);
			}

			ArrayList<Double> prefixSum = new ArrayList<>();
			prefixSum.add(0.0);

			for (int i = 1; i < arr.size(); i++) {
				double big = arr.get(i-1);
				double small = arr.get(i);

				if (small > big) {
					double tmp = big;
					big = small;
					small = tmp;
				}

				double sum = small + (big - small) / 2;

				prefixSum.add(prefixSum.get(prefixSum.size()-1) + sum);
			}

			int cnt = 0;
			for (int[] range : ranges) {
				int s = range[0];
				int e = arr.size() + range[1];

				if (s >= e) {
					answer[cnt++] = -1;
					continue;
				}

				answer[cnt++] = prefixSum.get(e-1) - prefixSum.get(s);
			}

			return answer;
		}
	}
}
