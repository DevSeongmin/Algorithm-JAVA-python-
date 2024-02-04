package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 작성자 : 황성민
 * 작성일자 : 24.02.03
 * 스택을 이용하여 해결
 */

public class BOJ_2493_탑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        // 탑의 개수
        int N = Integer.parseInt(br.readLine());

        int[] tops = new int[N];
        // 정답 배열
        int[] answer = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 탑의 정보 입력
        for (int i = 0; i < N; i++) {
            tops[i] = Integer.parseInt(st.nextToken());
        }

        // 탑의 뒤부터 시작
        for (int i = N - 1; i >= 0; i--) {
            // 만약 스택이 비어있다면 그냥 넣어주고 건너뜀
            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }

            // 만약 현재 넣는 탑의 높이보다 더 작은 값이 스택에 있다면
            // 더 작은 값의 인덱스에 현재 넣는 탑의 인덱스를 넣어줌으로 문제 해결
            while (!stack.isEmpty() && tops[stack.peek()] < tops[i]) answer[stack.pop()] = i + 1;
            stack.push(i);
        }


        StringBuilder sb = new StringBuilder();

        for (int i : answer) sb.append(i + " ");

        System.out.println(sb);

    }
}
