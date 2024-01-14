package baekjoon;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class Boj2447_별찍기_10 {
    static Character[][] arr;

    public static void main(String[] args)  throws IOException {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        arr = new Character[N][N];
        for (Character[] a : arr){
            Arrays.fill(a, ' ');
        }

        recursion(0,0,N);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }



    }
    static public void recursion(int y, int x, int N) {
        if (N == 1) {
            arr[y][x] = '*';
            return;
        }

        for (int i = y; i < y + N; i += (N / 3)) {
            for (int j = x; j < x + N; j += (N / 3)) {

                if (i == y + N / 3 && j == x + N / 3) {
                    continue;
                }
                recursion(i,j,N/3);

            }
        }


    }
}
