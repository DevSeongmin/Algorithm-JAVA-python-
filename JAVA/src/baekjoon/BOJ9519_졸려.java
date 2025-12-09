package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;

public class BOJ9519_졸려 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int iter = Integer.parseInt(br.readLine());
		String s = br.readLine();

		ArrayList<String> cycleArr = getCycleArr(s);
		int cycle = cycleArr.size();

		iter %= cycle;

		System.out.println(cycleArr.get(iter));
	}

	private static ArrayList<String> getCycleArr(String s) {
		ArrayList<String> arr = new ArrayList<>();

		arr.add(s);

		while (true) {
			s = blick(s);

			if (Objects.equals(s, arr.get(0))) {
				break;
			}

			arr.add(s);
		}

		return arr;
	}


	static String blick(String string) {
		StringBuilder sb = new StringBuilder();

		int s = 0;
		int e = string.length() - 1;

		for (int i = 0; i <= e; i += 2) {
			sb.append(string.charAt(i));
		}

		e = e % 2 == 0 ? e - 1 : e;

		for (int i = e; i > s; i-=2) {
			sb.append(string.charAt(i));
		}

		return sb.toString();
	}
}