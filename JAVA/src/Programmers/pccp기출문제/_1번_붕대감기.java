package Programmers.pccp기출문제;

public class _1번_붕대감기 {
	class Solution {
		static int CASTING_TIME;
		static int SEC_PER_HEAL;
		static int ADDITIONAL_HEAL;
		static int MAX_HEALTH;

		public int solution(int[] bandage, int health, int[][] attacks) {
			CASTING_TIME = bandage[0];
			SEC_PER_HEAL = bandage[1];
			ADDITIONAL_HEAL = bandage[2];
			MAX_HEALTH = health;

			int time = 0;
			for (int[] attack : attacks) {
				int sec = attack[0];
				int damage = attack[1];

				int bandageTime = sec - time - 1;

				health = Math.min(MAX_HEALTH, health + bandageTime * SEC_PER_HEAL);
				health = Math.min(MAX_HEALTH, health + (bandageTime / CASTING_TIME * ADDITIONAL_HEAL));

				health -= damage;
				if (health <= 0) return -1;

				time = sec;
			}

			return health;
		}
	}
}
