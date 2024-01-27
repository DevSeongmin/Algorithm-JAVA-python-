package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15652_N과M4 {

    static int N, M;
    static int[] arr;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];

        recursion(0,1);
        System.out.println(sb);
    }

    static void recursion(int depth, int s){
        if (depth == M){
            for (int i : arr) {
                sb.append(i + " ");
            }
            sb.append('\n') ;
            return;
        }

        for (int i = 1; i <= N; i++){
            if (i >= s){
                arr[depth] = i;
                recursion(depth+ 1, i);
            }
        }
    }
}
