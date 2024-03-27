package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ1725_히스토그램 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {

            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());

            if (N == 0){
                System.out.println(sb);
                return;
            }

            int[] arr = new int[N + 2];

            for (int i = 1; i < N + 1; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }


            Stack<Integer> stack = new Stack<>();

            long answer = 0;
            for (int i = 0; i < N + 2; i++) {

                while (!stack.isEmpty()) {
                    int tmp = stack.peek();

                    if (arr[tmp] <= arr[i]) break;

                    stack.pop();

                    long height = arr[tmp];

                    answer = Math.max(answer, height * (i - stack.peek() - 1));
                }
                stack.push(i);
            }

            sb.append(answer + "\n");
        }
    }
}
