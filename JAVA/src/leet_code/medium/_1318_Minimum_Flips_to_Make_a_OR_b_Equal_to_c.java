package leet_code.medium;

public class _1318_Minimum_Flips_to_Make_a_OR_b_Equal_to_c {
	class Solution {
		public int minFlips(int a, int b, int c) {

			int cnt = 0;
			for (int i = 0; i < 30; i++) {
				if ((c & (1 << i)) > 0) {
					if ((a & (1 << i)) == 0 && (b & (1 << i)) == 0) {
						cnt++;
					}
				} else {
					if ((a & (1 << i)) > 0) {
						cnt++;
					}
					if ((b & (1 << i)) > 0){
						cnt++;
					}
				}
			}

			return cnt;
		}
	}
}
