package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9205_맥주마시면서걸어가기 {
    static int N;
    static Node[] nodes;
    static String answer;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {

            N = Integer.parseInt(br.readLine());

            nodes = new Node[N + 2];

            for (int i = 0; i < N + 2; i++) {
                st = new StringTokenizer(br.readLine());
                nodes[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            visited = new boolean[N + 2];

            answer = "sad";
            dfs(0);
            sb.append(answer + "\n");
        }
        System.out.println(sb);


    }

    static void dfs(int v) {

        if (v == N + 1) {
            answer = "happy";
            return;
        }

        visited[v] = true;

        for (int i = 0; i < N + 2; i++) {

            if (visited[i]) continue;

            if (getGap(nodes[v], nodes[i]) <= 1000) {
                dfs(i);
            }
        }

    }


    static int getGap(Node a, Node b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }

    static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
