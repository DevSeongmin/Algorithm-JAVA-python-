package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1275_커피숍2 {

	static long[] segmentTree;
	static int segmentTreeLen;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] input = br.readLine().split(" ");

		int N = Integer.parseInt(input[0]);
		int Q = Integer.parseInt(input[1]);

		initSegTree(N, br);

		for (int i = 0; i < Q; i++) {
			input = br.readLine().split(" ");

			int s = Integer.parseInt(input[0]) - 1;
			int e = Integer.parseInt(input[1]) - 1;

			if (s > e) {
				int tmp = e;
				e = s;
				s = tmp;
			}

			int idx = Integer.parseInt(input[2]) - 1;
			int val = Integer.parseInt(input[3]);

			sb.append(rangeSum(s, e)).append("\n");
			updateTree(idx, val);

		}

		System.out.println(sb);
	}

	static long rangeSum(int s, int e) {
		s += (segmentTreeLen/2);
		e += (segmentTreeLen/2);

		long sum = 0;

		while (s <= e) {
			if (s % 2 == 1) {
				sum += segmentTree[s];
			}
			if (e % 2 == 0) {
				sum += segmentTree[e];
			}

			s = (s + 1) / 2;
			e = (e - 1) / 2;
		}

		return sum;
	}

	static void initSegTree(int N, BufferedReader br) throws IOException {

		segmentTreeLen = findSegLen(N);
		segmentTree = new long[segmentTreeLen];
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			segmentTree[i + segmentTreeLen / 2] = Integer.parseInt(input[i]);
		}

		for (int i = segmentTreeLen / 2 - 1; i > 0; i--) {
			segmentTree[i] = segmentTree[i * 2] + segmentTree[i * 2 + 1];
		}
	}

	static int findSegLen(int l) {
		int segLen = 1;

		while (segLen < l) {
			segLen *= 2;
		}
		return segLen * 2;
	}

	static void updateTree(int idx, int val) {

		idx += (segmentTreeLen / 2);


		segmentTree[idx] = val;

		while (idx > 1) {
			idx /= 2;
			segmentTree[idx] = segmentTree[idx*2] + segmentTree[idx*2 + 1];
		}
	}
}
