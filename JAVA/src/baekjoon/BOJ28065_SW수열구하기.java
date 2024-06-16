package baekjoon;

import java.util.Scanner;

public class BOJ28065_SW수열구하기 {

	public static void main(String[] args) {

		int N = new Scanner(System.in).nextInt();

		int[] arr = new int[N];

		int end = N;
		int start = 1;

		for (int i = 0; i < N; i++) {
			if (i % 2 != 0) {
				arr[i] = end--;
			} else {
				arr[i] = start++;
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i : arr) {
			sb.append(i + " ");
		}
		System.out.println(sb);

	}
}
