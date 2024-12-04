package code_tree.sprint19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class _01_코드트리_파일관리 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		String[] input = br.readLine().split(" ");

		PriorityQueue<Integer> pq = new PriorityQueue();

		for (String s : input){
			pq.add(Integer.parseInt(s));
		}

		int answer =0;
		while(pq.size() > 1){
			int sum = pq.poll() + pq.poll();
			pq.add(sum);
			answer+=sum;
		}

		System.out.println(answer);
	}
}