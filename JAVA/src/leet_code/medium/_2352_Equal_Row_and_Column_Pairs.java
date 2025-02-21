package leet_code.medium;

import java.util.HashMap;

public class _2352_Equal_Row_and_Column_Pairs {
	class Solution {
		public int equalPairs(int[][] grid) {
			int Y = grid.length;
			int X = grid.length;

			HashMap<String, Integer> xMap = new HashMap();

			for (int i = 0; i < Y; i++) {
				String key = "";
				for (int j = 0; j < X; j++) {
					key += grid[i][j] + " ";
				}
				xMap.put(key, xMap.getOrDefault(key, 0) + 1);
			}

			int answer = 0;

			for (int i = 0; i < Y; i++) {
				String key = "";
				for (int j = 0; j < X; j++) {
					key += grid[j][i] + " ";
				}
				answer += xMap.getOrDefault(key, 0);
			}
			return answer;
		}
	}
}
