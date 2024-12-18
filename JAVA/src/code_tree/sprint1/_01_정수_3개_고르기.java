package code_tree.sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _01_정수_3개_고르기 {

	static int N, K;
	static int answer = -1;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		recursion(0, 0, 0);
		System.out.println(answer);
	}

	static void recursion(int depth, int idx, int value){
		if (depth == 3) {

			if (value <= K){
				answer = Math.max(value, answer);
			}

			return;
		}

		for (int i = idx; i < N; i++) {
			recursion(depth+1, i + 1, value + arr[i]);
		}
	}
}