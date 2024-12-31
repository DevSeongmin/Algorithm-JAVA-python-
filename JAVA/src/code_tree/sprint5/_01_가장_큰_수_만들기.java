package code_tree.sprint5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _01_가장_큰_수_만들기 {

	static int answer = 0;
	static int N, K;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[K];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		recursion(0);

		System.out.println(answer);
	}

	static void recursion(int value) {
		if (value > N) return;

		answer = Math.max(answer, value);

		for (int i = 0; i < K; i++) {
			recursion(value * 10 + arr[i]);
		}
	}
}