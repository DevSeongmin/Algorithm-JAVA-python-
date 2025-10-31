package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ16719_ZOAC {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] charArr = sc.nextLine().toCharArray();
		boolean[] visited = new boolean[charArr.length];

		recursion(charArr, visited, 0, charArr.length);
	}

	private static void recursion(char[] charArr, boolean[] visited, int depth, int l) {

		if (depth >= l) return;

		ArrayList<MyChar> myChars = new ArrayList<>();

		for (int i = 0; i < l; i++) {
			if (visited[i]) continue;

			visited[i] = true;
			String s = genString(charArr, visited, l);
			myChars.add(new MyChar(s, i));
			visited[i] = false;
		}

		Collections.sort(myChars);
		MyChar selectedChar = myChars.get(0);
		visited[selectedChar.selectedIdx] = true;

		System.out.println(selectedChar.s);


		recursion(charArr, visited, depth + 1, l);
	}

	private static String genString(char[] charArr, boolean[] visited, int l) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < l; i++) {
			if (visited[i]) {
				sb.append(charArr[i]);
			}
		}
		return sb.toString();
	}

	static class MyChar implements Comparable<MyChar> {
		String s;
		int selectedIdx;

		public MyChar(String s, int selectedIdx) {
			this.s = s;
			this.selectedIdx = selectedIdx;
		}

		@Override
		public int compareTo(MyChar o) {
			return this.s.compareTo(o.s);
		}
	}

}
