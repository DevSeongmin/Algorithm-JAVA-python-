package leet_code.medium;

public class _151_Reverse_Words_in_a_String {
	class Solution {
		public String reverseWords(String s) {
			String[] arr = s.strip().split(" ");
			StringBuilder sb = new StringBuilder();

			int l = arr.length;

			for (int i = l-1; i >= 0; i--) {
				if (arr[i].equals("")) continue;
				sb.append(arr[i] + " ");
			}

			return sb.toString().strip();
		}
	}
}
