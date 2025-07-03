package Programmers.pccp모의고사._1회;

import java.util.ArrayList;

public class _2번_체육대회 {

	class Solution {

		static ArrayList<ArrayList<Integer>> order;
		static int[][] ability;
		static int answer = 0;

		public int solution(int[][] ability) {

			Solution.ability = ability;

			int student = ability.length;
			int game = ability[0].length;

			order = new ArrayList<>();
			choiceGame(0, game, new ArrayList<Integer>(), new boolean[game]);

			choiceStudent(0, 0, student, game, new ArrayList<>());

			return answer;
		}

		static void choiceStudent(int idx, int depth, int student, int game, ArrayList<Integer> arr) {
			if (depth == game) {

				for (ArrayList<Integer> o : order) {
					int val = 0;
					for (int i = 0; i < o.size(); i++) {
						val += ability[arr.get(i)][o.get(i)];
					}
					answer = Math.max(answer, val);
				}

				return;
			}

			for (int i = idx; i < student; i++) {
				arr.add(i);
				choiceStudent(i + 1, depth + 1, student, game, arr);
				arr.remove(arr.size() -1);
			}
		}

		static void choiceGame(int depth, int game, ArrayList<Integer> arr, boolean[] visited) {
			if (depth == game) {
				order.add(new ArrayList<>(arr));
				return;
			}

			for (int i = 0; i < game; i++) {
				if (visited[i]) continue;

				visited[i] = true;
				arr.add(i);
				choiceGame(depth+1, game, arr, visited);
				visited[i] = false;
				arr.remove(arr.size() - 1);
			}
		}
	}
}
