package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B_평점변환 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		String s = br.readLine();

		s = s.replace("0", "");

		ArrayList<String> list = new ArrayList<>();

		int point = 0;
		while (point < s.length()) {
			if (point + 1 < s.length() && (s.charAt(point + 1) == '+' || s.charAt(point + 1) == '-')) {
				list.add(s.substring(point, point + 2));
				point += 2;
			} else {
				list.add(s.substring(point, point + 1));
				point++;
			}
		}

		ArrayList<String> answer = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals("C+") || list.get(i).equals("C") || list.get(i).equals("C-")) {
				answer.add("B");
			} else if (list.get(i).equals("B") || list.get(i).equals("B-")) {

				if (i == 0 || list.get(i - 1).equals("C+") || list.get(i - 1).equals("C") || list.get(i - 1)
					.equals("C-")) {
					answer.add("D");
				} else {
					answer.add("B");
				}

			} else if (list.get(i).equals("A-") || list.get(i).equals("B+")) {

				if (i == 0 || list.get(i - 1).equals("B") || list.get(i - 1).equals("B-")
					|| list.get(i - 1).equals("C+") || list.get(i - 1).equals("C") || list.get(i - 1).equals("C-")) {
					answer.add("P");
				} else {
					answer.add("D");
				}
			} else if (list.get(i).equals("A")) {

				if (i == 0 || list.get(i - 1).equals("A-") || list.get(i - 1).equals("B+") || list.get(i - 1)
					.equals("B")
					|| list.get(i - 1).equals("B-") || list.get(i - 1).equals("C+") || list.get(i - 1).equals("C")
					|| list.get(i - 1).equals("C-")) {
					answer.add("E");
				} else {
					answer.add("P");
				}
			}

			if (list.get(i).equals("A+")) {
				answer.add("E");
			}
		}

		for (String string : answer) {
			System.out.print(string);
		}

	}
}
