package Programmers.pccp모의고사._1회;

public class _3번_유전법칙 {
	class Solution {
		public String[] solution(int[][] queries) {
			int l = queries.length;

			String[] answer = new String[l];

			for (int i = 0; i < l; i++) {
				int[] q = queries[i];

				int gen = q[0] - 1;
				int idx = q[1] - 1;

				answer[i] = getDna(gen, idx);
			}

			return answer;
		}

		static String getDna(int gen, int idx) {
			if (gen == 0) return "Rr";

			String parent = getDna(gen - 1, idx / 4);

			if (parent.equals("RR")) {
				return "RR";
			}
			if (parent.equals("rr")) {
				return "rr";
			}

			if (idx % 4 == 0) {
				return "RR";
			}
			if (idx % 4 == 3) {
				return "rr";
			}
			return "Rr";
		}
	}
}
