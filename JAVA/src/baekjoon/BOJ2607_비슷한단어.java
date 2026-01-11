package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2607_비슷한단어 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		String standardString = br.readLine();
		int[] standardArr = stringToIntArr(standardString);

		int answer = 0;
		for (int i = 0; i < N-1; i++) {
			String curString = br.readLine();

			if (Math.abs(standardString.length() - curString.length()) > 1){
				continue;
			}

			int[] curArr = stringToIntArr(curString);

			if (isSimilar(standardArr, curArr)) {
				answer++;
			}
		}

		System.out.println(answer);

	}

	private static boolean isSimilar(int[] standardArr, int[] ints) {
		int flag = 0;

		for (int i = 0; i < 27; i++) {
			if (Math.abs(standardArr[i] - ints[i]) > 1) {
				return false;
			}

			if (Math.abs(standardArr[i] - ints[i]) == 1) {
				if (flag >= 2) {
					return false;
				} else {
					flag++;
				}
			}
		}

		return true;
	}

	public static int[] stringToIntArr(String s) {
		int[] ints = new int[27];

		for (int i = 0; i < s.length(); i++) {
			ints[s.charAt(i) - 'A']++;
		}

		return ints;
	}
}
