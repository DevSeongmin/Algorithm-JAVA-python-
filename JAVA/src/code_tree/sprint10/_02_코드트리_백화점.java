package code_tree.sprint10;

import java.util.*;
import java.io.*;

class Counter implements Comparable<Counter> {
	int counterNum, t;

	public Counter(int counterNum, int t) {
		this.counterNum = counterNum;
		this.t = t;
	}

	@Override
	public int compareTo( Counter o) {
		if (this.t == o.t) {
			return Integer.compare(this.counterNum, o.counterNum);
		}
		return Integer.compare(this.t, o.t);
	}
}

class Customer implements Comparable<Customer> {
	int id, t, counterNum;

	public Customer(int id, int t, int counterNum) {
		this.id = id;
		this.t = t;
		this.counterNum = counterNum;
	}

	@Override
	public int compareTo(Customer o){
		return this.t == o.t ? Integer.compare(this.counterNum, o.counterNum) : Integer.compare(this.t, o.t);
	}
}

public class _02_코드트리_백화점 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		PriorityQueue<Counter> pq = new PriorityQueue();

		for (int i = 0; i < K; i++) {
			pq.add(new Counter(i, 0));
		}

		PriorityQueue<Customer> customerPQ = new PriorityQueue();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			Counter counter = pq.poll();

			int id = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken()) + counter.t;
			pq.add(new Counter(counter.counterNum, t));

			customerPQ.add(new Customer(id, t, counter.counterNum));
		}

		for (int i = 0; i < X-1; i++) {
			customerPQ.poll();
		}

		System.out.println(customerPQ.poll().id);
	}
}