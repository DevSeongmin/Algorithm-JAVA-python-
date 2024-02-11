package baekjoon;

/**
 * 작성자 : 황성민
 * 작성일자 : 24.02.11
 * 문제풀이 : 카탈랑 수
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ21739_펭귄네비게이터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] DP = new long[10001];

        DP[0] = 1;
        DP[1] = 1;
        DP[2] = 2;
        DP[3] = 5;

        for (int i = 4; i < 10001; i++) {
            long value = 0;
            for (int j = 0; j < i; j++) value = (value + DP[j] * DP[i - j - 1]) % ((long)Math.pow(10, 9) + 7);
            DP[i] = value;
        }

        int n = Integer.parseInt(br.readLine());


        System.out.println(DP[n]);


    }
}
