package leet_code.medium;

import java.util.LinkedList;
import java.util.List;

public class _22_Generate_Parentheses {
	class Solution {
		public List<String> generateParenthesis(int n) {
			List<String> answer = new LinkedList<>();

			match(new StringBuilder(), n, n, 0, answer);

			return answer;
		}

		void match(StringBuilder sb, int open, int close, int depth, List<String> answer) {
			if (open == 0 && close == 0) {
				answer.add(sb.toString());
				return;
			}

			if (open > 0) {
				sb.append('(');
				match(sb, open-1, close, depth+1, answer);
				sb.deleteCharAt(sb.length() -1);
			}

			if (open < close) {
				sb.append(')');
				match(sb, open, close-1, depth+1, answer);
				sb.deleteCharAt(sb.length() -1);
			}
		}
	}
}
