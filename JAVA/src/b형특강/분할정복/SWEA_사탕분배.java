package b형특강.분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_사탕분배 {
	static long sum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			st = new StringTokenizer(br.readLine());

			long a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			sum = a + b;

			long result = a * power(2, k) % sum;

			sb.append("#" + tc + " " + Math.min(result, sum - result) + "\n");
		}
		System.out.println(sb);
	}

	static long power(long a, int k) {

		if (k == 0)
			return 1;

		long tmp = power(a, k / 2);

		if (k % 2 == 0) {
			return (tmp * tmp) % sum;
		} else {
			return (tmp * tmp * a) % sum;
		}

	}
}
