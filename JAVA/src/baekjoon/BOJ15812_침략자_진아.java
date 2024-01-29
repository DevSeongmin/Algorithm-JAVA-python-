package baekjoon;


/**
 * 작성자 : 황성민
 * 작성일자 : 24.01.29
 * 문제 : N * M 짜리 평면에서 0의 자리에는 화학무기를 둘 수 있다. 1은 마을을 뜻한다.
 *  화학무기는 초당 상하좌우로 퍼지며 화학무기를 두개 뒀을 때 모든 마을을 감염시키는 시간을 구한다.
 *
 *  해결 : 마을의 개수를 체크
 *          폭탄을 둘 수 있는 0의 좌표들을 리스트에 담아둠 
 *          리스트에서 두개의 폭탄을 두는 모든 경우를 탐색하고 
 *          두개를 뒀을 때 BFS를 돌려 모든 마을을 감염시키는 최소 시간을 정답에 초기화
 */

import java.util.*;

public class BOJ15812_침략자_진아 {

    static int N;
    static int M;
    static int answer = 30;

    static int[] moveX = {0, 0, -1, 1};
    static int[] moveY = {-1, 1, 0, 0};
    static int[][] arr;
    static int target;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        N = input.nextInt();
        M = input.nextInt();


        ArrayList<int[]> directions = new ArrayList<>();

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            String tmp = input.next();

            for (int j = 0; j < M; j++) {

                arr[i][j] = Integer.parseInt("" + tmp.charAt(j));

                // 0일 경우는 의미 없고 1일 경우 마을의 수 +1
                target += arr[i][j];

                // 0이면 화학무기를 놓을 수 있는 위치
                if (arr[i][j] == 0) directions.add(new int[]{i, j});
            }
        }


        // 두개의 지점을 고르는 반복
        for (int i = 0; i < directions.size(); i++) {
            for (int j = i+1; j < directions.size(); j++) {

                int[] one = directions.get(i);
                int[] two = directions.get(j);

                // 해당 두개의 지점에 화학물질을 두고 BFS
                bfs(one, two, 0);
            }
        }
        System.out.println(answer);
    }

    static void bfs(int[] one, int[] two,  int value) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        // Queued에 두 지점의 [y좌표][x좌표][시간] 을 넣어주고 BFS
        q.add(new int[] {one[0], one[1], 0});
        q.add(new int[] {two[0], two[1], 0});
        visited[one[0]][one[1]] = true;
        visited[two[0]][two[1]] = true;

        
        while (!q.isEmpty()){

            int[] tmp = q.poll();
            int y = tmp[0];
            int x = tmp[1];
            int day = tmp[2];

            // 화학 무기가 퍼지면서 좌표가 마을의 위치라면 value += 1
            value += arr[y][x];

            // value가 마을의 수 라면 모든 마을을 감염시킨것으로 min(정답,시간)으로 할당
            if (value == target) {
                answer = Math.min(answer, day);
                return;
            }

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int ny = y + moveY[i];
                int nx = x + moveX[i];

                // 다음 좌표가 방문하지 않았고 N*M이내라면
                if (0 <= nx && nx < M && 0 <= ny && ny < N && !visited[ny][nx]) {
                    q.add(new int[]{ny, nx, day + 1});
                    visited[ny][nx] = true;
                }
            }
        }
    }
}
