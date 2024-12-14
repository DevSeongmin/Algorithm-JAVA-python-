package code_tree.sprint29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _01_코드트리_음식점 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashMap<Integer, Integer> map = new HashMap();

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int recomm = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine().trim());

			map.put(num, map.getOrDefault(num ,0) + 1);

			if (map.get(num) >= K && num < recomm){
				recomm = num;
			}

			if (recomm == Integer.MAX_VALUE){
				System.out.println(-1);
				continue;
			}

			System.out.println(recomm);
		}

	}
}