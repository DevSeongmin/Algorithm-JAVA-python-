package leet_code.medium;

import java.util.LinkedList;
import java.util.Queue;

public class _211_Design_Add_and_Search_Words_Data_Structure {
	class WordDictionary {

		Node head;

		public WordDictionary() {
			head = new Node();
		}

		public void addWord(String word) {
			Node node = head;

			for (char c : word.toCharArray()) {

				int charToInt = c - 'a';

				if (node.children[charToInt] == null) {
					node.children[charToInt] = new Node();
					node = node.children[charToInt];

				} else {
					node = node.children[charToInt];
				}
			}

			node.isEnd = true;
		}

		public boolean search(String word) {
			int l = word.length();

			Queue<Node> q = new LinkedList<>();
			q.add(head);

			int depth = 0;

			while (!q.isEmpty()) {

				int qSize = q.size();

				if(depth == l) break;

				for (int ps = 0; ps < qSize; ps++) {
					Node cur = q.poll();

					for (int i = 0; i < 26; i++){
						if (word.charAt(depth) - 'a' == i && cur.children[i] != null) {
							q.add(cur.children[i]);
						}

						if (word.charAt(depth) == '.' && cur.children[i] != null) {
							q.add(cur.children[i]);
						}
					}
				}
				depth++;
			}

			while (!q.isEmpty()) {
				if (q.poll().isEnd) return true;
			}

			return false;
		}

		class Node {
			boolean isEnd;
			Node[] children = new Node[26];
			public Node() {
				children = new Node[26];
			}
		}
	}
}
