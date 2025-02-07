package leet_code.medium;

import java.util.HashMap;

public class _3443_Maximum_Manhattan_Distance_After_K_Changes {
	class Solution {
		static HashMap<Character, int[]> map = new HashMap();
		static{
			map.put('N', new int[] {-1, 0});
			map.put('S', new int[] {1, 0});
			map.put('E', new int[] {0, 1});
			map.put('W', new int[] {0, -1});
		}

		public int maxDistance(String s, int k) {
			int l = s.length();
			int[] delta= new int[l];

			int y = 0;
			int x = 0;
			int dist = 0;
			int minusCnt = 0;

			int answer = 0;
			int prefixSum = 0;

			for (int i = 0; i < l; i++) {
				char c = s.charAt(i);
				int[] dInfo = map.get(c);

				int ny = y + dInfo[0];
				int nx = x + dInfo[1];
				int ndist = Math.abs(ny) + Math.abs(nx);

				delta[i] = dist < ndist ? 1 : -1;
				if (delta[i] == -1) minusCnt++;

				prefixSum += delta[i];
				answer = Math.max(answer, prefixSum + Math.min(k, minusCnt) * 2);
				y = ny;
				x = nx;
				dist = ndist;
			}

			return answer;
		}

		static class Pair{
			int y, x, dist;
			public Pair(int y, int x, int dist) {
				this.y = y;
				this.x = x;
				this.dist = dist;
			}
		}
	}
}
