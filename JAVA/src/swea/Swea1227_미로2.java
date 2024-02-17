package swea;

/**
 * 작성자 : 황성민
 * 작성일자 : 24.02.16
 * 문제해결 : 2차원에서의 비선형 탐색 BFS를 이용하여 해결
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Swea1227_미로2 {

    static int[] moveY = {-1, 1, 0, 0};
    static int[] moveX = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;


        // 10개의 테스트 케이스
        for (int tc = 1; tc <= 10; tc++) {
            // 테스트케이스 번호
            int T = Integer.parseInt(br.readLine());

            // 맵 선언
            int[][] map = new int[100][100];

            // 시작점
            int[] startPoint = new int[2];

            // 맵 표현
            for (int i = 0; i < 100; i++) {
                input = br.readLine().split("");
                for (int j = 0; j < 100; j++) {
                    map[i][j] = Integer.parseInt(input[j]);
                    // 2라면 시작점으로
                    if (map[i][j] == 2) {
                        startPoint[0] = i;
                        startPoint[1] = j;
                    }
                }
            }


            //BFS 탐색
            Queue<int[]> q = new LinkedList<>();
            q.add(startPoint);

            int answer = 0;

            point:
            while (!q.isEmpty()) {

                int[] tmp = q.poll();
                int y = tmp[0];
                int x = tmp[1];

                for (int i = 0; i < 4; i++) {
                    int ny = y + moveY[i];
                    int nx = x + moveX[i];

                    if (0 <= nx && nx < 100 && 0 <= ny && ny < 100 && map[ny][nx] != 1) {
                        q.add(new int[]{ny, nx});

                        // 목적지를 만나면 정답을 1로하고 break;
                        if (map[ny][nx] == 3) {

                            answer = 1;
                            break point;
                        }

                        map[ny][nx] = 1;
                    }


                }
            }
            // 정답 출력
            System.out.println("#" + T + " " + answer);
        }


    }
}
