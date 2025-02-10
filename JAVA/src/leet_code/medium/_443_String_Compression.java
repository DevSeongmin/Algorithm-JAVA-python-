package leet_code.medium;

public class _443_String_Compression {
	class Solution {
		public int compress(char[] chars) {

			char curC = chars[0];
			int cnt = 0;

			StringBuilder answer = new StringBuilder();

			for (char c : chars) {
				if (curC == c) {
					cnt++;
					continue;
				}

				answer.append(curC);
				if (cnt > 1) {
					answer.append(""+cnt);
				}

				curC = c;
				cnt = 1;
			}

			answer.append(curC);
			if (cnt > 1) {
				answer.append(""+cnt);
			}

			for (int i = 0; i < answer.length(); i++) {
				chars[i] = answer.charAt(i);
			}

			return answer.length();
		}
	}
}
