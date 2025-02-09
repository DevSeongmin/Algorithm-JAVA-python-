package leet_code.esay;

public class _605_Can_Place_Flowers {
	class Solution {
		public boolean canPlaceFlowers(int[] flowerbed, int n) {
			int l = flowerbed.length;
			int cnt = 0;
			for(int i = 0; i < l; i++) {
				int left = 0;
				int mid = 0;
				int right = 0;

				if (0 <= i-1 && i-1 < l) {
					left = flowerbed[i-1];
				}

				if (0 <= i+1 && i+1 < l) {
					right = flowerbed[i+1];
				}

				mid = flowerbed[i];

				if (left == 0 && mid == 0 && right == 0) {
					flowerbed[i] = 1;
					cnt++;
				}
			}

			return n <= cnt;
		}
	}
}
