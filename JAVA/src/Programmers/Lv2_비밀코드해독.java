package Programmers;

import java.util.HashSet;

public class Lv2_비밀코드해독 {

	class Solution {
		public int solution(int n, int[][] qs, int[] ans) {

			return combi(1, 0, n, new HashSet<>(), qs, ans);
		}

		boolean isCollect(HashSet<Integer> seleted, int[][] qs, int[] ans) {

			for (int i = 0; i < qs.length; i++) {
				int count = 0;
				int[] q = qs[i];

				for (int num : q) {
					if (seleted.contains(num)) count++;
				}

				if (count != ans[i]) return false;
			}

			return true;
		}


		int combi(int idx, int depth, int n, HashSet<Integer> seleted, int[][] qs, int[] ans) {
			int answer = 0;

			if (depth == 5) {
				if (isCollect(seleted, qs, ans)) return 1;
				return 0;
			}

			for (int i = idx; i <= n; i++) {
				seleted.add(i);
				answer += combi(i + 1, depth+1, n, seleted, qs, ans);
				seleted.remove(i);
			}

			return answer;
		}
	}
}
