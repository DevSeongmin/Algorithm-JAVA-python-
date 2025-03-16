package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BOJ5670_휴대폰_자판 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;

		while ((line = br.readLine()) != null) {
			try {
				int n = Integer.parseInt(line);
				String[] inputs = new String[n];

				Trie trie = new Trie();

				for (int i = 0; i < n; i++) {
					inputs[i] = br.readLine();
					trie.insert(inputs[i]);
				}

				double answer = 0;
				for (String word : inputs) {
					int clickCnt = 0;

					Node node = trie.root.child[word.charAt(0) - 'a'];
					clickCnt++;

					for (int j = 1; j < word.length(); j++) {
						char c = word.charAt(j);

						int tmpCnt = 0;
						for (int k = 0; k < 26; k++) {
							if (node.child[k] != null) {
								tmpCnt++;
							}
						}

						if (tmpCnt == 1 && !node.isEnd) {
							node = node.child[c - 'a'];
						} else {
							clickCnt++;
							node = node.child[c - 'a'];
						}

					}
					answer += clickCnt;
				}

				// 소수 2번쨰 자리까지 출력
				System.out.println(String.format("%.2f", answer/n));
			} catch (Exception e) {

			}
		}
	}

	static class Node {
		boolean isEnd;
		Node[] child = new Node[26];
		public Node() {
			isEnd = false;
			child = new Node[26];
		}
	}

	static class Trie {

		Node root;

		public Trie() {
			root = new Node();
		}

		public void insert(String word) {
			Node cur = root;
			for (char c : word.toCharArray()) {
				if (cur.child[c - 'a'] == null) {
					cur.child[c - 'a'] = new Node();
				}
				cur = cur.child[c - 'a'];
			}
			cur.isEnd = true;
		}
	}
}
