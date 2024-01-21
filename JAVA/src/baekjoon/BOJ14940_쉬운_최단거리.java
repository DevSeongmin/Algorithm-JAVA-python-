package baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14940_쉬운_최단거리 {

    static int[] yMove = {0, 0, -1, 1};
    static int[] xMove = {-1, 1, 0, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Queue<int[]> queue = new LinkedList<>();


        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int startY = 0;
        int startX = 0;

        int[][] map = new int[y][x];

        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < x; j++) {
                map[i][j] = -Integer.parseInt(st.nextToken());
                if (map[i][j] == -2){
                    startY = i;
                    startX = j;
                }
            }
        }


        map[startY][startX] = 0;
        queue.add(new int[]{startY, startX});

        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int currentY = tmp[0];
            int currentX = tmp[1];

            for (int i = 0; i < 4; i++) {
                int nY = currentY + yMove[i];
                int nX = currentX + xMove[i];

                if (0 <= nX && nX < x && 0 <= nY && nY < y && map[nY][nX] == -1) {
                    map[nY][nX] = map[currentY][currentX] + 1;
                    queue.add(new int[]{nY, nX});
                }
            }
        }


        StringBuilder sb = new StringBuilder();

        for (int[] ints : map) {
            for (int anInt : ints) {
                sb.append(anInt + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
