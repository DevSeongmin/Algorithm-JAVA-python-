package Programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Lv3_여행경로 {

	class Solution {

		static HashMap<String, ArrayList<String>> graph = new HashMap();
		static HashSet<String> visited = new HashSet();
		static ArrayList<String> answer = new ArrayList();
		static ArrayList<String> finalAnswer;

		static int allPathCnt;
		static boolean flag;

		public String[] solution(String[][] tickets) {

			allPathCnt = tickets.length + 1;

			for (String[] edge : tickets) {
				String city1 = edge[0];
				String city2 = edge[1];

				if (graph.containsKey(city1)) {
					graph.get(city1).add(city2);
					if (!graph.containsKey(city2)) {
						graph.put(city2, new ArrayList());
					}
					continue;
				}

				graph.put(city1, new ArrayList());

				if (!graph.containsKey(city2)) {
					graph.put(city2, new ArrayList());
				}
				graph.get(city1).add(city2);
			}

			for (String key : graph.keySet()) {
				Collections.sort(graph.get(key));
			}

			dfs("ICN");

			return finalAnswer.stream().toArray(String[]::new);
		}

		public static void dfs(String node) {

			answer.add(node);

			if (answer.size() == allPathCnt && finalAnswer == null) {
				finalAnswer = new ArrayList(answer);
			}

			for (int i = 0; i < graph.get(node).size(); i++) {
				String nextNode = graph.get(node).get(i);
				String visitedKey = node + nextNode + i;

				if (visited.contains(visitedKey))
					continue;

				visited.add(visitedKey);
				dfs(nextNode);
				visited.remove(visitedKey);
			}
			answer.remove(answer.size() - 1);
		}
	}
}
