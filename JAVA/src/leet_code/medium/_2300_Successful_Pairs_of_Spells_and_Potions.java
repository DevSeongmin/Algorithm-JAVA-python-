package leet_code.medium;

import java.util.Arrays;

public class _2300_Successful_Pairs_of_Spells_and_Potions {
	class Solution {
		public int[] successfulPairs(int[] spells, int[] potions, long success) {
			Arrays.sort(potions);
			int[] answer = new int[spells.length];

			for (int i = 0; i < spells.length; i++) {
				int spell = spells[i];

				int left = 0;
				int right = potions.length - 1;

				while (left <= right) {
					int mid = (left + right) / 2;

					long value = (long) potions[mid] * spell;

					if (value >= success) {
						right = mid - 1;
					} else {
						left = mid + 1;
					}
				}
				answer[i] = potions.length - left;
			}

			return answer;
		}
	}
}
