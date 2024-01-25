package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2263_트리의_순회 {

    static int[] inOrder;
    static int[] postOrder;
    static int N;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int[][] tree = new int[N + 1][2];

        inOrder = new int[N];
        postOrder = new int[N];
        boolean[] visited = new boolean[N];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inOrder[i] = Integer.parseInt(st1.nextToken());
            postOrder[i] = Integer.parseInt(st2.nextToken());

        }

        recursion(N-1,0,N);
    }


    static void recursion(int root, int s, int e){
        for (int idx = s; idx < e; idx++){

            if (postOrder[root] == inOrder[idx]){


                //root
                System.out.println(postOrder[root]);


                //left
                recursion(root - (e -1), s,idx);


                //right
                recursion(root-1,idx + 1,e);



            }
        }

    }
}
