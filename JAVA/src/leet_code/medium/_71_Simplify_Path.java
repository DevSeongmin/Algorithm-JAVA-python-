package leet_code.medium;

import java.util.Stack;

public class _71_Simplify_Path {
	class Solution {
		public String simplifyPath(String path) {

			String[] input = path.split("/");
			Stack<String> stack = new Stack<>();

			for (String s : input) {
				if (s.equals("") || s.equals(".")) {
					continue;
				}

				if (s.equals("..") ) {
					if (!stack.isEmpty()) {
						stack.pop();
					}
					continue;
				}

				stack.push(s);
			}

			return "/" + String.join("/", stack);
		}
	}
}
