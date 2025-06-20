package Programmers;

import java.util.Objects;

public class Lv3_문자열_압축 {

	class Solution {
		public int solution(String s) {
			char[] arr = s.toCharArray();

			int answer = arr.length;

			int stringLength = arr.length;

			for (int l = 1; l <= stringLength/2; l++) {

				int cnt = 0;

				int zipLength = 0;
				int duplicatedCnt = 0;
				StringBuilder beforeString = new StringBuilder();
				StringBuilder curString = new StringBuilder();

				for (int i = 0; i < l; i++) {
					beforeString.append(arr[i]);
				}

				for (int i = 0; i < stringLength; i++) {
					cnt++;
					curString.append(arr[i]);

					if (cnt == l || i == stringLength - 1) {
						cnt = 0;

						if (Objects.equals(beforeString.toString(), curString.toString())) {
							duplicatedCnt++;
						} else {
							zipLength += duplicatedCnt < 2 ? beforeString.length() : beforeString.length() + String.valueOf(duplicatedCnt).length();
							duplicatedCnt = 1;
						}

						beforeString = new StringBuilder(curString);
						curString = new StringBuilder();
					}
				}

				zipLength += duplicatedCnt < 2 ? beforeString.length() : beforeString.length() + String.valueOf(duplicatedCnt).length();
				answer = Math.min(answer, zipLength);
			}

			return answer;
		}
	}
}
