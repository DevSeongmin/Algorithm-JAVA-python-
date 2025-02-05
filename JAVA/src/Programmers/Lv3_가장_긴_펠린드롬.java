package Programmers;

public class Lv3_가장_긴_펠린드롬 {
	class Solution{
		public int solution(String s){
			int answer = 1;

			int l = s.length();

			for (int i = 0; i < l; i++) {
				int left = i-1;
				int right = i+1;

				int cnt = 1;
				while (0 <= left && right < l && s.charAt(left) == s.charAt(right)) {
					cnt+=2;
					left--;
					right++;
				}

				answer = Math.max(answer, cnt);

				left = i-1;
				right = i;
				cnt = 0;

				while (0 <= left && right < l && s.charAt(left) == s.charAt(right)) {
					cnt+=2;
					left--;
					right++;
				}

				answer = Math.max(answer, cnt);
			}

			return answer;
		}
	}
}
