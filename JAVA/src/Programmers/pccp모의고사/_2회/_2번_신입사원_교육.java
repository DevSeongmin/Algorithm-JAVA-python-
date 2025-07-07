package Programmers.pccp모의고사._2회;

import java.util.PriorityQueue;

public class _2번_신입사원_교육 {
	class Solution {
		public int solution(int[] ability, int number) {
			PriorityQueue<Integer> pq = new PriorityQueue<>();

			for (int a : ability){
				pq.add(a);
			}

			for (int i = 0; i < number; i++) {
				int a = pq.poll();
				int b = pq.poll();

				pq.add(a + b);
				pq.add(a + b);
			}

			int answer = 0;

			while (!pq.isEmpty()) {
				answer+=pq.poll();
			}

			return answer;
		}
	}
}
