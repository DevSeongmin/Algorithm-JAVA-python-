package baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11505_구간_곱_구하기 {

	final static int  MOD = 1_000_000_007;
	static long[] multiSegTree;
	static int segTreeLen;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] input = br.readLine().split(" ");

		int N = Integer.parseInt(input[0]);
		int Q = Integer.parseInt(input[1]) + Integer.parseInt(input[2]);

		setSegTreeLen(N);
		initSegTree(N, br);

		for (int i = 0; i < Q; i++) {
			input = br.readLine().split(" ");

			int q = Integer.parseInt(input[0]);
			int a = Integer.parseInt(input[1]);
			int b = Integer.parseInt(input[2]);

			if (q == 1) {
				updateTree(a - 1, b);
			} else {
				sb.append(getMultiRange(a - 1, b - 1)).append("\n");
			}
		}

		System.out.println(sb);

	}


	static void updateTree(int idx, int value) {
		idx += segTreeLen / 2;

		multiSegTree[idx] = value;

		while (idx > 1) {
			idx /= 2;
			multiSegTree[idx] = (multiSegTree[idx * 2] * multiSegTree[idx * 2 + 1]) % MOD;
		}
	}

	static long getMultiRange(int s, int e) {
		long multiVal = 1;

		s += segTreeLen / 2;
		e += segTreeLen / 2;

		while (s <= e) {
			if (s % 2 == 1) {
				multiVal = (multiVal * multiSegTree[s]) % MOD;
			}

			if (e % 2 == 0) {
				multiVal = (multiVal * multiSegTree[e]) % MOD;
			}

			s = (s+1) / 2;
			e = (e-1) / 2;
		}

		return multiVal;

	}



	static void initSegTree(int N, BufferedReader br) throws IOException {
		multiSegTree = new long[segTreeLen];

		for (int i = 0; i < N; i++) {
			multiSegTree[i + segTreeLen / 2] = Long.parseLong(br.readLine());
		}

		for (int i = segTreeLen / 2 - 1; i > 0; i--) {
			multiSegTree[i] = (multiSegTree[i * 2] * multiSegTree[i * 2 + 1]) % MOD;
		}
	}


	static void setSegTreeLen(int N) {
		segTreeLen  = 1;

		while (segTreeLen < N) {
			segTreeLen *= 2;
		}

		segTreeLen *= 2;
	}
}
