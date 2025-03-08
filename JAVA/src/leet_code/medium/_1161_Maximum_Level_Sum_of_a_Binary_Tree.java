package leet_code.medium;

import java.util.HashMap;

import leet_code.common.TreeNode;

public class _1161_Maximum_Level_Sum_of_a_Binary_Tree {
	class Solution {
		static HashMap<Integer, Integer> map;

		public int maxLevelSum(TreeNode root) {
			map = new HashMap<>();

			dfs(root, 1);

			int answer = -1;
			int val = Integer.MIN_VALUE;

			for (Integer key : map.keySet()) {
				if (map.get(key) > val) {
					answer = key;
					val = map.get(key);
				}
			}

			return answer;
		}
		static void dfs(TreeNode root,int depth){
			if (root == null) return;

			map.put(depth, map.getOrDefault(depth, 0) + root.val);

			dfs(root.left, depth + 1);
			dfs(root.right, depth + 1);
		}
	}
}
