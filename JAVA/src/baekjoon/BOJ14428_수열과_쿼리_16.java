package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ14428_수열과_쿼리_16 {

	static int segTreeSize;
	static int[] minIdxSegTree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int Q = Integer.parseInt(br.readLine());

		setSegTreeSize(N);
		initSegTree(N, arr);

		for (int i = 0; i < Q; i++) {
			String[] input = br.readLine().split(" ");
			int q = Integer.parseInt(input[0]);
			int a = Integer.parseInt(input[1]);
			int b = Integer.parseInt(input[2]);

			if (q == 1) {
				updateSegTree(arr, a - 1, b);
			} else if (q == 2) {
				sb.append(searchRange(arr, a - 1, b - 1) + 1).append("\n");
			}
		}

		System.out.println(sb);
	}

	static int searchRange(int[] arr, int s, int e) {
		int value = Integer.MAX_VALUE;

		s += segTreeSize / 2;
		e += segTreeSize / 2;

		while (s <= e) {
			if (s % 2 == 1) {
				if (value == Integer.MAX_VALUE) {
					value = minIdxSegTree[s];
				} else if (arr[value] > arr[minIdxSegTree[s]]) {
					value = minIdxSegTree[s];
				} else if (arr[value] == arr[minIdxSegTree[s]]) {
					value = Math.min(value, minIdxSegTree[s]);
				}
			}
			if (e % 2 == 0) {
				if (value == Integer.MAX_VALUE) {
					value = minIdxSegTree[e];
				} else if (arr[value] > arr[minIdxSegTree[e]]) {
					value = minIdxSegTree[e];
				} else if (arr[value] == arr[minIdxSegTree[e]]) {
					value = Math.min(value, minIdxSegTree[e]);
				}
			}

			s = (s + 1) / 2;
			e = (e - 1) / 2;
		}

		return value;
	}

	static void updateSegTree(int[] arr, int idx, int value) {
		arr[idx] = value;

		idx += segTreeSize / 2;

		while (idx > 1) {
			idx/=2;

			int leftIdx = minIdxSegTree[idx*2];
			int rightIdx = minIdxSegTree[idx*2+1];

			if (leftIdx != Integer.MAX_VALUE && rightIdx != Integer.MAX_VALUE) {
				if (arr[leftIdx] <= arr[rightIdx]) {
					minIdxSegTree[idx] = leftIdx;
				} else {
					minIdxSegTree[idx] = rightIdx;
				}
			} else if (leftIdx != Integer.MAX_VALUE) {
				minIdxSegTree[idx] = leftIdx;
			} else if (rightIdx != Integer.MAX_VALUE) {
				minIdxSegTree[idx] = rightIdx;
			}
		}
	}

	private static void initSegTree(int N, int[] arr) {
		minIdxSegTree = new int[segTreeSize];
		Arrays.fill(minIdxSegTree, Integer.MAX_VALUE);

		for (int i = 0; i < N; i++) {
			minIdxSegTree[segTreeSize / 2 + i] = i;
		}

		for (int i = segTreeSize / 2 - 1; i > 0; i--) {
			int leftIdx = minIdxSegTree[i * 2];
			int rightIdx = minIdxSegTree[i * 2 + 1];

			if (leftIdx != Integer.MAX_VALUE && rightIdx != Integer.MAX_VALUE) {
				if (arr[leftIdx] <= arr[rightIdx]) {
					minIdxSegTree[i] = leftIdx;
				} else {
					minIdxSegTree[i] = rightIdx;
				}
			} else if (leftIdx != Integer.MAX_VALUE) {
				minIdxSegTree[i] = leftIdx;
			} else if (rightIdx != Integer.MAX_VALUE) {
				minIdxSegTree[i] = rightIdx;
			}
		}
	}

	static void setSegTreeSize(int N) {
		segTreeSize = 1;

		while (segTreeSize < N) {
			segTreeSize *= 2;
		}
		segTreeSize *= 2;
	}
}
