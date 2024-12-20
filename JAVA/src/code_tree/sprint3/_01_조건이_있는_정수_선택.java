package code_tree.sprint3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Tuple{
	int a, b, c;

	public Tuple(int a, int b, int c){
		int[] arr =  {a, b, c};
		Arrays.sort(arr);
		this.a = arr[0];
		this.b = arr[1];
		this.c = arr[2];
	}

	@Override
	public boolean equals(Object o){
		Tuple tuple = (Tuple) o;
		return this.a == tuple.a && this.b == tuple.b && this.c == tuple.c;
	}

	@Override
	public int hashCode() {
		return Objects.hash(a, b, c);
	}
}

public class _01_조건이_있는_정수_선택 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);

		Set<Tuple> set = new HashSet();

		for (int i = 0; i < K; i++) {
			input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);

			for (int c = 1; c <= N; c++) {
				if (c != a && c != b){
					set.add(new Tuple(a, b, c));
				}
			}
		}

		int allCount = (N * (N-1) * (N-2)) / 6;

		System.out.println(allCount - set.size());
	}
}