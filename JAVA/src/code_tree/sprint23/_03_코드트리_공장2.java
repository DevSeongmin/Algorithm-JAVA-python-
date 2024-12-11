package code_tree.sprint23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Node {
	int id, value, curBeltNum;
	Node prev, next;

	public Node(int id, int value, int curBeltNum) {
		this.id = id;
		this.value = value;
		this.curBeltNum = curBeltNum;
	}
}

class MyList {
	Node head, tail;
	int size;

	public void addLast(Node node) {
		size++;
		if (head == null) {
			head = tail = node;
			return;
		}
		node.prev = tail;
		tail.next = node;
		tail = node;
	}

	public void addFirst(Node node) {
		size++;
		if (head == null) {
			head = tail = node;
			return;
		}
		node.next = head;
		head.prev = node;
		head = node;
	}

	public void removeFirst() {
		if (head == null) return;

		size--;

		if (head == tail) {
			head = tail = null;
			return;
		}

		Node temp = head;
		head = head.next;
		if (head != null) {
			head.prev = null;
		}
		temp.next = null;
	}
}


public class _03_코드트리_공장2 {
	static int N, M;
	static MyList[] lists;
	static Node[] nodes;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]) + 1;

		lists = new MyList[M];
		nodes = new Node[100_001];

		for (int i = 1; i < M; i++) {
			lists[i] = new MyList();
		}

		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			int id = Integer.parseInt(input[0]);
			int value = Integer.parseInt(input[1]);
			int belt = Integer.parseInt(input[2]);

			Node node = new Node(id, value, belt);
			nodes[id] = node;
			lists[belt].addLast(node);
		}

		int Q = Integer.parseInt(br.readLine());

		for (int i = 0; i < Q; i++) {
			input = br.readLine().split(" ");
			int q = Integer.parseInt(input[0]);

			switch (q) {
				case 1:
					delivery(Integer.parseInt(input[1]));
					break;
				case 2:
					move(Integer.parseInt(input[1]), Integer.parseInt(input[2]));
					break;
				case 3:
					clean(Integer.parseInt(input[1]));
					break;
				case 4:
					del(Integer.parseInt(input[1]));
					break;
				case 5:
					find(Integer.parseInt(input[1]), Integer.parseInt(input[2]));
					break;
			}
		}
		System.out.print(sb);
	}

	static void delivery(int findValue) {
		int diff = Integer.MAX_VALUE;
		int findBelt = -1;

		for (int i = 1; i < M; i++) {
			if (lists[i].head == null) continue;

			int curDiff = Math.abs(lists[i].head.value - findValue);
			if (curDiff < diff ) {
				diff = curDiff;
				findBelt = i;
			}
		}

		if (findBelt == -1) {
			sb.append("-1\n");
			return;
		}

		Node node = lists[findBelt].head;
		sb.append(node.value + findBelt).append("\n");
		nodes[node.id] = null;
		lists[findBelt].removeFirst();
	}

	static void move(int start, int end) {
		if (lists[start].size == 0) return;

		int moveCnt = (lists[start].size + 2) / 3;
		List<Node> tmp = new ArrayList<>();

		for (int i = 0; i < moveCnt; i++) {
			Node node = lists[start].head;
			if (node == null) break;
			node.curBeltNum = end;
			tmp.add(node);
			lists[start].removeFirst();
		}

		for (int i = tmp.size()-1; i >= 0; i--) {
			lists[end].addFirst(tmp.get(i));
		}
	}

	static void clean(int beltNum) {
		while(lists[beltNum].head != null) {
			Node curNode = lists[beltNum].head;
			lists[beltNum].removeFirst();

			int moveBelt = curNode.value % (M - 1) + 1;
			if (moveBelt == beltNum) moveBelt = 1;

			curNode.curBeltNum = moveBelt;
			lists[moveBelt].addFirst(curNode);
		}
	}

	static void del(int nodeId) {
		if (nodes[nodeId] == null) return;

		Node removeNode = nodes[nodeId];
		int beltNum = removeNode.curBeltNum;

		if (removeNode.prev == null && removeNode.next == null) {
			lists[beltNum].head = lists[beltNum].tail = null;
		} else if (removeNode.prev == null) {
			lists[beltNum].head = removeNode.next;
			removeNode.next.prev = null;
		} else if (removeNode.next == null) {
			lists[beltNum].tail = removeNode.prev;
			removeNode.prev.next = null;
		} else {
			removeNode.prev.next = removeNode.next;
			removeNode.next.prev = removeNode.prev;
		}

		lists[beltNum].size--;
		nodes[nodeId] = null;
	}

	static void find(int belt, int idx) {
		if (lists[belt].size < idx) {
			sb.append("-1\n");
			return;
		}

		Node curNode = lists[belt].head;
		for (int i = 1; i < idx; i++) {
			curNode = curNode.next;
		}
		sb.append(curNode.id).append("\n");
	}
}

