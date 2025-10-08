package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BOJ4195_친구네트워크 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int ITER = Integer.parseInt(br.readLine());

		for (int i = 0; i < ITER; i++) {

			HashMap<String, String> unionMap = new HashMap<>();
			HashMap<String, Integer> countMap = new HashMap<>();

			int NETWORK = Integer.parseInt(br.readLine());

			for (int j = 0; j < NETWORK; j++) {
				String[] s = br.readLine().split(" ");
				String f1 = s[0];
				String f2 = s[1];

				if (!countMap.containsKey(f1)) {
					countMap.put(f1, 1);
					unionMap.put(f1, f1);
				}

				if (!countMap.containsKey(f2)) {
					countMap.put(f2, 1);
					unionMap.put(f2, f2);
				}

				sb.append(union(unionMap, countMap, f1, f2));
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

	static String find(HashMap<String, String> unionMap, String name) {
		if (unionMap.get(name).equals(name)) {
			return name;
		}

		String findName = find(unionMap, unionMap.get(name));
		unionMap.put(name, findName);
		return findName;
	}

	static int union(HashMap<String, String> unionMap, HashMap<String, Integer> countMap, String f1, String f2) {
		String rootF1 = find(unionMap, f1);
		String rootF2 = find(unionMap, f2);

		if (rootF1.equals(rootF2)) {
			return countMap.get(rootF1);
		}

		unionMap.put(rootF2, rootF1);
		countMap.put(rootF1, countMap.get(rootF1) + countMap.get(rootF2));

		return countMap.get(rootF1);
	}
}