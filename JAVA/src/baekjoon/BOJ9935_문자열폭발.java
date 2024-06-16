package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ9935_문자열폭발 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		String bomb = br.readLine();

		ArrayList<Character> arr = new ArrayList<>();

		for (int i = 0; i < str.length(); i++) {
			char curChar = str.charAt(i);

			arr.add(curChar);

			while (arr.size() >= bomb.length() && check(arr, bomb)) {
				for (int j = 0; bomb.length() > j; j++) {
					arr.remove(arr.size() - 1);
				}
			}
		}

		if (arr.isEmpty()) {
			System.out.println("FRULA");
		} else {
			StringBuilder sb = new StringBuilder();
			for (Character c : arr) {
				sb.append(c);
			}
			System.out.println(sb);
		}

	}

	static boolean check(ArrayList<Character> arr, String bomb) {
		int size = bomb.length();
		for (int i = 0; i < size; i++) {
			if (bomb.charAt(size - 1 - i) != arr.get(arr.size() - i - 1)) {
				return false;
			}
		}
		return true;
	}
}