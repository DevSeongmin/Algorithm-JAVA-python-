package leet_code.medium;

public class _6_Zigzag_Conversion {
	class Solution {

		static int Y, X;
		static int[] dy = {1, -1};
		static int[] dx = {0, 1};

		public String convert(String s, int numRows) {
			Y = numRows;
			X = s.length();

			if (Y == 1) return s;

			int idx = 0;

			char[][] charArr = new char[Y][X];

			int cy = 0;
			int cx = 0;
			int dir = 0;

			while (idx < s.length()) {
				charArr[cy][cx] = s.charAt(idx++);

				if (!isIn(cy + dy[dir], cx + dx[dir])) {
					dir = (dir+1) % 2;
				}

				cy += dy[dir];
				cx += dx[dir];
			}

			StringBuilder sb = new StringBuilder();

			for (char[] c : charArr) {
				sb.append(c);
			}

			return sb.toString().replace("\u0000", "");
		}
		static boolean isIn(int y, int x) {
			return 0 <= y && y < Y && 0 <= x && x < X;
		}
	}
}
