package leet_code.esay;

import java.util.HashMap;

public class _1207_Unique_Number_of_Occurrences {
	class Solution {
		public boolean uniqueOccurrences(int[] arr) {
			HashMap<Integer, Integer> map = new HashMap();

			for (int num : arr) {
				map.put(num, map.getOrDefault(num, 0) + 1);
			}

			int[] check = new int[1001];
			for (int val : map.values()) {
				if (check[val] == 1) return false;
				check[val] = 1;
			}

			return true;
		}
	}
}
