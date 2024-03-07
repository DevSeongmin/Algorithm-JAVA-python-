package baekjoon;

/**
 * 작성자 : 황성민
 * 작성일자 : 24.03.01
 * 문제 해결 : 조합으로 활성화시킬 바이러스를 뽑고
 *          활성화한 바이러스들로 BFS를 수행한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ17142_연구소3 {

    static int N, virusCnt, answer;
    static ArrayList<Node> viruses;
    static ArrayList<Node> pickvirus= new ArrayList<>();
    static int[][] map, bfsMap;
    static int[] moveX = {-1, 1, 0, 0};
    static int[] moveY = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        virusCnt = Integer.parseInt(st.nextToken());

        viruses = new ArrayList<>();

        map = new int[N][N];
        bfsMap = new int[N][N];
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    viruses.add(new Node(i, j));
                }
            }
        }

        answer = Integer.MAX_VALUE;
        combi(0, 0);

        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else{
            System.out.println(answer);
        }
    }

    static void bfs(){
        for (int i = 0; i < N; i++){
            bfsMap[i] = Arrays.copyOf(map[i], N);
        }

        Queue<Node> q = new LinkedList<>();

        for (Node v : pickvirus){
            q.add(v);
        }

        int time = 0;
        if (isSpread()) {
            answer = Math.min(answer, time);
            return;
        }

        while (!q.isEmpty()) {

            time++;
            int iter = q.size();
            for (int i = 0; i < iter; i++){
                Node virus = q.poll();
                int y = virus.y;
                int x = virus.x;

                for (int j = 0; j < 4; j++) {
                    int ny = y + moveY[j];
                    int nx = x + moveX[j];

                    if (!isIn(ny,nx)) continue;
                    if (bfsMap[ny][nx] == 0 || bfsMap[ny][nx] == 2) {
                        bfsMap[ny][nx] = 3;
                        q.add(new Node(ny, nx));
                    }

                }

            }

            if (isSpread()) {
                answer = Math.min(answer, time);
                return;
            }


        }
    }

    static boolean isIn(int y, int x){
        return 0 <= x && x < N && 0 <= y && y < N;
    }


    static void combi(int depth, int s){
        if (depth == virusCnt) {
            bfs();
            return;
        }


        for (int i = s; i < viruses.size(); i++){
            pickvirus.add(viruses.get(i));
            combi(depth + 1, i + 1);
            pickvirus.remove(viruses.get(i));
        }
    }


    static boolean isSpread(){
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if (bfsMap[i][j] == 0) return false;
            }
        }
        return true;
    }


    static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

}
