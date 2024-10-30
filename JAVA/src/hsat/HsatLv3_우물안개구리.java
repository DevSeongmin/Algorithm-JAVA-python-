package hsat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class HsatLv3_우물안개구리 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");

		int N = Integer.parseInt(input[0]);
		int E = Integer.parseInt(input[1]);

		int[] arr = new int[N];

		input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		ArrayList<Integer>[] graph = new ArrayList[N];

		for (int i = 0; i < N; i++){
			graph[i] = new ArrayList();
		}

		for (int i = 0; i < E; i++) {
			input = br.readLine().split(" ");
			int e1 = Integer.parseInt(input[0]) - 1;
			int e2 = Integer.parseInt(input[1]) - 1;
			graph[e1].add(e2);
			graph[e2].add(e1);
		}

		int answer = 0;
		for (int i = 0; i < N; i++) {
			boolean flag = true;

			for (int v : graph[i]){
				if (arr[v] >= arr[i]) {
					flag = false;
					break;
				}
			}
			if (flag) answer++;
		}
		System.out.println(answer);
	}
}
