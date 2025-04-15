package leet_code.medium;

import java.util.LinkedList;
import java.util.List;

public class _39_Combination_Sum {
	class Solution {
		public List<List<Integer>> combinationSum(int[] candidates, int target) {

			List<List<Integer>> answer = new LinkedList<>();

			product(0, 0, candidates, target, new LinkedList<>(), answer);

			return answer;
		}

		static void product(int idx, int value, int[] candidates, int target, List<Integer> arr, List<List<Integer>> answer) {
			if (value > target) {
				return;
			}

			if (value == target) {
				answer.add(new LinkedList<>(arr));
				return;
			}

			for (int i = idx; i < candidates.length; i++) {
				arr.add(candidates[i]);
				product(i, value+candidates[i], candidates, target, arr, answer);
				arr.remove(arr.size()-1);
			}
		}
	}
}
