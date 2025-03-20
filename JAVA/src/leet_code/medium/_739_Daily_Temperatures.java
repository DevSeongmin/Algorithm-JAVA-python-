package leet_code.medium;

import java.util.Stack;

public class _739_Daily_Temperatures {

	class Solution {
		public int[] dailyTemperatures(int[] temperatures) {
			int l = temperatures.length;
			int[] answer = new int[l];
			Stack<Pair> stack = new Stack<>();

			for (int i = 0; i < l; i++) {

				int temperature = temperatures[i];

				while (!stack.isEmpty() && stack.peek().temperature < temperature) {
					Pair p = stack.pop();
					answer[p.idx] = i - p.idx;
				}

				stack.push(new Pair(i, temperature));
			}
			return answer;
		}

		static class Pair{
			int idx;
			int temperature;

			public Pair(int idx, int temperature) {
				this.idx = idx;
				this.temperature = temperature;
			}
		}
	}
}
