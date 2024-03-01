package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ17952_과제는끝나지않아 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;


        int score = 0;
        int N = Integer.parseInt(br.readLine());

        Stack<Assignment> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");

            if (input[0].equals("1")) {
                if (input[2].equals("1")) {
                    score += Integer.parseInt(input[1]);
                } else {
                    stack.push(new Assignment(Integer.parseInt(input[1]), Integer.parseInt(input[2]) - 1));
                }
            } else {
                if (!stack.isEmpty()) {
                    stack.peek().t -= 1;
                    if (stack.peek().t == 0) {
                        score += stack.pop().s;
                    }
                }
            }
        }

        System.out.println(score);

    }


    static class Assignment {
        int s;
        int t;

        public Assignment(int s, int t) {
            this.s = s;
            this.t = t;
        }
    }
}
