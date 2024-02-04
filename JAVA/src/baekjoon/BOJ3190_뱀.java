package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 작성자 : 황성민
 * 작성일자 : 24.02.03
 * 시뮬레이션 : 큐를 이용하여 뱀의 움직임을 나타낼 수 있다.
 *  큐의 길이가 뱀의 길이이다.
 */


public class BOJ3190_뱀 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        // N * N 맵 입력
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        int apple = Integer.parseInt(br.readLine());

        // map에 사과위치에 1 할당
        for (int i = 0; i < apple; i++){
            input = br.readLine().split(" ");
            map[Integer.parseInt(input[0]) -1][Integer.parseInt(input[1]) -1] = 1;
        }

        int turn =  Integer.parseInt(br.readLine());

        // 시간에 따른 방향 전환 확인 배열
        // 인덱스는 초 값은 턴할 방향을 나타냄
        String[] turns = new String[10001];

        // NullPointException을 피하기 위해 공백으로 채워줌
        Arrays.fill(turns, "");

        // 방향전환을 언제 할지 입력
        for (int i = 0; i < turn; i++){
            input = br.readLine().split(" ");
            turns[Integer.parseInt(input[0])] = input[1];
        }



        // 뱀의 이동을 나타내는 좌표
        int[] moveX = {1,0,-1,0};
        int[] moveY = {0,1,0,-1};


        // 뱀을 나타내는 큐 선언
        Deque<int[]> q = new ArrayDeque<>();
        // 초기 뱀의 상태
        q.add(new int[]{0, 0});

        //현재 뱀의 머리 위치
        int x = 0;
        int y = 0;
        // 시간
        int second = 0;
        // 방향
        int direction = 0;

        bp:
        while (true){
            second++;

            // 다음 y x 좌표
            int nx = x + moveX[direction];
            int ny = y + moveY[direction];

            // 만약 꺽을 시간이라면 알맞게 꺽어줌
            if (turns[second].equals("D")) direction = (direction+1) % 4;
            if (turns[second].equals("L")) direction = direction == 0 ? 3 : direction - 1;

            // 맵 나가면 사망
            if (!(0 <= nx && nx < N && 0 <= ny && ny < N)) {
                break;
            }

            // 내몸 맞으면 사망;
            for (int[] s : q){
                if (ny == s[0] && nx == s[1]) {
                    break bp;
                    
                }
            }


            // 맵에 사과가 있다면
            if (map[ny][nx] == 1){
                map[ny][nx] = 0;
                // 머리만 늘려준다.
                q.add(new int[]{ny, nx, direction});

            // 사과가 없다면
            } else{
                // 머리를 늘려주고 꼬리를 자른다.
                q.add(new int[]{ny, nx, direction});
                q.poll();
            }

            // 현재 좌표 업데이트
            x = nx;
            y = ny;
        }

        System.out.println(second);
    }
}
