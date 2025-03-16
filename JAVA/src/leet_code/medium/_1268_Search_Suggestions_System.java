package leet_code.medium;

import java.util.ArrayList;
import java.util.List;

public class _1268_Search_Suggestions_System {
	class Solution {
		public List<List<String>> suggestedProducts(String[] products, String searchWord) {

			Trie trie = new Trie();

			for (String product : products) {
				trie.insert(product);
			}

			List<List<String>> answer = new ArrayList();

			StringBuilder sb = new StringBuilder();
			TrieNode pointer = trie.root;

			for (char c : searchWord.toCharArray()) {
				sb.append(c);

				if (pointer == null || pointer.child[c - 'a'] == null) {
					answer.add(new ArrayList<>());
					pointer = null;
					continue;
				}

				pointer = pointer.child[c - 'a'];
				List<String> list = new ArrayList<>();
				dfs(pointer, sb, list);
				answer.add(new ArrayList(list));

			}


			return answer;
		}
		static void dfs(TrieNode pointer, StringBuilder sb, List list) {
			if (list.size() >= 3) return;

			if (pointer.isEnd) {
				list.add(sb.toString());
			}

			for (int i = 0; i < 26; i++) {
				if (pointer.child[i] == null) continue;

				sb.append((char) ('a' + i));
				dfs(pointer.child[i], sb, list);
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}

	class Trie{
		TrieNode root = new TrieNode();

		public void insert(String text) {
			TrieNode pointer = this.root;

			for (char c : text.toCharArray()) {
				int n = c - 'a';

				if (pointer.child[n] == null) {
					pointer.child[n] = new TrieNode();
				}

				pointer = pointer.child[n];
			}

			pointer.end();
		}
	}

	class TrieNode {
		boolean isEnd;
		TrieNode[] child;

		public TrieNode() {
			this.isEnd = false;
			this.child = new TrieNode[26];
		}

		public void end() {
			this.isEnd = true;
		}
	}
}
