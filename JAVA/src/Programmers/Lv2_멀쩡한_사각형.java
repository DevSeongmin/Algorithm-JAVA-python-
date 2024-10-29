package Programmers;

public class Lv2_멀쩡한_사각형 {

	class Solution {
		public long solution(int w, int h) {
			long big = Math.max(w,h);
			long small = Math.min(w,h);


			return big * small - (big+small - gcd(big, small));
		}


		public long gcd(long a, long b){
			if (b  == 0 ) return a;


			return gcd(b, a%b);

		}
	}
}
