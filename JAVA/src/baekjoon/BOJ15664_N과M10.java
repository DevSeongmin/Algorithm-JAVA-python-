package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ15664_N과M10 {

    static int N, M;
    static int[] arr;
    static int[] answer;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        answer = new int[M];
        arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        recursion(0,0);

        System.out.println(sb);

    }
    static void recursion(int s, int depth){
        if (depth == M){
            for (int i : answer) {
                sb.append(i + " ");
            }
            sb.append('\n');

            return;
        }

        int before = -1;
        for (int i = s; i < N; i++) {
            if (before == arr[i]) {
                continue;
            }

            before = arr[i];
            answer[depth] = arr[i];
            recursion(i+1, depth + 1);
        }

    }
}
