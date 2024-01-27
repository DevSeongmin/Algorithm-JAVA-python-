package baekjoon;


/**
 * 작성자 : 황성민
 * 작성일자 : 24.01.27
 * 접근 및 풀이
 * N과 M 시리즈는
 *
 *         for (int i = 0; i <= N; i++) {
 *             recursion(depth+1);
 *
 * 기본 적으로 다음과 같은 재귀에서 출발할 수 있다.
 * 저 경우는 모든 중복 조합을 뽑느 경우인데
 * 다른 문제들도 기본 틀을 중복 조합(모든 경우)으로 잡고
 * 상태 공간 트리를 그려
 * 어느 부분에서 상태공간 트리의 가지를 칠 지
 * 생각함으로 헤결힐 수 있다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15651_N과M3 {

    static int N, M;
    static int[] arr;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];

        recursion(0);
        System.out.println(sb);
    }

    static void recursion(int depth){
        if (depth == M){
            for (int i : arr) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {

            arr[depth] = i;
            recursion(depth+1);
        }
    }
}
