package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15649_N과M {

    static int N;
    static int M;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        answer = new int[M];

        recursion(0, 0);
        System.out.println(sb);
    }



    static void recursion(int depth, int n){
        if (depth == M){
            for (int i : answer) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {

            if (i > n){
                answer[depth] = i;
                recursion(depth + 1, i);
            }


        }

    }



}
