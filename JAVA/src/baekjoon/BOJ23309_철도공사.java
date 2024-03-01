package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ23309_철도공사 {

    static StringBuilder sb = new StringBuilder();
    static int[] beforeStation = new int[1_000_001];
    static int[] nextStation = new int[1_000_001];



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);

        int[] sub = new int[N];

        input = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            sub[i] = Integer.parseInt(input[i]);
        }

        for (int i = 0; i < N; i++) {
            if (i == 0){
                beforeStation[sub[i]] = sub[N-1];
                nextStation[sub[i]] = sub[i + 1];

            } else if (i == N - 1) {
                beforeStation[sub[i]] = sub[i-1];
                nextStation[sub[i]] = sub[0];

            } else{
                beforeStation[sub[i]] = sub[i-1];
                nextStation[sub[i]] = sub[i+1];
            }
        }



        for (int i = 0; i < C; i++) {
            input = br.readLine().split(" ");

            if (input[0].equals("BN")) {
                BN(Integer.parseInt(input[1]), Integer.parseInt(input[2]));
            } else if (input[0].equals("BP")) {
                BP(Integer.parseInt(input[1]), Integer.parseInt(input[2]));

            } else if (input[0].equals("CP")) {
                CP(Integer.parseInt(input[1]));

            } else if (input[0].equals("CN")) {
                CN(Integer.parseInt(input[1]));
            }
        }
        System.out.println(sb);


    }

    static void CN(int n1) {
        sb.append(nextStation[n1] + "\n");


        int delnode = nextStation[n1];

        nextStation[n1] = nextStation[delnode];
        beforeStation[nextStation[delnode]] = n1;


    }

    static void CP(int n1) {
        sb.append(beforeStation[n1] + "\n");

        int delnode = beforeStation[n1];

        nextStation[beforeStation[delnode]] = n1;
        beforeStation[n1] = beforeStation[delnode];

    }


    static void BP(int n1, int n2) {
        sb.append(beforeStation[n1] + "\n");

        beforeStation[n2] = beforeStation[n1];
        nextStation[n2] = n1;

        beforeStation[n1] = n2;
        nextStation[beforeStation[n2]] = n2;
    }

    static void BN(int n1, int n2) {
        sb.append(nextStation[n1] + "\n");

        beforeStation[n2] = n1;
        nextStation[n2] = nextStation[n1];

        nextStation[n1] = n2;
        beforeStation[nextStation[n2]] = n2;


    }
}
