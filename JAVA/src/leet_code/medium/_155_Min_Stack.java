package leet_code.medium;

import java.util.Stack;

public class _155_Min_Stack {

	// 일반적인 스택에 추가로 min value를 O(1)만에 조회하도록 하는 문제
	// 솔루션 : stack에 val, 과 min val을 함께 저장하는 것으로 해결할 수 있다.
	class MinStack {

		Stack<int[]> stack;
		public MinStack() {
			stack = new Stack<>();
		}

		public void push(int val) {
			if (stack.isEmpty()) {
				stack.push(new int[] {val, val});
				return;
			}
			stack.push(new int[] {val, Math.min(val, stack.peek()[1])});
		}

		public void pop() {
			stack.pop();
		}

		public int top() {
			return stack.peek()[0];

		}

		public int getMin() {
			return stack.peek()[1];
		}
	}
}
