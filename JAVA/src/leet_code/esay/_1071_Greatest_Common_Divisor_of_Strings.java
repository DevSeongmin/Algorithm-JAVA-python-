package leet_code.esay;

public class _1071_Greatest_Common_Divisor_of_Strings {
	class Solution {
		public String gcdOfStrings(String str1, String str2) {
			if (!(str1 + str2).equals(str2 + str1))
				return "";

			int gcd_val = gcd(str1.length(), str2.length());

			return str1.substring(0, gcd_val);
		}

		static int gcd(int a, int b) {
			return b == 0 ? a : gcd(b, a%b);
		}
	}
}
