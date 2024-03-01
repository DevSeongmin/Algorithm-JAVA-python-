package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ3067_Coins {

    static int answer;
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input;


        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            N = Integer.parseInt(br.readLine());

            input = br.readLine().split(" ");
            arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }


            int target = Integer.parseInt(br.readLine());
            int[] DP = new int[target + 1];
            DP[0] = 1;
            answer = 0;


            for (int value : arr) {
                for (int i = 0; i <= target; i++) {
                    if (i - value >= 0) {
                        DP[i] = DP[i] + DP[i - value];
                    }
                }
            }


            sb.append(DP[target] + "\n");

        }
        System.out.println(sb);

    }


}
