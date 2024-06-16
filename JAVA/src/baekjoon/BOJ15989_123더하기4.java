package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ15989_123더하기4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] DP = new int[10001];
		Arrays.fill(DP, 1);

		for (int i = 2; i < 10001; i++) {
			DP[i] += DP[i - 2];
		}

		for (int i = 3; i < 10001; i++) {
			DP[i] += DP[i - 3];
		}

		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			sb.append(DP[Integer.parseInt(br.readLine())] + "\n");
		}

		System.out.println(sb);

	}
}
