package swea;

import java.util.Scanner;

public class Swea1961_숫자_배열_회전 {

    public static int[][] Rotation(int[][] arr) {
        int l = arr.length;
        int[][] result = new int[l][l];

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                result[i][j] = arr[l-j-1][i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = input.nextInt();

            int arr[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = input.nextInt();
                }
            }

            int[][] result_90 = Rotation(arr);
            int[][] result_180 = Rotation(result_90);
            int[][] result_270 = Rotation(result_180);


            System.out.println("#" + tc);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(result_90[i][j]);
                }
                System.out.print(" ");
                for (int j = 0; j < N; j++) {
                    System.out.print(result_180[i][j]);
                }
                System.out.print(" ");
                for (int j = 0; j < N; j++) {
                    System.out.print(result_270[i][j]);
                }
                System.out.println();
            }

        }






    }

}
