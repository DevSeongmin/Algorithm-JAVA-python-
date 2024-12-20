package code_tree.sprint3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _03_N_QUEEN {

	static int N, answer;
	static int[] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		board = new int[N];

		N_QUEEN(0);
		System.out.println(answer);

	}

	static void N_QUEEN(int depth){

		if (depth == N) {
			answer++;
			return;
		}

		for (int i = 0; i < N; i++) {

			boolean check = true;
			board[depth] = i;

			for (int j =0; j < depth; j++) {
				if (Math.abs(depth - j) == Math.abs(board[depth] - board[j])
					|| board[depth] == board[j]){
					check = false;
					break;
				}
			}

			if (check){
				N_QUEEN(depth + 1);
			}
		}
	}
}