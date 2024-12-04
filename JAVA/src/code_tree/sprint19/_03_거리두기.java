package code_tree.sprint19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _03_거리두기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		long low = 0;
		long high = 100_000 * 10_000;

		long answer = 0;

		while (low <= high){
			long mid = (low + high) / 2;

			if (binarySearch(mid, K, arr)){
				high = mid - 1;
				answer = mid;
			} else {
				low = mid + 1;
			}
		}

		System.out.println(answer);
	}

	static boolean binarySearch(long mid, int k, int[] arr){
		int count = 0;
		long sum = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > mid) return false;

			if (sum + arr[i] > mid) {
				count++;
				sum = arr[i];
			} else {
				sum += arr[i];
			}
		}

		return count <= k;
	}
}