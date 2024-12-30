package code_tree.sprint21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _03_멀리멀리 {

	static int N, K;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[N];
		st = new StringTokenizer(br.readLine());

		int low = 0;
		int high = -1;

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			high = Math.max(high, arr[i]);
		}

		Arrays.sort(arr);

		int answer = 0;

		while (low <= high) {
			int mid = (low + high) / 2;

			if (isPos(mid)){
				answer = mid;
				low = mid+1;
			} else {
				high = mid-1;
			}
		}
		System.out.println(answer);
	}

	static boolean isPos(int mid) {

		int selected = 1;
		int curPos = arr[0];

		for (int i = 1; i < N; i++) {
			if (arr[i] - curPos >= mid){
				selected++;
				curPos = arr[i];
			}
		}

		if (selected >= K) {
			return true;
		}
		return false;
	}
}