package code_tree.sprint19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
	int idx, cnt;

	public Node(int idx, int cnt) {
		this.idx = idx;
		this.cnt = cnt;
	}
}
public class _02_점프점프 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] DP = new int[N];

		for (int i = 1; i < N; i++) {

			for (int j = i-1; j >= 0; j--){
				if (j + arr[j] >= i){
					DP[i] = Math.max(DP[i], DP[j] + 1);
				}
			}
		}

		int answer = 0 ;
		for (int i : DP) {
			answer = Math.max(answer, i);
		}
		System.out.println(answer);
	}
}
