package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14731_謎紛芥索紀_Large {

	public static final int MOD = 1000000007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		long answer = 0;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long base = Integer.parseInt(st.nextToken());
			long exp = Integer.parseInt(st.nextToken());

			base = (base * exp) % MOD;
			exp--;

			answer = (answer + (base * powerOfTwo(exp)) % MOD) % MOD;
		}
		System.out.println(answer);

	}

	static long powerOfTwo(long n) {
		if (n == 0) {
			return 1;
		}

		if (n == 1) {
			return 2;
		}

		long halfPower = powerOfTwo(n / 2) % MOD;

		// 지수가 짝수인 경우
		if (n % 2 == 0) {
			return (halfPower * halfPower) % MOD;
			// 지수가 홀수인 경우
		} else {
			return (halfPower * halfPower * 2) % MOD;
		}
	}
}
