package leet_code.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


class Pair {
	String node;
	double dist;

	public Pair(String node, double dist) {
		this.node = node;
		this.dist = dist;
	}
}


public class _399_Evaluate_Division {

	class Solution {
		static HashMap<String, ArrayList<Pair>> graph;
		static HashSet<String> visited;
		public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
			graph = new HashMap<>();

			for (int i = 0; i < equations.size(); i++) {
				String s = equations.get(i).get(0);
				String e = equations.get(i).get(1);

				if (!graph.containsKey(s)) {
					graph.put(s, new ArrayList<Pair>());
				}

				graph.get(s).add(new Pair(e, values[i]));


				if (!graph.containsKey(e)) {
					graph.put(e, new ArrayList<Pair>());
				}

				graph.get(e).add(new Pair(s, 1/values[i]));

			}

			double[] answer = new double[queries.size()];

			for (int i = 0; i < queries.size(); i++) {
				String s = queries.get(i).get(0);
				String e = queries.get(i).get(1);

				if (!graph.containsKey(s) || !graph.containsKey(e)) {
					answer[i] = -1;
					continue;
				}

				visited = new HashSet<>();

				answer[i] = dfs(s, e, 1);
			}
			return answer;
		}

		static double dfs(String s, String e, double value) {
			visited.add(s);
			if (s.equals(e)) return value;

			for (Pair pair : graph.get(s)) {

				if (!visited.contains(pair.node)) {
					double result = dfs(pair.node, e, value * pair.dist);
					if (result != -1) return result;
				}
			}

			return -1;
		}
	}
}
