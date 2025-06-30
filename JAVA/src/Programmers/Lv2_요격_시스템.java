package Programmers;

import java.util.Arrays;

public class Lv2_요격_시스템 {
	class Solution {
		public int solution(int[][] targets) {
			Arrays.sort(targets, (a, b) -> Integer.compare(a[1], b[1]));

			int answer = 1;
			int shoot = targets[0][1];

			for (int i = 1; i < targets.length; i++) {
				int[] target = targets[i];

				if (target[0] >= shoot) {
					answer++;
					shoot = target[1];
				}
			}
			return answer;
		}
	}
}
