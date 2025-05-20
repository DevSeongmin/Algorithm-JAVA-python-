package leet_code.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import leet_code.common.Node;

public class _133_Clone_Graph {
	class Solution {
		public Node cloneGraph(Node node) {
			if (node == null) return null;

			Queue<Node> q = new LinkedList<>();
			HashSet<Integer> visited = new HashSet<>();
			q.add(node);

			Node copyNode = new Node(node.val);
			q.add(copyNode);

			HashMap<Integer, Node> nodeMap = new HashMap<>();
			nodeMap.put(copyNode.val, copyNode);

			visited.add(node.val);

			while (!q.isEmpty()) {
				Node cur = q.poll();
				Node curCopyNode = q.poll();

				for (Node nextNode : cur.neighbors) {
					Node nextCopyNode = new Node(nextNode.val);
					if (!nodeMap.containsKey(nextCopyNode.val)) {
						nodeMap.put(nextCopyNode.val, nextCopyNode);
					}
					curCopyNode.neighbors.add(nodeMap.get(nextCopyNode.val));

					if (visited.contains(nextNode.val)) continue;

					q.add(nextNode);
					q.add(nextCopyNode);
					visited.add(nextNode.val);
				}
			}
			return copyNode;
		}
	}
}
