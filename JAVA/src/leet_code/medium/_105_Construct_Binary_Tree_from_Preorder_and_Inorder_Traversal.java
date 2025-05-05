package leet_code.medium;

import java.util.HashMap;

import leet_code.common.TreeNode;

public class _105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
	class Solution {

		static int[] preorder;
		static int l;
		static HashMap<Integer, Integer> inorderIdxMap;

		public TreeNode buildTree(int[] preorder, int[] inorder) {
			this.preorder = preorder;
			this.l = preorder.length;

			inorderIdxMap = new HashMap<>();

			for (int i = 0; i < l; i++) {
				inorderIdxMap.put(inorder[i], i);
			}

			return build(0, l, 0, l);
		}


		TreeNode build(int ps, int pe, int is, int ie){
			if (ps >= pe || is >= ie) return null;

			int rootVal = preorder[ps];
			TreeNode root = new TreeNode(rootVal);

			int rootIdx = inorderIdxMap.get(rootVal);
			int leftSize = rootIdx - is;

			root.left = build(ps + 1, ps + 1 + leftSize, is, rootIdx);
			root.right = build(ps+1+leftSize, pe, rootIdx + 1, ie);

			return root;
		}
	}
}
