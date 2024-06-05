package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_KPSC_A {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int answer = 0;
		int q = Integer.parseInt(br.readLine());

		for (int i = 0; i < q; i++) {
			answer += arr[Integer.parseInt(br.readLine()) - 1];
		}

		System.out.println(answer);
		
	}

}
