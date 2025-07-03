package Programmers.pccp모의고사._1회;

import java.util.ArrayList;
import java.util.HashMap;

public class _1번_외톨이_알파벳 {

	class Solution {
		public String solution(String input_string) {

			ArrayList<Character> arr = new ArrayList<>();

			for (char c : input_string.toCharArray()) {
				arr.add(c);
			}

			for (int i = arr.size() -1; i > 0 ; i--) {
				if (arr.get(i) == arr.get(i-1)) {
					arr.remove(i);
				}
			}

			HashMap<Character, Integer> map = new HashMap<>();

			for (char c : arr) {
				map.put(c, map.getOrDefault(c, 0) + 1);
			}

			ArrayList<Character> answer = new ArrayList<>();

			for (char c : map.keySet()) {
				if (map.get(c) > 1) {
					System.out.println(c);
					answer.add(c);
				}
			}

			StringBuilder sb = new StringBuilder();
			for (char c : answer) {
				sb.append(c);
			}

			return answer.isEmpty() ? "N" : sb.toString();
		}
	}
}
