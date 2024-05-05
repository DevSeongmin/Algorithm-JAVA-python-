package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1654_랜선자르기 {

    static int[] lANCables;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        lANCables = new int[N];

        long left = 1;
        long right = 0;
        for (int i  = 0; i < N; i++){
            lANCables[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, lANCables[i]);
        }

        long answer = 0;

        while (left <= right){
            long mid = (left + right) / 2;

            long cnt = count(mid);

            if (cnt >= M) {
                left = mid + 1;
                answer = mid;
            } else {
                right = mid-1;
            }
        }
        System.out.println(answer);


    }

    static long count(long len) {
        int sum = 0;
        for (int lANCable : lANCables) {
            sum += lANCable / len;
        }
        return sum;
    }
}
