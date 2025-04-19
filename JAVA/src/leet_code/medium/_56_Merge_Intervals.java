package leet_code.medium;

import java.util.ArrayList;
import java.util.Arrays;

public class _56_Merge_Intervals {
	class Solution {
		public int[][] merge(int[][] intervals) {
			ArrayList<int[]> answer = new ArrayList<>();

			Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));

			int[] front = intervals[0];

			for (int i = 1; i < intervals.length; i++) {
				int[] cur = intervals[i];

				if (front[1] >= cur[0]) {
					front[1] = Math.max(front[1], cur[1]);
				} else {
					answer.add(front);
					front = cur;
				}
			}

			answer.add(front);

			return answer.toArray(new int[answer.size()][]);
		}
	}
}
