package leet_code.medium;

import java.util.HashMap;

import leet_code.common.TreeNode;

public class _106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
	class Solution {
		HashMap<Integer, Integer> inIdxMap = new HashMap<>();
		int l;
		int[] postorder;

		public TreeNode buildTree(int[] inorder, int[] postorder) {
			this.l = inorder.length;
			this.postorder = postorder;

			for (int i = 0; i < l; i++) {
				inIdxMap.put(inorder[i], i);
			}

			return build(0, l, 0, l);
		}

		TreeNode build(int is, int ie, int ps, int pe) {

			if (is >= ie || ps >= pe) return null;

			int rootVal = postorder[pe-1];
			TreeNode root = new TreeNode(rootVal);

			int inRootIdx = inIdxMap.get(rootVal);

			int leftSize = inRootIdx - is;

			root.left = build(is, is+leftSize, ps, ps + leftSize);
			root.right = build(inRootIdx + 1, ie, ps+leftSize, pe - 1);


			return root;
		}
	}
}
