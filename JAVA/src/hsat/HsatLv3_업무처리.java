package hsat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Node {
	Queue<Integer> readyQ = new LinkedList();
	Queue<Integer> completeQ = new  LinkedList();
}

public class HsatLv3_업무처리 {

	static int tailStart;
	static int tailEnd;
	static Node[] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");

		int h = Integer.parseInt(input[0]);
		int work = Integer.parseInt(input[1]);
		int day = Integer.parseInt(input[2]);

		tailStart = (int) Math.pow(2, h);
		tailEnd = (int) Math.pow(2, h+1) - 1;

		tree = new Node[tailEnd+1];

		for (int i = 1; i <= tailEnd; i++) {
			tree[i] = new Node();
		}

		for (int i = tailStart; i <= tailEnd; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < work; j++){
				tree[i].readyQ.add(Integer.parseInt(input[j]));
			}
		}

		for (int i = 1; i <= day; i++) {
			if (i % 2 == 1){
				leftSighn(1);
			} else {
				rightSighn(1);
			}
			working();
		}

		int answer = 0;

		while (!tree[1].completeQ.isEmpty()) {
			answer += tree[1].completeQ.poll();
		}

		System.out.println(answer);
	}

	public static void leftSighn(int node){

		if (tailStart <= node && node <= tailEnd) return;

		if (!tree[node*2].completeQ.isEmpty()){

			tree[node].completeQ.add(tree[node*2].completeQ.poll());
		}

		leftSighn(node*2);
		leftSighn(node*2 + 1);
	}


	public static void rightSighn(int node){

		if (tailStart <= node && node <= tailEnd) return;

		if (!tree[node*2+1].completeQ.isEmpty()){

			tree[node].completeQ.add(tree[node*2+1].completeQ.poll());
		}

		rightSighn(node*2);
		rightSighn(node*2 + 1);
	}


	public static void working() {

		for (int i = tailStart; i <= tailEnd; i++) {
			if (tree[i].readyQ.isEmpty()) continue;

			tree[i].completeQ.add(tree[i].readyQ.poll());
		}
	}
}

