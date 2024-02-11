package baekjoon;

/**
 * 작성자 : 황성민
 * 작성 일자 : 24.02.11
 * 문제 해결 BFS를 이용하여 map을 탐색하며 다음 좌표는 이전 좌표 +1의 값으로 갱신하여준다.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2178_미로탐색 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        input = br.readLine().split(" ");

        // 세로 가로 입력
        int Y = Integer.parseInt(input[0]);
        int X = Integer.parseInt(input[1]);


        // map정보 입력
        int[][] map = new int[Y][X];
        for (int i = 0; i < Y; i++) {
            input = br.readLine().split("");
            for (int j = 0; j < X; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        // 다음 좌표를 나타내는 백터
        int[] moveY = {0, 0, -1, 1};
        int[] moveX = {-1, 1, 0, 0};

        //BFS 수행을 위한 Queuee 선언
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0});


        // 큐가 빌때까지 반복
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            // 현재 y, x
            int y = tmp[0];
            int x = tmp[1];

            // 다음 좌표값 ny, nx
            for (int i = 0; i < 4; i++) {
                int ny = y + moveY[i];
                int nx = x + moveX[i];

                // ny, nx좌표가 범위 안의 좌표이고 값이 1이라면
                if (0 <= nx && nx < X && 0 <= ny && ny < Y && map[ny][nx] == 1){
                    // ny nx좌표값 이전 좌표값 + 1로 갱신
                    map[ny][nx] = map[y][x] + 1;
                    // 큐에 삽입
                    q.add(new int[]{ny, nx});
                }
            }

        }

        // 정답 출력
        System.out.println(map[Y-1][X-1]);


    }
}
