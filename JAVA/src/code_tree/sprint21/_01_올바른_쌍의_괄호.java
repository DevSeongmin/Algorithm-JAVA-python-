package code_tree.sprint21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _01_올바른_쌍의_괄호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();

		Stack<Character> stack = new Stack();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == '(') {
				stack.push(c);
				continue;
			}

			if (c == ')') {
				if (stack.empty()) {
					System.out.println("No");
					return;
				}

				if (stack.peek() == ')') {
					System.out.println("No");
					return;
				}

				if (stack.peek() == '(') {
					stack.pop();
					continue;
				}
			}
		}

		if (stack.isEmpty()){
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}