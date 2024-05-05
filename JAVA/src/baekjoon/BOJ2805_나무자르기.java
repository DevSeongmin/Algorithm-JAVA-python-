package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2805_나무자르기 {

    static int[] trees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        trees = new int[N];
        for (int i = 0; i < N; i++){
            trees[i] = Integer.parseInt(st.nextToken());
        }

        long left = 0;
        long right = 2_000_000_000;
        long answer = 0;


        while (left <= right) {
            long mid =  (left + right) / 2;
            long val = value(mid);

            if (val >= target) {
                left = mid + 1;
                answer = mid;
            } else{
                right = mid - 1;
            }
        }

        System.out.println(answer);

    }
    static long value(long mid) {
        long sum = 0;
        for (int tree : trees) {
            sum += Math.max(tree - mid, 0);
        }
        return sum;
    }
}
