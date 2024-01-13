package baekjoon;

import java.util.HashMap;
import java.util.Scanner;

public class BOJ1780_종이의_개수 {


    static int N;
    static int[][] arr;

    static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        map.put(-1, 0);
        map.put(0, 0);
        map.put(1, 0);

        N = input.nextInt();
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = input.nextInt();
            }
        }
        recursion(0, 0, N);

        for (int i = -1; i <= 1; i++) {
            System.out.println(map.get(i));
        }
    }


    public static void recursion(int startY, int startX, int N) {
        int standard = arr[startY][startX];
        boolean flag = true;

        for (int i = startY; i < startY + N; i++) {
            for (int j = startX; j < startX + N; j++) {
                if (arr[i][j] != standard) {
                    flag = false;
                    break;
                }
            }
        }

        if (flag) {
            map.put(standard, map.get(standard) + 1);
            return;
        }

        for (int i = startY; i < startY + N; i += N / 3) {
            for (int j = startX; j < startX + N; j += N / 3) {
                recursion(i, j, N / 3);
            }
        }


    }
}
