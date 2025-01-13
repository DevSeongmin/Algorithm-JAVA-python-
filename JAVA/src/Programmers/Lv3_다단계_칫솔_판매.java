package Programmers;

import java.util.ArrayList;
import java.util.HashMap;

public class Lv3_다단계_칫솔_판매 {

	class Solution {

		static HashMap<String, Node> nameMap = new HashMap();
		static {
			nameMap.put("center", new Node("center"));
		}

		public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

			for (int i = 0; i < enroll.length; i++) {
				String parent = referral[i];
				String name = enroll[i];

				Node node = new Node(name);
				nameMap.put(name, node);

				if (parent.equals("-")) {
					node.parent = "center";
					nameMap.get("center").child.add(node);
				} else {
					node.parent = parent;
					nameMap.get(parent).child.add(node);
				}

				nameMap.put(name, node);
			}

			for (int i = 0; i < seller.length; i++) {
				String name = seller[i];
				int profit = amount[i] * 100;
				recursion(name, profit);
			}

			int[] answer = new int[enroll.length];

			for (int i = 0; i < enroll.length; i++) {
				answer[i] = nameMap.get(enroll[i]).profit;
			}
			return answer;
		}


		static void recursion(String name, int profit) {

			if (profit == 0) {
				return;
			}

			Node node = nameMap.get(name);
			int upValue = profit / 10;
			int myValue = profit - upValue;

			node.profit += myValue;

			if (node.parent == null) {
				return ;
			}

			recursion(node.parent, upValue);
		}
	}

	static 	class Node{
		String name;
		String parent;
		ArrayList<Node> child;
		int profit;

		public Node(String name){
			this.name = name;
			this.child = new ArrayList();
		}
	}
}


