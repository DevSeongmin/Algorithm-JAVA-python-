package leet_code.medium;

import java.util.LinkedList;
import java.util.List;

public class _46_Permutations {
	class Solution {
		public List<List<Integer>> permute(int[] nums) {
			List<List<Integer>> answer = new LinkedList<>();
			int l = nums.length;
			List<Integer> tmp = new LinkedList<>();
			boolean[] visited = new boolean[l];

			permu(0, nums, visited, tmp, answer);

			return answer;
		}

		void permu(int depth, int[] nums, boolean[] visited, List<Integer> tmp, List<List<Integer>> answer){
			if (depth == nums.length) {
				answer.add(new LinkedList(tmp));
				return;
			}

			for (int i = 0; i < nums.length; i++) {
				if (visited[i]) continue;

				visited[i] = true;
				tmp.add(nums[i]);
				permu(depth + 1, nums, visited, tmp, answer);

				visited[i] = false;
				tmp.remove(tmp.size() - 1);
			}
		}
	}
}
