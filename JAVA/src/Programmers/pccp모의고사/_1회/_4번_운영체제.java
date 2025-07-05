package Programmers.pccp모의고사._1회;

import java.util.PriorityQueue;

public class _4번_운영체제 {

	class Solution {
		public long[] solution(int[][] program) {

			long[] answer = new long[11];

			PriorityQueue<int[]> timeQ = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

			PriorityQueue<int[]> jobQ = new PriorityQueue<>((a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1],b[1]));

			for (int[] p : program) {
				timeQ.add(p);
			}

			long time = 0L;

			while (!timeQ.isEmpty() || !jobQ.isEmpty()) {

				while (!timeQ.isEmpty() && timeQ.peek()[1] <= time) {
					jobQ.add(timeQ.poll());
				}

				if (jobQ.isEmpty()) {
					time = timeQ.peek()[1];
					continue;
				}

				int[] p = jobQ.poll();

				int score = p[0];
				int callTime = p[1];
				int runningTime = p[2];

				answer[score] += (time - callTime);
				time += runningTime;
			}

			answer[0] = time;

			return answer;
		}
	}
}
