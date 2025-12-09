package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9417_최대GCD {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int iter = Integer.parseInt(br.readLine());

		while (iter --> 0) {
			String[] input = br.readLine().split(" ");
			int l = input.length;

			int[] arr = new int[l];
			for (int i = 0; i < l; i++) {
				arr[i] = Integer.parseInt(input[i]);
			}

			int answer = 1;
			for (int i = 0; i < l; i++) {
				for (int j  = i+1; j < l; j++) {
					answer = Math.max(answer, gcd(arr[i], arr[j]));
				}
			}
			sb.append(answer).append("\n");
		}

		System.out.println(sb);
	}
	static int gcd(int a, int b) {
		if (b == 0) return a;

		return gcd(b, a % b);
	}
}
