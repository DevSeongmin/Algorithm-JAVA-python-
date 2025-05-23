package leet_code.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class _433_Minimum_Genetic_Mutation {
	class Solution {

		char[] genes = {'A', 'C', 'G', 'T'};

		public int minMutation(String startGene, String endGene, String[] bank) {

			Queue<String> q = new LinkedList<>();
			HashSet<String> visited = new HashSet<>();
			HashSet<String> bankSet = new HashSet<>(Arrays.asList(bank));

			visited.add(startGene);
			q.add(startGene);

			int cnt = 0;
			while (!q.isEmpty()) {
				int qSize = q.size();
				for (int tmp = 0; tmp < qSize; tmp++) {

					String cur = q.poll();
					if (cur.equals(endGene)) return cnt;

					for (int i = 0; i < 8; i++) {
						for (int j = 0; j < 4; j++) {
							StringBuilder nGene = new StringBuilder(cur);
							nGene.setCharAt(i, genes[j]);

							if (visited.contains(nGene.toString())) continue;
							if (!bankSet.contains(nGene.toString())) continue;

							q.add(nGene.toString());
							visited.add(nGene.toString());
						}
					}
				}
				cnt++;
			}
			return -1;
		}
	}
}
