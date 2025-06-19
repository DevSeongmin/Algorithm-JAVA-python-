package leet_code.medium;

public class _201_Bitwise_AND_of_Numbers_Range {
	class Solution {
		public int rangeBitwiseAnd(int left, int right) {
			int cnt = 0;
			while (left != right) {
				cnt++;
				left >>= 1;
				right >>= 1;
			}
			return left << cnt;
		}
	}
}
