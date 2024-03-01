package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2133_타일채우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] DP = new long[31];

        DP[2] = 3;
        DP[4] = 11;

        for (int i = 6; i < 31; i += 2) {
            DP[i] = DP[i - 2] * 4 - DP[i - 4];
        }

        System.out.println(DP[N]);
    }
}
