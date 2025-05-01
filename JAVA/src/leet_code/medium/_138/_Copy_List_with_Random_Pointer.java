package leet_code.medium._138;

import java.util.HashMap;

import leet_code.common.Node;

public class _Copy_List_with_Random_Pointer {

	class MySolution {
		public Node copyRandomList(Node head) {

			if (head == null) return head;

			HashMap<Node, Integer> nodeIdxMap = new HashMap<>();
			HashMap<Integer, Node> copyIdxNodeMap = new HashMap<>();

			Node copyHead = new Node(head.val);
			Node copyNode = copyHead;

			nodeIdxMap.put(head, 0);
			copyIdxNodeMap.put(0, copyHead);

			Node node = head;

			int idx = 1;
			while (node.next != null) {

				nodeIdxMap.put(node.next, idx);
				copyNode.next = new Node(node.next.val);
				copyIdxNodeMap.put(idx, copyNode.next);

				idx++;
				node = node.next;
				copyNode = copyNode.next;
			}

			copyNode = copyHead;

			while (head != null) {

				if (head.random != null) {

					System.out.println("origin  " + head);
					System.out.println("copy  " + copyNode);

					Integer randIdx = nodeIdxMap.get(head.random);
					copyNode.random = copyIdxNodeMap.get(randIdx);
				}

				head = head.next;
				copyNode = copyNode.next;
			}

			return copyHead;
		}
	}






	class OptimizedSolution {
		public Node copyRandomList(Node head) {

			HashMap<Node, Node> nodeMap = new HashMap<>();
			Node node = head;

			while (node != null) {
				nodeMap.put(node, new Node(node.val));
				node = node.next;
			}

			node = head;

			while (node != null) {
				Node copy = nodeMap.get(node);
				copy.next = nodeMap.get(node.next);
				copy.random = nodeMap.get(node.random);
				node = node.next;
			}

			return nodeMap.get(head);
		}
	}
}
