package baekjoon;

import java.util.Scanner;

public class BOJ10974_모든순열 {

    static int N;
    static int[] answer;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        N = input.nextInt();

        answer = new int[N];
        visited = new boolean[N+1];
        permu(0);
        System.out.println(sb);
    }

    static void permu(int depth){

        if (depth == N){
            for (int i : answer) {
                sb.append(i + " ");
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]){

                answer[depth] = i;
                visited[i] = true;
                permu(depth+1);
                visited[i] = false;
            }
        }
    }
}
