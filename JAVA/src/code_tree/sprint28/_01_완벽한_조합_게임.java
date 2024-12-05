package code_tree.sprint28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _01_완벽한_조합_게임 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		int left = 0;
		int right = N - 1;

		int value = arr[left] + arr[right];

		while (left < right) {
			if (value == K) {
				System.out.println("Yes");
				return;
			}

			if (value < K) {
				value -= arr[left++];
				value += arr[left];
			}

			if (value > K) {
				value -= arr[right--];
				value += arr[right];
			}
		}

		if (value == K) {
			System.out.println("Yes");
			return;
		}
		System.out.println("No");
	}
}