package leet_code.medium;

import java.util.HashMap;

public class _146_LRU_Cache {
	class LRUCache {
		HashMap<Integer, DoublyNode> map;
		DoublyNode head;
		DoublyNode tail;
		int size;
		int limit;

		public LRUCache(int capacity) {
			map = new HashMap<>();
			limit = capacity;

			head = new DoublyNode(0, 0);
			tail = new DoublyNode(0, 0);
			head.next = tail;
			tail.prev = head;
		}

		public int get(int key) {

			DoublyNode node = map.get(key);
			if (node != null) {
				remove(node);
				add(node);
				return node.val;
			}
			return -1;
		}

		public void put(int key, int value) {
			DoublyNode newNode = new DoublyNode(key, value);
			DoublyNode delNode;

			if (map.containsKey(key)) {
				delNode = map.get(key);
				map.remove(delNode.key);
				remove(delNode);
			} else if (size >= limit) {
				delNode = head.next;
				map.remove(delNode.key);
				remove(delNode);
			} else {
				size++;
			}

			add(newNode);
			map.put(key, newNode);
		}

		public void remove(DoublyNode node) {
			DoublyNode prevNode = node.prev;
			DoublyNode nextNode = node.next;

			prevNode.next = nextNode;
			nextNode.prev = prevNode;
		}

		public void add(DoublyNode node) {
			DoublyNode tPrev = tail.prev;

			tail.prev = node;
			node.next = tail;

			node.prev = tPrev;
			tPrev.next = node;
		}
	}
	class DoublyNode{
		int key, val;
		DoublyNode prev, next;

		public DoublyNode(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}
}
