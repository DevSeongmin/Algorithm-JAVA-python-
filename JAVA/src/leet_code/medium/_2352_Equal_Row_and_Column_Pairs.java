package leet_code.medium;

import java.util.HashMap;

public class _2352_Equal_Row_and_Column_Pairs {
	class Solution {
		public int equalPairs(int[][] grid) {
			int Y = grid.length;
			int X = grid.length;

			HashMap<String, Integer> xMap = new HashMap();

			for (int i = 0; i < Y; i++) {
				StringBuilder key = new StringBuilder();
				for (int j = 0; j < X; j++) {
					key.append(grid[i][j]);
					key.append(" ");
				}
				xMap.put(key.toString(), xMap.getOrDefault(key.toString(), 0) + 1);
			}

			int answer = 0;

			for (int i = 0; i < Y; i++) {
				StringBuilder key = new StringBuilder();
				for (int j = 0; j < X; j++) {
					key.append(grid[j][i]);
					key.append(" ");
				}
				answer += xMap.getOrDefault(key.toString(), 0);
			}
			return answer;
		}
	}
}
