package leet_code.medium;

public class _427_Construct_Quad_Tree {
	class Solution {
		public Node construct(int[][] grid) {
			return check(grid, 0, 0, grid.length);
		}

		Node check(int[][] grid, int sy, int sx, int l){
			if (l == 1) {
				return new Node(grid[sy][sx] == 1, true);
			}

			int halfL = l / 2;

			Node lt = check(grid, sy, sx, halfL);
			Node rt = check(grid, sy, sx + halfL, halfL);
			Node lb = check(grid, sy + halfL, sx, halfL);
			Node rb = check(grid, sy + halfL, sx + halfL, halfL);

			if (lt.isLeaf && rt.isLeaf && lb.isLeaf && rb.isLeaf &&
				lt.val == rt.val && rt.val == lb.val && lb.val == rb.val) {
				return new Node(lt.val, true);
			}

			return new Node(false, false, lt, rt, lb, rb );
		}
	}

	class Node {
		public boolean val;
		public boolean isLeaf;
		public Node topLeft;
		public Node topRight;
		public Node bottomLeft;
		public Node bottomRight;


		public Node() {
			this.val = false;
			this.isLeaf = false;
			this.topLeft = null;
			this.topRight = null;
			this.bottomLeft = null;
			this.bottomRight = null;
		}

		public Node(boolean val, boolean isLeaf) {
			this.val = val;
			this.isLeaf = isLeaf;
			this.topLeft = null;
			this.topRight = null;
			this.bottomLeft = null;
			this.bottomRight = null;
		}

		public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
			this.val = val;
			this.isLeaf = isLeaf;
			this.topLeft = topLeft;
			this.topRight = topRight;
			this.bottomLeft = bottomLeft;
			this.bottomRight = bottomRight;
		}
	}
}
