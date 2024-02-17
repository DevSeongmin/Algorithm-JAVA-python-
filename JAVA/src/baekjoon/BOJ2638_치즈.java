package baekjoon;

/**
 * 작성자 : 황성민
 * 작성일자 : 24.02.17
 *
 * 문제해결 방법 : 치즈를 기준으로 주변에 공기칸이 2개 이상 있으면 지워나간다.
 * 주의할 점 치즈로 둘러싸인 빈 공간은 치즈를 녹이는 공기가 아니다.
 * 즉 테두리는 치즈가 놓여있자 않다고 했으므로 0,0에서 dfs로 공기를 채우고 시뮬레이션을 진행한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2638_치즈 {

    static int[] moveY = {-1, 1, 0 , 0};
    static int[] moveX = {0, 0, -1 , 1};
    static int Y, X;
    static int[][] map;
    static Queue<int[]> meltQ = new LinkedList<>();
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        input = br.readLine().split(" ");
        Y = Integer.parseInt(input[0]);
        X = Integer.parseInt(input[1]);

        map = new int[Y][X];

        // 치즈개수
        int meltCnt = 0;

        // 1은 치즈,  0은 빈공간, -1은 치즈를 녹일 수 있는 공기칸
        for (int i = 0; i < Y; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < X; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                if (map[i][j] == 1) meltCnt++;
            }
        }


        // 시간 변수
        int time = 0;

        // 모든 치즈를 녹일 때 까지
        while (meltCnt > 0){
            ++time;

            // 공기를 체우기
            visited = new boolean[Y][X];
            fillAir(0, 0);


            // 치즈칸이라면 melt 메서드
            for (int i = 0; i < Y; i++) {
                for (int j = 0; j < X; j++) {
                    if (map[i][j] == 1){
                        melt(i, j);
                    }
                }
            }

            // 녹아야하는 치즈들 한번에 녹여주기
            while(!meltQ.isEmpty()){
                int[] tmp = meltQ.poll();
                int y = tmp[0];
                int x = tmp[1];
                map[y][x] = 0;
                meltCnt--;
            }
        }

        // 정답 출력
        System.out.println(time);
    }

    // DFS로 공기 체우기
    static void fillAir(int y, int x) {
        map[y][x] = -1;
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + moveY[i];
            int nx = x + moveX[i];

            if (isIn(ny, nx) && !visited[ny][nx] && map[ny][nx] != 1) {
                fillAir(ny, nx);
            }
        }
    }


    // 치즈를 녹이는 메서드
    // 녹아야 하는 치즈라면 큐에 넣고 나중에 한번에 녹인다.
    static void melt(int y, int x) {

        int airCnt = 0;
        for (int i = 0; i < 4; i++) {
            int ny = y + moveY[i];
            int nx = x + moveX[i];

            if (isIn(ny, nx) && map[ny][nx] == -1) {
                airCnt++;
            }
        }

        if (airCnt >= 2){
            meltQ.add(new int[]{y, x});
        }
    }


    // 유요한 좌표인지 확인하는 메서드
    static boolean isIn(int y, int x) {
        if (0 <= x && x < X && 0 <= y && y < Y) {
            return true;
        }

        return false;
    }
}
