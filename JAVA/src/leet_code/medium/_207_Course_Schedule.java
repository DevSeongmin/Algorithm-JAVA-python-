package leet_code.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _207_Course_Schedule {
	class Solution {
		public boolean canFinish(int numCourses, int[][] prerequisites) {

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

			while (!q.isEmpty()) {
				int cur = q.poll();

				for (int next : graph[cur]) {
					indegs[next]--;

					if (indegs[next] == 0) {
						q.add(next);
					}
				}
			}

			return Arrays.stream(indegs).allMatch(indeg -> indeg <= 0);
		}
	}
}
