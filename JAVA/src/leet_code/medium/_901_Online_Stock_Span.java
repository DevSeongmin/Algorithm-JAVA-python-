package leet_code.medium;

import java.util.Stack;

public class _901_Online_Stock_Span {
	class StockSpanner {
		static Stack<Pair> stack;

		public StockSpanner() {
			stack = new Stack<>();

		}

		public int next(int price) {
			int cnt = 1;
			while (!stack.isEmpty() && stack.peek().value <= price) {
				Pair p =  stack.pop();
				cnt += p.cnt;
			}
			stack.push(new Pair(cnt, price));
			return cnt;
		}

		static class Pair {
			int cnt, value;
			public Pair(int cnt, int value) {
				this.cnt = cnt;
				this.value = value;
			}
		}
	}

	/**
	 * Your StockSpanner object will be instantiated and called as such:
	 * StockSpanner obj = new StockSpanner();
	 * int param_1 = obj.next(price);
	 */
}
