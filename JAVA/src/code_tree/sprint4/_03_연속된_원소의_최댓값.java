package code_tree.sprint4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _03_연속된_원소의_최댓값 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int answer = arr[0];
		int cur = arr[0];

		for (int i = 1; i < N; i++) {
			if(cur + arr[i] > arr[i]) {
				cur += arr[i];
			} else {
				cur = arr[i];
			}
			answer = Math.max(answer, cur);
		}

		System.out.println(answer);
	}
}