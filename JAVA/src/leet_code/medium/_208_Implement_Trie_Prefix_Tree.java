package leet_code.medium;

public class _208_Implement_Trie_Prefix_Tree {
	static class Trie {
		private TrieNode trie;

		public Trie() {
			trie = new TrieNode();
		}

		public void insert(String word) {
			TrieNode pointer = this.trie;

			for (char c : word.toCharArray()) {
				int n = c - 'a';

				if (pointer.child[n] == null) {
					pointer.child[n] = new TrieNode();
				}

				pointer = pointer.child[n];
			}

			pointer.end();
		}

		public boolean search(String word) {
			TrieNode pointer = this.trie;

			for (char c : word.toCharArray()) {
				int n = c - 'a';

				if (pointer.child[n] == null) {
					return false;
				}

				pointer = pointer.child[n];
			}

			return pointer.isEnd();
		}

		public boolean startsWith(String prefix) {
			TrieNode pointer = this.trie;

			for (char c : prefix.toCharArray()) {
				int n = c - 'a';

				if (pointer.child[n] == null) {
					return false;
				}

				pointer = pointer.child[n];
			}

			return true;
		}
	}

	static class TrieNode {
		boolean isEnd;
		TrieNode[] child;

		public TrieNode() {
			this.isEnd = false;
			this.child = new TrieNode[26];
		}

		public boolean isEnd() {
			return this.isEnd;
		}

		public void end() {
			isEnd = true;
		}
	}
}
