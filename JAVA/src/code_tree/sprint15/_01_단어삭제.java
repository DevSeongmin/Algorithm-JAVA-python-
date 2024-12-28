package code_tree.sprint15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _01_단어삭제 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String word = br.readLine();
		String target = br.readLine();

		if (target.length() == 1) {
			System.out.println(word.replace(target, ""));
			return;
		}

		Stack<Character> stack = new Stack();

		char first = target.charAt(0);
		char second = target.charAt(1);

		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);

			if (c != second || stack.isEmpty()) {
				stack.push(c);
				continue;
			}

			if (stack.peek() == first){
				stack.pop();
			} else {
				stack.push(c);
			}
		}
		StringBuilder sb = new StringBuilder();

		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}

		System.out.println(sb.reverse());
	}
}