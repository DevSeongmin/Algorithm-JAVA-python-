package code_tree.sprint7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _04_연속하는_정수의_합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int TARGET = Integer.parseInt(st.nextToken());

		int[] arr= new int[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0;
		int right = 0;
		int value = arr[0];
		int answer = 0;

		while(left <= right && right < N){

			if (value == TARGET) {
				answer++;
				if (++right >= N) break;
				value += arr[right];
				continue;
			}

			if (value < TARGET) {
				if (++right >= N) break;
				value += arr[right];
				continue;
			}

			if (value > TARGET) {
				value -= arr[left++];
			}
		}

		System.out.println(answer);
	}
}