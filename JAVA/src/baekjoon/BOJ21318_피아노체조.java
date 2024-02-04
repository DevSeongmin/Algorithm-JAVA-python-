package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ21318_피아노체조 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        input = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int[] DP = new int[N+1];

        for (int i = 1; i < N; i++) {
            DP[i] = arr[i - 1] > arr[i] ? DP[i - 1] + 1 : DP[i - 1];
        }



        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);

            sb.append(DP[e-1] - DP[s-1] + "\n");
        }


        System.out.println(sb);

    }

}
