/*
작성자 : 황성민
작성날짜 : 2024.01.14
문제 접근 및 해결 : https://blog.naver.com/steadydeveloper/223322058174
 */

package baekjoon;

import java.util.HashSet;
import java.util.Scanner;

public class BOJ1987_알파벳 {

    // 상하좌우 이동자표 선언
    static int[] xMove = {-1,0,1,0};
    static int[] yMove = {0, -1, 0,1};

    // 2차원 배열의 범위 Y(세로)   X(가로)
    static int Y;
    static int X;

    // 방문을 체크할 Character형 해쉬셋 선언
    static HashSet<Character> visited;

    // 입력 알파벳 char형식의 2차원 배열선언
    static char[][] board;

    // 정답 변수 선언
    static int answer = 0;


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Y = input.nextInt();
        X = input.nextInt();

        board = new char[Y][X];

        visited = new HashSet<>();

        //board값 입력
        for (int i = 0; i < Y; i++) {
            String tmp = input.next();
            for (int j = 0; j < X; j++) {
                board[i][j] = tmp.charAt(j);
            }
        }

        // 시작 좌표 0, 0 에서 탐색 시작
        dfs(0, 0, 1);
        System.out.println(answer);
    }

    static void dfs(int y, int x, int depth) {
        //현재 깊이가 정답 변수보다 크다면 정답 변수에 depth값 할당
        answer = Math.max(depth, answer);

        //현재 좌표의 알파벳 방문셋에 추가
        visited.add(board[y][x]);

        //4방향 탐색
        for (int i = 0; i < 4; i++) {
            int ny = yMove[i] + y;
            int nx = xMove[i] + x;

            // 다음 좌표가 board의 범위 안이고 다음 좌표에 있는 알파벳을 방문한적 없다면 재귀적으로 탐색
            if (0 <= ny && ny < Y && 0 <= nx && nx < X && !visited.contains(board[ny][nx])) {
                dfs(ny, nx, depth + 1);
            }
        }
        // 함수가 끝나고 이전 좌표로 갈 때는 현재 좌표의 알파벳을 방문셋에서 제거
        visited.remove(board[y][x]);
    }
}
