package code_tree.sprint27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _02_후위_순외한_결과 {

	static int[] pre, in;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		pre = new int[N];
		in = new int[N];

		StringTokenizer st =new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			pre[i] = Integer.parseInt(st.nextToken());
		}

		st =new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			in[i] = Integer.parseInt(st.nextToken());
		}

		search(0, N, 0, N);
	}

	static void search(int ps, int pe, int is, int ie) {
		if (ps >= pe || is >= ie) return;

		int root = pre[ps];
		int rootIdx = -1;

		for (int i = is; i < ie; i++) {
			if (in[i] == root) {
				rootIdx = i;
				break;
			}
		}

		int leftSize = rootIdx - is;

		// 왼쪽 서브트리
		search(ps + 1, ps + 1 + leftSize, is, rootIdx);

		// 오른쪽 서브트리
		search(ps + 1 + leftSize, pe, rootIdx + 1, ie);

		System.out.print(root + " ");
	}
}
