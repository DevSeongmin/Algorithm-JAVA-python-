package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ3687_성냥개비 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		long[] min = new long[101];

		Arrays.fill(min, Long.MAX_VALUE);

		min[2] = 1;
		min[3] = 7;
		min[4] = 4;
		min[5] = 2;
		min[6] = 6;
		min[7] = 8;
		min[8] = 10;

		int[] count = {1, 7, 4, 2, 0, 8};
		for (int i = 9; i <= 100; ++i) {
			for (int j = 2; j <= 7; ++j) {
				min[i] = Math.min((min[i - j] * 10) + count[j - 2], min[i]);
			}
		}

		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int number = Integer.parseInt(br.readLine());
			sb.append(min[number] + " " + maxVal(number) + "\n");
		}
		System.out.println(sb);
	}

	static String maxVal(int number) {
		StringBuilder sb = new StringBuilder();
		if (number % 2 == 0) {

			for (int i = 0; i < number / 2; i++) {
				sb.append("1");
			}
			return sb.toString();
		}

		sb.append("7");
		for (int i = 0; i < (number - 3) / 2; i++) {
			sb.append("1");
		}
		return sb.toString();
	}

}
