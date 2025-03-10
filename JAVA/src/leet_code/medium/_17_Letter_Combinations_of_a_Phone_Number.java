package leet_code.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _17_Letter_Combinations_of_a_Phone_Number {
	class Solution {
		static List<String> answer;
		static StringBuilder sb;
		static int l;
		static String digits;
		static HashMap<Character, String> MAP = new HashMap<>();
		static {
			MAP.put('2', "abc");
			MAP.put('3', "def");
			MAP.put('4', "ghi");
			MAP.put('5', "jkl");
			MAP.put('6', "mno");
			MAP.put('7', "pqrs");
			MAP.put('8', "tuv");
			MAP.put('9', "wxyz");
		}

		public List<String> letterCombinations(String digits) {
			answer = new ArrayList<>();
			sb = new StringBuilder();
			l = digits.length();
			Solution.digits = digits;

			combi(0);

			return answer;
		}
		static void combi(int depth) {

			if (depth == l && !sb.isEmpty()) {
				answer.add(sb.toString());
				return;
			}

			if (depth >= l) return;

			for (int i = 0; i < MAP.get(digits.charAt(depth)).length(); i++) {
				sb.append(MAP.get(digits.charAt(depth)).charAt(i));
				combi(depth+1);
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}

}
