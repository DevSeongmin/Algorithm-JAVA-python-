package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2357_최솟값과_최댓값 {

	static int[] minSegTree, maxSegTree;
	static int segTreeLen;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] input = br.readLine().split(" ");

		int N = Integer.parseInt(input[0]);
		int Q = Integer.parseInt(input[1]);

		int[] inputArr = new int[N];
		for (int i = 0; i < N; i++) {
			inputArr[i] = Integer.parseInt(br.readLine());
		}

		setSegTreeLen(N);
		initMaxSegTree(inputArr);
		initMinSegTree(inputArr);

		for (int i = 0; i < Q; i++) {
			input = br.readLine().split(" ");

			int s = Integer.parseInt(input[0]) - 1;
			int e = Integer.parseInt(input[1]) - 1;

			sb.append(rangeMinVal(s, e)).append(" ").append(rangeMaxVal(s, e)).append("\n");
		}

		System.out.println(sb);

	}

	static int rangeMinVal(int s, int e) {
		int minVal = Integer.MAX_VALUE;

		s += segTreeLen / 2;
		e += segTreeLen / 2;

		while (s <= e) {
			if (s % 2 == 1) {
				minVal = Math.min(minVal, minSegTree[s]);
			}

			if (e % 2 == 0) {
				minVal = Math.min(minVal, minSegTree[e]);
			}

			s = (s + 1) / 2;
			e = (e - 1) / 2;
		}

		return minVal;
	}

	static int rangeMaxVal(int s, int e) {
		int maxVal = 0;

		s += segTreeLen / 2;
		e += segTreeLen / 2;

		while (s <= e) {
			if (s % 2 == 1) {
				maxVal = Math.max(maxVal, maxSegTree[s]);
			}

			if (e % 2 == 0) {
				maxVal = Math.max(maxVal, maxSegTree[e]);
			}

			s = (s + 1) / 2;
			e = (e - 1) / 2;
		}

		return maxVal;
	}

	static void initMaxSegTree(int[] inputArr) {
		maxSegTree = new int[segTreeLen];

		for (int i = 0; i < inputArr.length; i++) {
			maxSegTree[i+ segTreeLen / 2] = inputArr[i];
		}

		for (int i = segTreeLen / 2 -1; i > 0; i--) {
			maxSegTree[i] = Math.max(maxSegTree[i * 2], maxSegTree[i * 2 + 1]);
		}
	}

	static void initMinSegTree(int[] inputArr) {
		minSegTree = new int[segTreeLen];
		Arrays.fill(minSegTree, Integer.MAX_VALUE);

		for (int i = 0; i < inputArr.length; i++) {
			minSegTree[i+ segTreeLen / 2] = inputArr[i];
		}

		for (int i = segTreeLen / 2 -1; i > 0; i--) {
			minSegTree[i] = Math.min(minSegTree[i * 2], minSegTree[i * 2 + 1]);
		}
	}

	static void setSegTreeLen(int N) {

		segTreeLen = 1;

		while (segTreeLen < N) {
			segTreeLen *= 2;
		}

		segTreeLen *= 2;
	}
}
