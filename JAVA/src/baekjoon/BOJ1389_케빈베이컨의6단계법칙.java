package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1389_케빈베이컨의6단계법칙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        input = br.readLine().split(" ");

        int Node = Integer.parseInt(input[0]);
        int Edge = Integer.parseInt(input[1]);

        int[][] Matrix = new int[Node][Node];

        for (int[] m : Matrix) Arrays.fill(m, 101);

        for (int i = 0; i < Edge; i++) {
            input = br.readLine().split(" ");
            int n1 = Integer.parseInt(input[0]);
            int n2 = Integer.parseInt(input[1]);
            Matrix[n1-1][n2-1] = 1;
            Matrix[n2-1][n1-1] = 1;
        }


        for (int i = 0; i < Node; i++) {
            Matrix[i][i] = 0;
        }

        for (int t = 0; t < Node; t++) {
            for (int s = 0; s < Node; s++) {
                for (int e = 0; e < Node; e++) {
                    Matrix[s][e] = Math.min(Matrix[s][e], Matrix[s][t] + Matrix[t][e]);
                }
            }
        }

        int currentSum = Integer.MAX_VALUE;
        int answer = -1;

        for (int i = 0; i < Node; i++) {

            int sum = Arrays.stream(Matrix[i]).sum();

            if (sum < currentSum){
                currentSum = sum;
                answer = i;
            }
        }
        System.out.println(answer + 1);
    }
}
