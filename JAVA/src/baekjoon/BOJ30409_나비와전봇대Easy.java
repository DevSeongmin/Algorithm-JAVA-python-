

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ30409_나비와전봇대Easy {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input;

        int N = Integer.parseInt(br.readLine());

        input = br.readLine().split(" ");

        Long[] poles = new Long[N];

        for (int i = 0; i < N; i++) poles[i] = Long.parseLong(input[i]);


        long leftDP[] = new long[N];
        Stack<Integer> stack = new Stack<>();

        long value = 0;
        for (int i = 0; i < N; i++) {

            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }


            if (poles[stack.peek()] >= poles[i]) {

                long y = poles[i] - poles[stack.peek()];
                long x = i - stack.peek();

                value += (x * x + y * y);
                stack.push(i);


            } else {
                while (!stack.isEmpty() && poles[stack.peek()] < poles[i]) {

                    stack.pop();
                }

                if (!stack.isEmpty()) {
                    long y = poles[i] - poles[stack.peek()];
                    long x = i - stack.peek();
                    value = (y * y) + (x * x) + leftDP[stack.peek()];
                } else {
                    value = 0;
                }

                stack.push(i);
            }
            leftDP[i] = value;
        }

//////////////////////////////////////////////////////////////////////////////////////

        long[] rightDP= new long[N];
        stack = new Stack<>();
        value = 0;

        for (int i = N-1; i >= 0; i--) {

            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }

            if (poles[stack.peek()] >= poles[i]) {

                long y = poles[i] - poles[stack.peek()];
                long x = i - stack.peek();

                value += (x * x + y * y);
                stack.push(i);


            } else {
                while (!stack.isEmpty() && poles[stack.peek()] < poles[i]) {

                    stack.pop();
                }

                if (!stack.isEmpty()) {
                    long y = poles[i] - poles[stack.peek()];
                    long x = i - stack.peek();
                    value = (y * y) + (x * x) + rightDP[stack.peek()];
                } else {
                    value = 0;
                }


                stack.push(i);
            }
            rightDP[i] = value;
        }


        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(leftDP[n-1] + rightDP[n-1] + "\n");
        }

        System.out.print(sb);
    }
}
