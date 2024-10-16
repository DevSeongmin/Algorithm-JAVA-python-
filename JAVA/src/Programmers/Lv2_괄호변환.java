package Programmers;

public class Lv2_괄호변환 {
	class Solution {
		public String solution(String p) {
			if (p.equals(""))
				return p;

			String[] seperates = seperate(p);

			String u = seperates[0];
			String v = seperates[1];

			if (isComplete(u)) {
				return u + solution(v);
			}

			return "(" + solution(v) + ")" + convert4_4(u);
		}

		public String convert4_4(String u) {
			StringBuilder newString = new StringBuilder();

			for (int i = 1; i < u.length() - 1; i++) {
				newString.append(reverse(u.charAt(i)));
			}
			return newString.toString();
		}

		public String[] seperate(String p) {
			int checker = 0;
			boolean isSeperate = false;
			int seperate = 0;

			for (int i = 0; i < p.length(); i++) {
				char c = p.charAt(i);

				if (c == '(') {
					checker++;
				}
				if (c == ')') {
					checker--;
				}

				if (checker == 0 && i != 0) {
					seperate = i;
					break;
				}
			}

			String u = p.substring(0, seperate + 1);
			String v = p.substring(seperate + 1, p.length());
			return new String[] {u, v};
		}

		public char reverse(char c) {
			if (c == '(')
				return ')';
			return '(';
		}

		public boolean isComplete(String s) {
			int checker = 0;

			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);

				if (c == '(') {
					checker++;
				} else {
					checker--;
				}

				if (checker < 0)
					return false;
			}

			if (checker != 0) {
				return false;
			}

			return true;
		}
	}
}
