package Programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Lv2_후보키 {

	class Solution {
		public int solution(String[][] relation) {
			int answer = 0;

			int Y = relation.length;
			int X = relation[0].length;

			List<List<Integer>> candidates = new ArrayList<>();

			setCombi(0, X, candidates, new ArrayList<>());
			candidates.sort(
				(a, b) -> Integer.compare(a.size(), b.size())
			);

			HashSet<String> completeSet = new HashSet<>();

			for (List<Integer> candidate : candidates) {

				HashSet<String> check = new HashSet<>();

				boolean isDuplicated = false;
				for (String[] row : relation) {
					String checkKey = makeUniqueKey(row, candidate);

					if (!check.contains(checkKey)) {
						check.add(checkKey);
					} else {
						isDuplicated = true;
						break;
					}
				}

				if (!isDuplicated) {

					String candidateKey = makeCandidateKey(candidate);

					if (checkMinimul(completeSet, candidateKey)) {
						completeSet.add(candidateKey);
						answer++;
					}
				}
			}

			return answer;
		}

		static boolean checkMinimul(HashSet<String> completeSet, String candidateKey) {


			for (String completeKey : completeSet) {
				boolean flag = true;

				for (String s : completeKey.split(" ")) {
					if (!candidateKey.contains(s)) {
						flag = false;
					}
				}
				if (flag) return false;
			}

			return true;
		}

		static String makeCandidateKey(List<Integer> candidate) {
			String result = candidate.get(0) + "";

			for (int i = 1; i < candidate.size(); i++) {
				result += " " + candidate.get(i);
			}
			return result;
		}

		static String makeUniqueKey(String[] row, List<Integer> candidate) {
			String result = row[candidate.get(0)];

			for (int i = 1; i < candidate.size(); i++) {
				result += " " + row[candidate.get(i)];
			}

			return result;
		}


		static void setCombi(int depth, int X, List<List<Integer>> candidates, ArrayList<Integer> selectors) {

			if (depth >= X) {
				if (!selectors.isEmpty()) {
					candidates.add(new ArrayList<>(selectors));
				}
				return;
			}

			setCombi(depth + 1, X, candidates, new ArrayList<>(selectors));
			selectors.add(depth);
			setCombi(depth + 1, X, candidates, new ArrayList<>(selectors));
		}
	}
}
