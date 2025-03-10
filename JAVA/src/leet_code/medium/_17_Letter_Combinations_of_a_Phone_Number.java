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
		static HashMap<Character, String> map = new HashMap<>();
		static {
			map.put('2', "abc");
			map.put('3', "def");
			map.put('4', "ghi");
			map.put('5', "jkl");
			map.put('6', "mno");
			map.put('7', "pqrs");
			map.put('8', "tuv");
			map.put('9', "wxyz");
		}

		public List<String> letterCombinations(String digits) {
			answer = new ArrayList<>();
			sb = new StringBuilder();
			l = digits.length();
			this.digits = digits;

			combi(0);

			return answer;
		}
		static void combi(int depth) {

			if (depth == l && !sb.toString().equals("")) {
				answer.add(sb.toString());
				return;
			}

			if (depth >= l) return;

			for (int i = 0; i < map.get(digits.charAt(depth)).length(); i++) {
				sb.append(map.get(digits.charAt(depth)).charAt(i));
				combi(depth+1);
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}
}
