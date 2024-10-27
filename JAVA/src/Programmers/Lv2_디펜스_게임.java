package Programmers;

import java.util.Collections;
import java.util.PriorityQueue;

public class Lv2_디펜스_게임 {

	class Solution {

		public int solution(int n, int k, int[] enemy) {

			PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
			int answer = 0;

			for (int i = 0; i < enemy.length; i++) {

				if (k <= 0 && n < enemy[i]) {
					break;
				}

				answer++;

				if (n >= enemy[i]) {
					n -= enemy[i];
					pq.add(enemy[i]);
					continue;
				}

				if (k > 0 && pq.size() == 0) {
					k -= 1;
					continue;
				}

				if (k > 0 && pq.peek() <= enemy[i]) {
					k -= 1;
					continue;
				}

				if (k > 0 && pq.peek() > enemy[i]) {
					pq.add(enemy[i]);
					n += (pq.poll() - enemy[i]);
					k--;
					continue;
				}
			}
			return answer;
		}
	}
}
