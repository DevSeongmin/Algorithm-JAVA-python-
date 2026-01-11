package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ21921_블로그 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int rangeSum = 0;

		for (int i = 0; i < x; i++) {
			rangeSum += arr[i];
		}

		int answer = rangeSum;
		int count = 1;

		for (int i = x; i < n; i++) {
			rangeSum += arr[i];
			rangeSum -= arr[i - x];

			if (rangeSum > answer) {
				answer = rangeSum;
				count = 1;
			} else if (rangeSum == answer) {
				count++;
			}
		}

		StringBuilder sb = new StringBuilder();

		if (answer == 0) {
			sb.append("SAD");
		} else {
			sb.append(answer).append("\n").append(count);
		}

		System.out.println(sb);
	}
}
