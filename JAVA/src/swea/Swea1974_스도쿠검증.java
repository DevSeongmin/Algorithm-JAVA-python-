package swea;

import java.util.Scanner;

public class Swea1974_스도쿠검증 {
    public static void main(String[] args) {
        int check = 45;
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();

        for (int tc = 1; tc <= T; tc++) {


            int answer = 1;
            int[][] board = new int[9][9];

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    board[i][j] = input.nextInt();
                }
            }


            for (int i = 0; i < 9; i += 3) {
                for (int j = 0; j < 9; j += 3) {
                    int tmp = 0;
                    for (int i_2 = i; i_2 < i + 3; i_2++) {
                        for (int j_2 = j; j_2 < j + 3; j_2++) {
                            tmp += board[i_2][j_2];

                        }
                    }
                    if (tmp != check) {
                        answer = 0;
                        break;
                    }

                }
            }
            for (int i = 0; i < 9; i++) {
                int tmp_1 = 0;
                int tmp_2 = 0;
                for (int j = 0; j < 9; j++) {

                    tmp_1 += board[i][j];
                    tmp_2 += board[j][i];

                }
                if ((tmp_1 != check) | (tmp_2 != check)) {
                    answer = 0;
                    break;
                }
            }


            System.out.println("#" + tc + " " + answer);
        }
    }
}
