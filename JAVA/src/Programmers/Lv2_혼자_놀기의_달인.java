package Programmers;

import java.util.*;

public class Lv2_혼자_놀기의_달인 {
	class Solution {
		public int solution(int[] cards) {

			for (int i = 0; i < cards.length; i++) {
				cards[i]-=1;
			}

			return choice(0, 0, cards, new ArrayList<>());
		}
		static int calValue(int s1, int s2, int[] cards) {
			boolean[] visited = new boolean[cards.length];
			int a = bfs(s1, cards, visited);
			int b = bfs(s2, cards, visited);

			return a * b;
		}

		static int bfs(int s, int[] cards, boolean[] visited) {
			if (visited[s]) return 0;

			Queue<Integer> q = new LinkedList<>();
			q.add(s);
			visited[s] = true;

			int cnt = 0;

			while (!q.isEmpty()) {
				int cur = q.poll();
				cnt++;

				int next = cards[cur];
				if (visited[next]) continue;

				visited[next] = true;
				q.add(next);
			}
			return cnt;
		}

		static int choice(int idx, int depth, int[] cards, ArrayList<Integer> arr) {
			if (depth == 2) {
				return calValue(arr.get(0), arr.get(1), cards);
			}

			int answer = 0;

			for (int i = idx; i < cards.length; i++) {
				arr.add(i);
				answer = Math.max(answer, choice(i+1, depth+1, cards, arr));
				arr.remove(arr.size() - 1);
			}
			return answer;
		}
	}
}
