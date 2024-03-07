package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ17136_색종이붙이기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int[][] map = new int[10][10];

        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                if (map[i][j] != 0){
                    map[i][j] = Math.min(5, Math.min(map[i - 1][j - 1], Math.min(map[i][j - 1], map[i - 1][j])) + 1);
                }
            }
        }


        for (int[] m : map) System.out.println(Arrays.toString(m));

    }
}
