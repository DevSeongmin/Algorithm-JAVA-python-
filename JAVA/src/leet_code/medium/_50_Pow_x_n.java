package leet_code.medium;

public class _50_Pow_x_n {
	class Solution {
		public double myPow(double x, int n) {

			return n >= 0 ? pow(x, n) : 1 / pow(x, n);
		}

		static double pow(double x, int n) {
			if (n == 0) return 1;
			if (n == 1) return x;


			double tmpPow =  pow(x, n/2);
			if (n % 2 == 0) {
				return tmpPow * tmpPow;
			} else {
				return tmpPow * tmpPow * x;
			}
		}
	}
}
