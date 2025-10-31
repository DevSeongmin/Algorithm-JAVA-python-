package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ14238_출근_기록 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();

		int countA = 0;
		int countB = 0;
		int countC = 0;

		for (char c : arr) {
			if (c == 'A') {
				countA++;
			}
			if (c == 'B') {
				countB++;
			}
			if (c == 'C') {
				countC++;
			}
		}

		recursion(
			0, countA, countB, countC, 'A', 'A', new char[arr.length]
		);

		System.out.println(result);
	}

	static boolean[][][][][] visited = new boolean[51][51][51][4][4];
	static String result = "-1";

	private static void recursion(int depth, int countA, int countB, int countC, char last1, char last2, char[] answer) {
		if (!result.equals("-1")) return;
		if (visited[countA][countB][countC][last1-'A'][last2-'A']) return;
		visited[countA][countB][countC][last1-'A'][last2-'A'] = true;


		if (countA == 0 && countB == 0 && countC == 0) {
			result = new String(answer);
			return;
		}

		if (countC > 0 && last1 != 'C' && last2 != 'C') {
			countC--;
			answer[depth] = 'C';

			recursion(depth + 1, countA, countB, countC, 'C', last1, answer);
			countC++;
		}

		if (countB > 0 && last1 != 'B') {
			countB--;
			answer[depth] = 'B';

			recursion(depth + 1, countA, countB, countC, 'B', last1, answer);
			countB++;
		}

		if (countA > 0) {
			countA--;
			answer[depth] = 'A';

			recursion(depth+1, countA, countB, countC, 'A', last1, answer);
			countA--;
		}
	}
}
