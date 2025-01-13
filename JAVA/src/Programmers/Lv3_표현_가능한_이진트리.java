package Programmers;

public class Lv3_표현_가능한_이진트리 {

	class Solution {
		public int[] solution(long[] numbers) {
			int[] answer = new int[numbers.length];
			int cnt = 0;

			for (long number : numbers){
				String bin = convertBin(number);
				answer[cnt++] = recursion(bin, 0, bin.length()-1, '1') == true ? 1 : 0;
			}

			return answer;
		}

		static boolean recursion(String bin, int start, int end, char parent) {

			int rootIdx = (start + end) / 2;
			char root = bin.charAt(rootIdx);

			if (root == '1' && parent == '0') return false;

			if (start == end) return true;

			if (!recursion(bin, start, rootIdx - 1, root)) return false;
			if (!recursion(bin, rootIdx+1, end, root)) return false;

			return true;
		}

		static String convertBin(long number) {

			StringBuilder sb = new StringBuilder();

			while (number > 0){
				sb.append(number % 2);
				number /= 2;
			}

			int n = 2;

			while (n - 1 < sb.length()){
				n *= 2;
			}

			n -= 1;

			sb.append("0".repeat((n - sb.length())));
			sb.reverse();

			return sb.toString();
		}
	}
}
