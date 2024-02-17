package baekjoon;

/**
 * 작성자 : 황성민
 * 작성일자 : 24.02.17
 * 문제해결 : 지훈이와 불을 BFS탐색을 이용해 한패스씩 이동시키며 문제를 해결한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ4179_불 {

    static int Y, X;
    static int[] moveY = {-1, 1, 0, 0};
    static int[] moveX = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        input = br.readLine().split(" ");

        Y = Integer.parseInt(input[0]);
        X = Integer.parseInt(input[1]);


        String[][] map = new String[Y][X];

        // 지훈이와 불의 방문 리스트
        boolean[][] jihoonVisited = new boolean[Y][X];
        boolean[][] fireVisited = new boolean[Y][X];

        // 지훈이와 불의 BFS 큐
        Queue<int[]> jihoon = new LinkedList<>();
        Queue<int[]> fires = new LinkedList<>();


        // 맵 정보 입력
        for (int i = 0; i < Y; i++) {
            input = br.readLine().split("");
            for (int j = 0; j < X; j++) {
                map[i][j] = input[j];

                if (map[i][j].equals("#")) {
                    fireVisited[i][j] = true;
                    jihoonVisited[i][j] = true;
                }

                if (map[i][j].equals("J")) {
                    jihoon.add(new int[]{i, j, 0});
                    jihoonVisited[i][j] = true;

                } else if (map[i][j].equals("F")) {
                    fires.add(new int[]{i, j, 0});
                    fireVisited[i][j] = true;
                }
            }
        }


        // 시간
        int time = 0;

        // 지훈이와 불의 큐가 모두 빌때까지
        while (!(jihoon.isEmpty() && fires.isEmpty()) ) {
            time++;

            // 불 먼저 이동   시간 변수를 이용해서 time시간보다 작은 시간 정보들만 수행
            while (!fires.isEmpty() && fires.peek()[2] < time) {
                int[] tmp = fires.poll();
                int y = tmp[0];
                int x = tmp[1];
                int t = tmp[2];


                for (int i = 0; i < 4; i++) {
                    int ny = y + moveY[i];
                    int nx = x + moveX[i];


                    if (isIn(ny, nx) && !fireVisited[ny][nx] && !map[ny][nx].equals("#")) {
                        fires.add(new int[]{ny, nx, t + 1});
                        fireVisited[ny][nx] = true;
                        map[ny][nx] = "F";
                    }

                }

            }


            // 지훈이 이동 시간 변수를 이용해서 time시간보다 작은 시간 정보들만 수행
            while (!jihoon.isEmpty() && jihoon.peek()[2] < time) {

                int[] tmp = jihoon.poll();
                int y = tmp[0];
                int x = tmp[1];
                int t = tmp[2];


                for (int i = 0; i < 4; i++) {
                    int ny = y + moveY[i];
                    int nx = x + moveX[i];

                    // 지훈이 탈출 성공
                    if (!isIn(ny, nx)) {
                        System.out.println(time);
                        return;
                    }

                    if (!jihoonVisited[ny][nx] && !map[ny][nx].equals("F") && !map[ny][nx].equals("#")) {
                        jihoon.add(new int[]{ny, nx, t + 1});
                        jihoonVisited[ny][nx] = true;
                    }
                }


            }



        }

        // 탈출하지 못했다면
        System.out.println("IMPOSSIBLE");

    }


    static boolean isIn(int y, int x) {
        if (0 <= y && y < Y && 0 <= x && x < X) return true;
        return false;
    }
}

