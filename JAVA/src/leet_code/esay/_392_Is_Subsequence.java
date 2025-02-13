package leet_code.esay;

public class _392_Is_Subsequence {
	class Solution {
		public boolean isSubsequence(String s, String t) {
			int idx1 = 0;
			int idx2 = 0;

			char[] ss = s.toCharArray();
			char[] tt = t.toCharArray();

			if (idx1 == s.length()) return true;

			while (idx1 < s.length() && idx2 < t.length()) {
				if (ss[idx1] == tt[idx2]) {
					idx1++;
				}
				idx2++;
				if (idx1 == s.length()) return true;
			}
			return false;
		}
	}
}
