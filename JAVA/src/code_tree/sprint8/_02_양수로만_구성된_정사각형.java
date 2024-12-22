package code_tree.sprint8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _02_양수로만_구성된_정사각형 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int Y = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		boolean[][] board = new boolean[Y][X];

		for (int i = 0; i < Y; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < X; j++) {
				board[i][j] = Integer.parseInt(st.nextToken()) > 0 ? true : false;
			}
		}

		int answer = -1;

		for (int ySize = Y; ySize > 0; ySize--){
			for (int xSize = X; xSize > 0; xSize--){

				for (int startY = 0; startY <= Y - ySize; startY++) {
					for (int startX = 0; startX <= X - xSize; startX++){

						boolean flag = true;
						for (int y = startY; y < startY + ySize; y++) {
							for (int x = startX; x < startX + xSize; x++) {
								flag &= board[y][x];
							}
						}

						if (flag) {
							answer = Math.max(ySize * xSize, answer);
						}
					}
				}
			}
		}
		System.out.println(answer);
	}
}