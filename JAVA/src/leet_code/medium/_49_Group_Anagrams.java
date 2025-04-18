package leet_code.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _49_Group_Anagrams {

	/**
	 * 기존 내 풀이
	 * 단어의 각 알파벳의 개수를 세서 비교하여 체크하는 방식
	 */
	class Solution {
		public List<List<String>> groupAnagrams(String[] strs) {
			int l = strs.length;

			boolean[] visited = new boolean[l];
			int[] alphas = new int[26];

			List<List<String>> answer = new ArrayList<>();


			for (int i = 0; i < l; i++) {
				if (visited[i]) continue;

				ArrayList<String> arr = new ArrayList<>();

				String str = strs[i];
				arr.add(str);
				int strLength = str.length();

				for (int j = 0; j < strLength; j++) {
					alphas[str.charAt(j) - 'a']++;
				}

				for (int j = i+1; j < l; j++) {
					if (visited[j]) continue;
					if (strLength != strs[j].length()) continue;

					int[] tmpAlphas = new int[26];

					for (int k = 0; k < strLength; k++) {
						tmpAlphas[strs[j].charAt(k) - 'a']++;
					}

					boolean flag = true;

					for (int k = 0; k < 26; k++) {
						if(alphas[k] != tmpAlphas[k]) flag = false;
					}

					if (flag){
						arr.add(strs[j]);
						visited[j] = true;
					}

				}
				answer.add(arr);

				for (int j = 0; j < strLength; j++) {
					alphas[str.charAt(j) - 'a']--;
				}
			}

			return answer;
		}
	}

	/**
	 * 리트 코드 Rahul Varma님 풀이
	 * 문자를 charArray로 변환 후 비교하여 문자 비교 단순화
	 */

	class Solution2 {
		public List<List<String>> groupAnagrams(String[] strs) {
			Map<String, List<String>> map = new HashMap<>();

			for (String word : strs) {
				char[] chars = word.toCharArray();
				Arrays.sort(chars);
				String sortedWord = new String(chars);

				if (!map.containsKey(sortedWord)) {
					map.put(sortedWord, new ArrayList<>());
				}

				map.get(sortedWord).add(word);
			}

			return new ArrayList<>(map.values());
		}
	}
}
