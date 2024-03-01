package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2206_벽부수고이동하기 {

    static int Y, X;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        input = br.readLine().split(" ");

        Y = Integer.parseInt(input[0]);
        X = Integer.parseInt(input[1]);

        int[][] map = new int[Y][X];

        for (int i = 0; i < Y; i++) {
            input = br.readLine().split("");
            for (int j = 0; j < X; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                if (map[i][j] == 1) map[i][j] = -1;
            }
        }


        int[] moveX = {-1, 1, 0, 0};
        int[] moveY = {0, 0, -1, 1};


        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 1));
        int[][] visited = new int[Y][X];
        map[0][0] = 1;
        visited[0][0] = 1;


        while (!q.isEmpty()) {

            Node node = q.poll();

            int y = node.y;
            int x = node.x;
            int t = node.t;

            if (node.y == Y-1 && node.x == X-1){
                System.out.println(node.t);


                return;
            }

            for (int i = 0; i < 4; i++) {
                int ny = node.y + moveY[i];
                int nx = node.x + moveX[i];

                if (!isIn(ny, nx)) continue;
                if (visited[ny][nx] == 1) continue;


                if (map[ny][nx] == -1 && visited[y][x] == 1 && visited[ny][nx] != 2) {
                    visited[ny][nx] = 2;
                    q.add(new Node(ny, nx, t + 1));

                } else if (map[ny][nx] != -1 && visited[ny][nx] != visited[y][x]) {
                    map[ny][nx] = t + 1;
                    visited[ny][nx] = visited[y][x];
                    q.add(new Node(ny, nx, t + 1));
                }
            }
        }
        System.out.println(-1);

    }

    static boolean isIn(int y, int x) {
        if (0 <= y && y < Y && 0 <= x && x < X) {
            return true;
        }
        return false;

    }


    static class Node {
        int y, x, t;
        public Node(int y, int x, int t) {
            this.y = y;
            this.x = x;
            this.t = t;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Node{");
            sb.append("y=").append(y);
            sb.append(", x=").append(x);
            sb.append(", t=").append(t);
            sb.append('}');
            return sb.toString();
        }
    }
}
