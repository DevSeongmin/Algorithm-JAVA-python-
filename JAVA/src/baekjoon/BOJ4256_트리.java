package baekjoon;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ4256_트리 {
    static int[] preOrder;
    static int[] inOrder;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++){
            N = Integer.parseInt(br.readLine());

            int[][] tree = new int[N + 1][2];

            preOrder = new int[N];
            inOrder = new int[N];
            boolean[] visited = new boolean[N];

            StringTokenizer st1 = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                preOrder[i] = Integer.parseInt(st1.nextToken());
                inOrder[i] = Integer.parseInt(st2.nextToken());
            }

            recursion(0,0,N);
            System.out.println();

        }

    }



    public static void recursion(int root, int s, int e){

        for (int i = s; i < e; i++){
            if(preOrder[root] == inOrder[i]){

                recursion(root+1, s, i);// left


                recursion(root + i + 1 - s, i + 1, e);//right

                System.out.print(preOrder[root] + " ");

            }
        }

    }



}

