package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15650_N과M2 {

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

        boolean[] visited = new boolean[N+1];
        recursion(0, visited);
        System.out.println(sb);
    }

    static void recursion(int depth, boolean[] visit){

        if (depth == M){
            for (int i : answer) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }


        for (int i = 1; i <= N; i++) {
            if (!visit[i]){
                visit[i] = true;
                answer[depth] = i;
                recursion(depth + 1, visit);
                visit[i] = false;
            }
        }
    }
}
