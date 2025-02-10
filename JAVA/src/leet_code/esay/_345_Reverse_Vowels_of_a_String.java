package leet_code.esay;

import java.util.HashSet;

public class _345_Reverse_Vowels_of_a_String {
	class Solution {

		static HashSet<Character> moum = new HashSet();
		static {
			moum.add('a');
			moum.add('A');
			moum.add('e');
			moum.add('E');
			moum.add('i');
			moum.add('I');
			moum.add('o');
			moum.add('O');
			moum.add('u');
			moum.add('U');
		}
		public String reverseVowels(String s) {

			int l = s.length();
			char[] answer = new char[l];

			for (int i = 0; i < l; i++) {
				answer[i] = s.charAt(i);
			}

			int left = 0;
			int right = l-1;

			while (true){

				while (left < l && !(moum.contains(s.charAt(left)))) {
					left++;
				}

				while (right >= 0 && !(moum.contains(s.charAt(right)))) {
					right--;
				}

				if (left >= right) break;

				answer[right] = s.charAt(left);
				answer[left] = s.charAt(right);

				left++;
				right--;
			}

			return new String(answer);
		}
	}
}
