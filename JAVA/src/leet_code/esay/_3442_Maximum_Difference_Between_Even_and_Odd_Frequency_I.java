package leet_code.esay;

import java.util.HashMap;

public class _3442_Maximum_Difference_Between_Even_and_Odd_Frequency_I {
	class Solution {
		public int maxDifference(String s) {

			HashMap<Character, Integer> map = new HashMap();

			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				map.put(c, map.getOrDefault(c, 0) + 1);
			}

			System.out.println(map);

			int odd = 0;
			int even = Integer.MAX_VALUE;

			for (char c : map.keySet()){
				int freq = map.get(c);
				if (freq % 2 == 1) {
					odd = Math.max(odd, freq);
				} else {
					even = Math.min(even, freq);
				}
			}

			return odd - even;
		}
	}
}
