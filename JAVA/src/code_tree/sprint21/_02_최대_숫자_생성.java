package code_tree.sprint21;

import java.io.*;
import java.util.*;

class MyString implements Comparable<MyString> {
	int idx;
	String number;

	public MyString(int idx, String number){
		this.idx = idx;
		this.number = number;
	}

	void changeNumber(int size) {
		StringBuilder sb = new StringBuilder();
		sb.append(number);

		while (sb.length() < size) {
			sb.append(this.number.charAt(0));
		}

		this.number = sb.toString();
	}

	@Override
	public int compareTo(MyString o) {
		return o.number.compareTo(this.number);
	}
}

public class _02_최대_숫자_생성 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String[] originString = new String[N];
		MyString[] myStrings = new MyString[N];

		int maximumSize = 0;

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			originString[i] = s;
			myStrings[i] = new MyString(i, s);

			maximumSize = Math.max(maximumSize, s.length());
		}

		for (int i = 0; i < N; i++) {
			myStrings[i].changeNumber(maximumSize);
		}

		Arrays.sort(myStrings);

		StringBuilder answer = new StringBuilder();
		for (int i = 0; i < N; i++) {
			answer.append(originString[myStrings[i].idx]);
		}
		System.out.println(answer.toString());
	}
}