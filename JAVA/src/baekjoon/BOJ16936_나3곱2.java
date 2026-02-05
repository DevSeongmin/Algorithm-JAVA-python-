package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ16936_나3곱2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int L = Integer.parseInt(br.readLine());
		Long[] arr = new Long[L];

		String[] inputs = br.readLine().split(" ");

		for (int i = 0; i < L; i++) {
			arr[i] = Long.parseLong(inputs[i]);
		}

		Arrays.sort(arr,
			(a, b) -> {
				long aMod3Count = mod3Count(a);
				long bMod3Count = mod3Count(b);

				if (aMod3Count != bMod3Count) {
					return Long.compare(bMod3Count, aMod3Count);
				}
				return Long.compare(a, b);
			} );

		StringBuilder sb = new StringBuilder();

		for (Long l : arr) {
			sb.append(l).append(" ");
		}

		System.out.println(sb);
	}

	public static long mod3Count(long a) {
		long count = 0;

		while (a % 3 == 0) {
			a /= 3L;
			count++;
		}

		return count;
	}
}
