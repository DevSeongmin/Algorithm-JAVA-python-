package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1260_DFS와BFS {

    static int N, E, START;

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        START = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 0; i <= N; i++) {
            Collections.sort(graph.get(i));
        }


        dfs(START);
        System.out.println();

        visited = new boolean[N+1];
        bfs(START);

    }

    static void dfs(int node){
        System.out.print(node + " ");
        visited[node] = true;

        for (int i : graph.get(node)){
            if (!visited[i]){
                dfs(i);
            }
        }
    }



    static void bfs(int node){

        Queue<Integer> q = new LinkedList<>();

        q.add(node);
        visited[node] = true;

        while (!q.isEmpty()) {
            node = q.poll();
            System.out.print(node + " ");

            for (int i : graph.get(node)) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }

            }

        }




    }


}
