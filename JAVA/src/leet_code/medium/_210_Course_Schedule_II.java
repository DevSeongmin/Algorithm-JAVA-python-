package leet_code.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _210_Course_Schedule_II {
	class Solution {
		public int[] findOrder(int numCourses, int[][] prerequisites) {

			ArrayList<Integer>[] graph = new ArrayList[numCourses];

			for (int i = 0; i < numCourses; i++) {
				graph[i] = new ArrayList<>();
			}

			int[] indegs = new int[numCourses];

			for (int[] prerequisite : prerequisites){
				int s = prerequisite[1];
				int e = prerequisite[0];
				graph[s].add(e);
				indegs[e]++;
			}

			Queue<Integer> q = new LinkedList<>();

			for (int i = 0; i < numCourses; i++) {
				if (indegs[i] == 0) q.add(i);
			}

			int[] answer = new int[numCourses];
			int cnt = 0;

			while (!q.isEmpty()) {
				int cur = q.poll();
				answer[cnt++] = cur;

				for (int next : graph[cur]) {
					indegs[next]--;

					if (indegs[next] == 0) {
						q.add(next);
					}
				}
			}

			if (cnt == numCourses) {
				return answer;
			} else {
				return new int[]{};
			}

		}
	}
}
