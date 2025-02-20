package leet_code.medium;

import java.util.HashMap;

public class _1657_Determine_if_Two_Strings_Are_Close {
	class Solution {
		public boolean closeStrings(String word1, String word2) {
			HashMap<Character, Integer> map1 = new HashMap();
			HashMap<Character, Integer> map2 = new HashMap();

			char[] charArr1 = word1.toCharArray();
			char[] charArr2 = word2.toCharArray();

			for (char c : charArr1) {
				map1.put(c, map1.getOrDefault(c, 0) + 1);
			}

			for (char c : charArr2) {
				map2.put(c, map2.getOrDefault(c, 0) + 1);
			}

			if (!(map1.keySet().equals(map2.keySet()))) return false;

			HashMap<Integer, Integer> check = new HashMap();

			for (int val : map1.values()) {
				check.put(val, check.getOrDefault(val , 0) + 1);
			}

			for (int val : map2.values()) {
				check.put(val, check.getOrDefault(val , 0) - 1);
			}

			for (int val : check.values()) {
				if (val != 0) return false;
			}

			return true;
		}
	}
}
