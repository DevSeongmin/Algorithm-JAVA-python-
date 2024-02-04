package baekjoon;

/**
 * 작성자 : 황성민
 * 작성일자 : 24.02.03
 * 문제 접근 및 해결
 * 조합을 구하는 재귀함수를 구현하여 해결한다.
 */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ15655_N과M6 {
    static int N;
    static int M;
    static int[] arr;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        input = br.readLine().split(" ");

        // N과 M 입력
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        // N개의 숫자 배열
        arr = new int[N];
        // 정답상태를 갖고 있는 배열
        answer = new int[M];

        input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        // 사전순 출력을 위해 정렬
        Arrays.sort(arr);

        recursion(0, 0);
        // 정답 출력
        System.out.println(sb);
    }

    static void recursion(int depth, int s){
        // M개를 선택하면 스트링 빌더에 어펜드
        if (depth == M){
            for (int i : answer) sb.append(i + " ");
            sb.append('\n');
            return;
        }


        // s는 이전에 선택한 인덱스를 나타낸다.
        for (int i = s; i < N; i++) {
            answer[depth] = arr[i];
            // 이전 선택 다음 부터 선택
            recursion(depth+1, i+1);
        }

    }
}
