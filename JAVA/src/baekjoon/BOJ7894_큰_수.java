package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ7894_큰_수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(digitsFast(Integer.parseInt(br.readLine()))).append("\n");
		}
		System.out.println(sb);

	}

	static int getDigit(int n) {
		double digit = 0.0;

		for (int i = 2; i <= n; i++) {
			digit += Math.log10(i);
		}

		return (int)digit + 1;
	}

	static int digitsFast(int n) {
		if (n < 0) return 0;
		if (n <= 1) return 1;

		double logn = Math.log10(n);
		return (int)Math.floor(n * logn - n * Math.log10(Math.E)
			+ 0.5 * Math.log10(2 * Math.PI * n)) + 1;
	}
}
