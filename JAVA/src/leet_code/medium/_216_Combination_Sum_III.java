package leet_code.medium;

import java.util.ArrayList;
import java.util.List;

public class _216_Combination_Sum_III {
	class Solution {
		static int n, k;
		static List<Integer> arr;
		static List<List<Integer>> answer;

		public List<List<Integer>> combinationSum3(int k, int n) {
			this.n = n;
			this.k = k;

			arr = new ArrayList<>();
			answer = new ArrayList<>();

			combination(1, 0, 0);

			return answer;
		}

		static void combination(int idx, int depth, int value) {
			if (value > n) return;
			if (depth > k) return;

			if (depth == k && value == n) {
				answer.add(new ArrayList<>(arr));
				return;
			}

			for (int i = idx; i < 10; i++) {
				arr.add(i);
				combination(i+1, depth + 1, value + i);
				arr.remove(arr.size() - 1);
			}
		}
	}
}
