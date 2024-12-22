package code_tree.sprint8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class _03_표기법_변환 {

	static HashMap<Character, Integer> priority = new HashMap<>();

	static {
		priority.put('+', 0);
		priority.put('-', 0);
		priority.put('*', 1);
		priority.put('/', 1);
		priority.put('(', 2);
		priority.put(')', 2);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder postFix = new StringBuilder();

		String inFix = br.readLine();
		Stack<Character> operStack = new Stack<>();

		for (int i = 0; i < inFix.length(); i++) {
			Character tmp = inFix.charAt(i);

			if (!priority.containsKey(tmp)) {
				postFix.append(tmp);
				continue;
			}

			if (operStack.isEmpty()) {
				operStack.add(tmp);
				continue;
			}


			if (tmp == ')') {
				while(operStack.peek() != '('){
					postFix.append(operStack.pop());
				}
				operStack.pop();
				continue;
			}

			while (!operStack.isEmpty() && operStack.peek() != '(' && priority.get(operStack.peek()) >= priority.get(tmp)) {
				postFix.append(operStack.pop());
			}
			operStack.add(tmp);

		}

		while(!operStack.isEmpty()) {
			postFix.append(operStack.pop());
		}

		System.out.println(postFix);
	}
}
