package leet_code.medium;

import java.util.HashSet;
import java.util.Stack;

public class _394_Decode_String {
	class Solution {

		static HashSet<Character> numbers = new HashSet();
		static {
			numbers.add('0');
			numbers.add('1');
			numbers.add('2');
			numbers.add('3');
			numbers.add('4');
			numbers.add('5');
			numbers.add('6');
			numbers.add('7');
			numbers.add('8');
			numbers.add('9');
		}

		public String decodeString(String s) {

			Stack<Character> stack = new Stack();

			for (char c : s.toCharArray()) {
				if (c != ']') {
					stack.add(c);
					continue;
				}

				StringBuilder alphabet = new StringBuilder();

				while (stack.peek() != '[') {
					alphabet.append(stack.pop());
				}
				stack.pop();

				StringBuilder number = new StringBuilder();

				while (!stack.isEmpty() && numbers.contains(stack.peek())) {
					number.append(stack.pop());
				}

				number.reverse();
				alphabet.reverse();

				for (int i = 0; i < Integer.parseInt(number.toString()); i++) {
					for (int j = 0; j < alphabet.length(); j++) {
						stack.add(alphabet.charAt(j));
					}
				}
			}

			StringBuilder answer = new StringBuilder();

			while (!stack.isEmpty()) {
				answer.append(stack.pop());
			}
			answer.reverse();

			return answer.toString();
		}
	}
}
