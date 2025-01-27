package hsat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Lv3_자동차_테스트 {
	public class Main {

		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int Q = Integer.parseInt(st.nextToken());

			int[] arr = new int[N];

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);

			HashMap<Integer, Integer> answerMap = new HashMap();

			for (int i = 0; i < N; i++) {
				answerMap.put(arr[i], i * (N-i-1));
			}

			for (int i = 0; i < Q; i++) {
				System.out.println(answerMap.getOrDefault(Integer.parseInt(br.readLine()), 0));
			}
		}
	}
}
