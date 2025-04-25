package leet_code.medium;

import java.util.ArrayList;
import java.util.List;

public class _57_Insert_Interval {

	class My_Solution {
		public int[][] insert(int[][] intervals, int[] newInterval) {

			ArrayList<int[]> list = new ArrayList<>();

			int insertIdx = insertIdx(intervals, newInterval);

			for (int i = 0; i < intervals.length; i++) {
				if (i ==insertIdx) {
					list.add(newInterval);
				}
				list.add(intervals[i]);
			}

			if (intervals.length == insertIdx) {
				list.add(newInterval);
			}

			for (int i = list.size() - 2; i >= 0; i--) {
				int[] left = list.get(i);
				int[] right = list.get(i+1);

				if (isDuplicate(left, right)) {
					list.set(i, new int[] {Math.min(left[0], right[0]), Math.max(left[1], right[1])});
					list.remove(i+1);
				}
			}

			int[][] answer=  new int[list.size()][2];

			for (int i = 0; i < list.size(); i++) {
				answer[i] = list.get(i);
			}

			return answer;
		}

		static boolean isDuplicate(int[] a, int[] b) {
			return (a[0] <= b[0] && b[0] <= a[1])
				|| (a[0] <= b[1] && b[1] <= a[1])
				|| (b[0] <= a[0] && a[0] <= b[1])
				|| (b[0] <= a[1] && a[1] <= b[1]);
		}

		static int insertIdx(int[][] intervals, int[] newInterval) {
			int target = newInterval[1];

			int left = 0;
			int right = intervals.length - 1;

			while (left <= right) {
				int mid = (left + right) / 2;

				if (intervals[mid][1] > target) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
			return left;
		}
	}


	class Solution {
		public int[][] insert(int[][] intervals, int[] newInterval) {
			List<int[]> merged = new ArrayList<>();

			for (int[] interval : intervals) {
				// 새 구간이 현재 구간보다 완전히 앞에 있는 경우
				if (newInterval[1] < interval[0]) {
					merged.add(newInterval);
					newInterval = interval;
				}
				// 새 구간이 현재 구간보다 완전히 뒤에 있는 경우
				else if (newInterval[0] > interval[1]) {
					merged.add(interval);
				}
				// 겹치는 경우: 병합
				else {
					newInterval[0] = Math.min(newInterval[0], interval[0]);
					newInterval[1] = Math.max(newInterval[1], interval[1]);
				}
			}

			// 마지막 병합된 구간 추가
			merged.add(newInterval);

			return merged.toArray(new int[merged.size()][]);
		}
	}

}
