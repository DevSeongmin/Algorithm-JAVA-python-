package code_tree.sprint15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class _03_알파벳_조합 {

	static String word;
	static int SIZE, cnt;
	static HashMap<Character, Integer> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		word = br.readLine();
		SIZE = word.length();

		for (int i = 0; i < SIZE; i++) {
			char c = word.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		recursion("");
	}

	static void recursion(String newWord) {
		if (cnt == 10_000) return;

		if (newWord.length() == SIZE) {
			cnt++;
			System.out.println(newWord);
			return;
		}

		for(char c = 'a'; c <= 'z'; c++) {
			if(map.getOrDefault(c, 0) > 0) {
				map.put(c, map.get(c) - 1);
				recursion(newWord + c);
				map.put(c, map.get(c) + 1);
			}
		}
	}
}