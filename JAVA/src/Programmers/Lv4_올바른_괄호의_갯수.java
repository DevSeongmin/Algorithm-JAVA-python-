package Programmers;

public class Lv4_올바른_괄호의_갯수 {

	// class Solution {

	//     static int answer = 0;
	//     static int N;

	//     public int solution(int n) {
	//         N = 2 * n;

	//         recursion(0, 0, 0);

	//         return answer;
	//     }

	//     static void recursion(int depth, int open, int close) {

	//         if (depth >= N) {
	//             if (open == close){
	//                 answer++;
	//             }
	//             return;
	//         }

	//         if (open < close) return;

	//         recursion(depth+1, open+1, close);
	//         recursion(depth+1, open, close+1);
	//     }
	// }

	class Solution {
		public int solution(int n) {

			int[] DP = new int[16];

			DP[0] = 1;
			DP[1] = 1;
			DP[2] = 2;
			DP[3] = 5;


			for (int i = 4; i < 16; i++) {

				for (int j = 0; j < i; j++) {
					DP[i] += (DP[j] * DP[i-j -1]);
				}
			}

			return DP[n];
		}
	}
}
