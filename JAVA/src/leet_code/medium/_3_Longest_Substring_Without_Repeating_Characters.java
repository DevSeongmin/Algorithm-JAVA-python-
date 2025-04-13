package leet_code.medium;

import java.util.HashMap;

public class _3_Longest_Substring_Without_Repeating_Characters {
	class Solution {
		public int lengthOfLongestSubstring(String s) {
			HashMap<Character, Boolean> map = new HashMap<>();

			int answer= 0;
			int left = 0;
			int right = 0;

			while (right < s.length()) {

				while (right < s.length() && !map.getOrDefault(s.charAt(right), false) ) {
					map.put(s.charAt(right++), true);
				}

				answer = Math.max(answer, right - left);

				if (s.length() == right) return answer;

				while (left < right && s.charAt(left) != s.charAt(right)) {
					map.put(s.charAt(left++), false);
				}
				map.put(s.charAt(left++), false);
			}

			return answer;
		}
	}
}
