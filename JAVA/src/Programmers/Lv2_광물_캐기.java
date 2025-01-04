package Programmers;

import java.util.HashMap;

public class Lv2_광물_캐기 {
	class Solution {

		static int answer = Integer.MAX_VALUE;
		static int[] picks;
		static String[] pickNames = {"diamond", "iron", "stone"};
		static String[] minerals;
		static int N;
		static HashMap<String, Integer> map = new HashMap();
		static {
			map.put("diamond diamond", 1);
			map.put("diamond iron", 1);
			map.put("diamond stone", 1);
			map.put("iron diamond", 5);
			map.put("iron iron", 1);
			map.put("iron stone", 1);
			map.put("stone diamond", 25);
			map.put("stone iron", 5);
			map.put("stone stone", 1);

		}

		public int solution(int[] picks, String[] minerals) {
			this.N = minerals.length;
			this.picks = picks;
			this.minerals = minerals;

			simul(0, "", 0, 0);

			return answer;
		}

		static void simul(int depth, String curPick, int durability, int value) {
			if (answer  < value) {
				return;
			}

			if (picks[0] == 0 && picks[1] == 0 && picks[2] == 0 && durability == 0){
				answer = Math.min(answer, value);
				return;
			}

			if (depth >= N) {
				answer = Math.min(answer, value);
				return;
			}

			if (durability > 0) {
				simul(depth + 1,
					curPick,
					durability - 1,
					value + map.get(curPick +  " " + minerals[depth] ));
				return;
			}


			for (int i  = 0; i < 3; i++) {
				if (picks[i]  <= 0) continue;

				picks[i]--;
				simul(depth, pickNames[i], 5, value);
				picks[i]++;
			}
		}

	}
}
