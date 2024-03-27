package baekjoon;

/**
 * 작성자 : 황성민
 * 작성일자 : 24.03.27
 * 문제 해결 : BackTracking을 이용한 문제 풀이
 *
 *          시간초과 풀이 : 0인 좌표에 0~9까지 넣고 체크해가며 풀었다.
 *          해결 방법 : 먼저 체크를 하고 가능한 숫자들만 넣고 백트래킹
 *
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ2239_수도쿠 {

    static int[][] board;
    static List<Node> zeros;
    static int fillCnt = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new int[9][9];

        // 0들의 좌표를 넣어줄 어레이 리스트 
        zeros = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            String s = br.readLine();
            for (int j = 0; j < 9; j++) {
                board[i][j] = s.charAt(j) - '0';

                // 0이면 zeors 좌표에 넣고 
                // 채워야하는 카운트++;
                if (board[i][j] == 0) {
                    zeros.add(new Node(i, j));
                    fillCnt++;
                }
            }
        }
        
        // 재귀 시작
        recursion(0);
    }


    static void recursion(int depth) {
        
        // 끝까지 채웠다면 정답 출력
        if (depth == fillCnt) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(board[i][j]);
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);

            return;
        }

        // 현재 깊이의 0 위치 Node클래스
        Node curNode = zeros.get(depth);

        // 가능한 위치들을 체크하기 위한 배열
        boolean[] possible = new boolean[10];

        // 세로행 체크
        for (int i = 0; i < 9; i++) {
            possible[board[i][curNode.x]] = true;
        }

        // 가로행 체크
        for (int i = 0; i < 9; i++) {
            possible[board[curNode.y][i]] = true;
        }

        // 9칸 사각형 체크
        int startX = curNode.x / 3 * 3;
        int startY = curNode.y / 3 * 3;
        for (int y = startY; y < startY + 3; y++) {
            for (int x = startX; x < startX + 3; x++) {
                possible[board[y][x]] = true;
            }
        }


        for (int i = 1; i <= 9; i++) {
            // 가능한 값이라면
            if (!possible[i]) {

                // 값 넣고 재귀
                board[curNode.y][curNode.x] = i;
                recursion(depth + 1);
                // 돌아와서 원래 값으로
                board[curNode.y][curNode.x] = 0;
            }
        }
    }

    static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}