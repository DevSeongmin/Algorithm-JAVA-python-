package code_tree.sprint7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _01_구간_칠하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] arr = new int[201];

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			for (int idx = s; idx < e; idx++) {
				arr[idx + 100]++;
			}
		}

		int answer = -1;

		for (int value : arr) {
			answer = Math.max(answer, value);
		}

		System.out.println(answer);
	}
}