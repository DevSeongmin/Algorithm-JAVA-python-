package Programmers;

import java.util.Arrays;
import java.util.Stack;

public class Lv2_과제_진행하기 {

	class Solution {
		public String[] solution(String[][] plans) {
			int idx = 0;
			String[] answer = new String[plans.length];

			Assignment[] assignments = new Assignment[plans.length + 1];

			for (int i = 0; i < plans.length; i++) {
				assignments[i] = new Assignment(plans[i]);
			}
			assignments[plans.length] = new Assignment(new String[] {"", "99:99", "999"});

			Arrays.sort(assignments, (a, b) -> Integer.compare(a.startTime, b.startTime));
			Stack<Assignment> stack = new Stack<>();
			Assignment cur = assignments[0];

			for (int i = 1; i < assignments.length; i++) {

				Assignment next = assignments[i];

				// 만약 다음 과제안에 지금 과제를 못 끝낸다면?
				if (cur.startTime + cur.remainingTime > next.startTime) {
					cur.remainingTime -= (next.startTime - cur.startTime);
					stack.push(cur);

					// 만약 다음 과제 안에 지금 과제를 끝낸다면?
				} else {
					answer[idx++] = cur.subject;

					int freeTime = next.startTime - (cur.startTime + cur.remainingTime);

					while (!stack.isEmpty() && freeTime > 0) {
						if (freeTime >= stack.peek().remainingTime) {
							Assignment top = stack.pop();
							freeTime -= top.remainingTime;
							answer[idx++] = top.subject;
						} else {
							Assignment top = stack.pop();
							top.remainingTime -= freeTime;
							freeTime = 0;
							stack.push(top);
						}
					}
				}
				cur = next;
			}

			while (!stack.isEmpty()) {
				answer[idx++] = stack.pop().subject;
			}

			return answer;
		}

		static class Assignment{
			String subject;
			int startTime;
			int remainingTime;

			public Assignment(String[] plan) {
				this.subject = plan[0];
				String[] tmp = plan[1].split(":");
				this.startTime = Integer.parseInt(tmp[0]) * 60 + Integer.parseInt(tmp[1]);
				this.remainingTime = Integer.parseInt(plan[2]);
			}
		}
	}
}
