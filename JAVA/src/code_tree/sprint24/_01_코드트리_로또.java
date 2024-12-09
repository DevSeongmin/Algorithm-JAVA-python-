package code_tree.sprint24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class _01_코드트리_로또 {

	static int N, M;
	static ArrayList<Integer> arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		arr = new ArrayList();

		combi(1, 0);

	}

	static void combi(int idx, int depth){
		if (depth == M) {
			print(arr);
			return;
		}
		for (int i = idx; i <= N; i++) {
			arr.add(i);
			combi(i+1, depth+1);
			arr.remove(arr.size() - 1);
		}

	}
	static void print(ArrayList<Integer> arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}