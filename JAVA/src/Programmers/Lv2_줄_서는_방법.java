package Programmers;

import java.util.ArrayList;

public class Lv2_줄_서는_방법 {

	class Solution {
		public int[] solution(int n, long k) {

			ArrayList<Integer> arr = new ArrayList();
			ArrayList<Integer> answer = new ArrayList();

			for (int i = 1; i <= n; i++) {
				arr.add(i);
			}

			for (int i = n - 1; i > 0; i--) {
				long factorialNum = factorial(i);
				int idx = 0;

				while (k > factorialNum) {
					idx++;
					k -= factorialNum;
				}

				answer.add(arr.remove(idx));

				if (k == 0)
					break;
			}

			while (!arr.isEmpty()) {
				answer.add(arr.remove(arr.size() - 1));
			}

			int[] ans = new int[n];
			for (int i = 0; i < n; i++) {
				ans[i] = answer.get(i);
			}

			return ans;
		}

		public long factorial(long n) {
			if (n < 2)
				return 1;

			return n * factorial(n - 1);
		}
	}
}
