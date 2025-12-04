package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ17609_회문 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int repeat = Integer.parseInt(br.readLine());

		while (repeat --> 0) {
			sb.append(isPalindrome(br.readLine())).append("\n");
		}

		System.out.println(sb);
	}

	private static int isPalindrome(String string) {
		char[] charArr = string.toCharArray();

		int s = 0;
		int e = charArr.length - 1;
		while (s < e) {
			if (charArr[s] != charArr[e]) {
				break;
			}
			s++;
			e--;
		}

		if (s >= e)
			return 0;

		int ns = s+1;
		int ne = e;
		while (ns < ne) {
			if (charArr[ns] != charArr[ne]) {
				break;
			}
			ns++;
			ne--;
		}

		if (ns >= ne) return 1;


		ns = s;
		ne = e-1;
		while (ns < ne) {
			if (charArr[ns] != charArr[ne]) {
				break;
			}
			ns++;
			ne--;
		}

		if (ns >= ne) return 1;

		return 2;
	}
}
