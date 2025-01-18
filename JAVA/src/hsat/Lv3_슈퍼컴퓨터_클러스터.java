package hsat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lv3_슈퍼컴퓨터_클러스터 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		long budget = Long.parseLong(input[1]);

		long[] arr = new long[N];

		input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(input[i]);
		}

		long low = 1;
		long high = 10000000000L;

		long answer = -1;

		while (low <= high) {
			long mid = (low + high) / 2;

			if (isPosible(mid, budget, arr)) {
				answer = mid;
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		System.out.println(answer);
	}

	public static boolean isPosible(long value, long budget ,long[] arr) {

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= value) continue;

			budget -= ((value - arr[i]) * (value - arr[i]));

			if (budget < 0) return false;
		}
		return true;
	}
}
