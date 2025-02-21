package leet_code.medium;

import java.util.Stack;

public class _735_Asteroid_Collision {
	class Solution {
		public int[] asteroidCollision(int[] asteroids) {
			Stack<Integer> stack = new Stack<>();

			for (int num : asteroids){
				if (stack.isEmpty() || num > 0) {
					stack.add(num);
					continue;
				}

				while (!stack.isEmpty()){

					if (stack.peek() < 0) {
						stack.add(num);
						break;
					}

					if (stack.peek() == -num) {
						stack.pop();
						break;
					}

					if (stack.peek() > -num){
						break;
					}

					if (stack.peek() < -num){
						stack.pop();
						if (stack.isEmpty()) {
							stack.add(num);
							break;
						}
					}
				}
			}

			int[] answer = new int[stack.size()];
			for (int i = answer.length - 1; i >= 0; i--) {
				answer[i] = stack.pop();
			}

			return answer;
		}
	}
}
