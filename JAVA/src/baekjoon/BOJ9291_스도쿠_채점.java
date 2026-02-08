package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BOJ9291_스도쿠_채점 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= N; i++) {
			List<List<Integer>> list = new ArrayList<>();

			for (int j = 0; j < 9; j++) {
				String input = br.readLine();
				if (input.isBlank()) {
					j--;
					continue;
				}

				String[] inputLine = input.split(" ");
				list.add(Arrays.stream(inputLine).map(Integer::parseInt).collect(Collectors.toList()));
			}

			sb.append("Case ").append(i).append(": ");
			if (isValidSudoku(list)) {
				sb.append("CORRECT");
			} else {
				sb.append("INCORRECT");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	public static boolean isValidSudoku(List<List<Integer>> partialAssigment) {

		if (hasDuplicateRowCol(partialAssigment)){
			return false;
		}

		if (hasDuplicate3x3Box(partialAssigment)) {
			return false;
		}

		return true;
	}
	private static boolean hasDuplicateRowCol(List<List<Integer>> partialAssigment) {
		for (int i = 0; i < partialAssigment.size(); i++) {
			int rowCheck = 0;
			for (int j = 0; j < partialAssigment.get(i).size(); j++) {
				if (partialAssigment.get(i).get(j) == 0) continue;

				if ((rowCheck & (1 << partialAssigment.get(i).get(j))) > 0) {
					return true;
				}
				rowCheck |= (1 << partialAssigment.get(i).get(j));
			}

			int colCheck = 0;
			for (int j = 0; j < partialAssigment.size(); j++) {
				if (partialAssigment.get(j).get(i) == 0) continue;

				if ((colCheck & (1 << partialAssigment.get(j).get(i))) > 0) {
					return true;
				}
				colCheck |= (1 << partialAssigment.get(j).get(i));
			}
		}
		return false;
	}

	private static boolean hasDuplicate3x3Box(List<List<Integer>> partialAssigment) {
		for (int i = 0; i < 9; i += 3) {
			for (int j = 0; j < 9; j += 3) {
				int checker = 0;

				for (int ii = i; ii < i + 3; ii++) {
					for (int jj = j; jj < j + 3; jj++) {
						if (partialAssigment.get(ii).get(jj) == 0) continue;

						if ((checker & (1 << partialAssigment.get(ii).get(jj))) > 0) {
							return true;
						}
						checker |= (1 << partialAssigment.get(ii).get(jj));
					}
				}
			}
		}
		return false;
	}
}
