package Programmers.pccp모의고사._2회;

import java.util.ArrayList;

public class _3번_카페_확장 {
	class Solution {
		public int solution(int[] menu, int[] order, int k) {

			ArrayList<Event> arr = new ArrayList<>();

			int e = 0;
			for (int i = 0; i < order.length; i++) {

				int s  = Math.max(i * k, e);
				e = s + menu[order[i]];

				arr.add(new Event(1, i * k));
				arr.add(new Event(-1, e));
			}

			arr.sort((a, b) -> a.time == b.time ? Integer.compare(a.enter, b.enter) : Integer.compare(a.time, b.time));

			int answer = 0;
			int cnt = 0;
			for (Event event : arr) {
				cnt += event.enter;
				answer = Math.max(answer, cnt);
			}

			return answer;
		}
	}

	class Event{
		int enter;  //enter: 1, exit: -1
		int time;

		public Event(int enter, int time) {
			this.enter = enter;
			this.time = time;
		}
	}
}
