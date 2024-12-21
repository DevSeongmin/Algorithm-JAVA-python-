package code_tree.sprint4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class WordAndNumber {
	String word;
	int number;

	public WordAndNumber(String word, int number) {
		this.word = word;
		this.number = number;
	}
}

public class _02_단어_점수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int LENGTH = Integer.parseInt(st.nextToken());
		int TARGET = Integer.parseInt(st.nextToken());

		ArrayList<HashMap<Character, ArrayList<int[]>>> maps = new ArrayList<>();
		for (int i = 0; i < LENGTH; i++) {
			maps.add(new HashMap<>());
		}

		WordAndNumber[] students = new WordAndNumber[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String word = st.nextToken();
			int number = Integer.parseInt(st.nextToken());
			students[i] = new WordAndNumber(word, number);

			for (int j = 0; j < LENGTH; j++) {
				char c = word.charAt(j);
				maps.get(j).putIfAbsent(c, new ArrayList<>());
				maps.get(j).get(c).add(new int[]{i, number});
			}
		}

		int[] scores = new int[N];
		for (int pos = 0; pos < LENGTH; pos++) {
			for (Map.Entry<Character, ArrayList<int[]>> entry : maps.get(pos).entrySet()) {
				ArrayList<int[]> studentList = entry.getValue();
				for (int i = 0; i < studentList.size(); i++) {
					for (int j = i + 1; j < studentList.size(); j++) {
						int[] student1 = studentList.get(i);
						int[] student2 = studentList.get(j);
						if (student1[1] + student2[1] == TARGET) {
							scores[student1[0]]++;
							scores[student2[0]]++;
						}
					}
				}
			}
		}

		for (int score : scores) {
			System.out.println(score);
		}
	}
}

