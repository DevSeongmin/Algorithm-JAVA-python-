package baekjoon;

/*
 * 작성자 : 황성민
 * 작성일자 : 24.01.20
 * 문제 풀이 : https://blog.naver.com/steadydeveloper/223328269404
 */

import java.util.Scanner;

public class BOJ2448_별찍기_11 {

    static int[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        map = new int[N][2*N];

        // 재귀의 종료조건을 가로의 길이가 6일 때 이므로 N의 값을 2를 곱해서 매개인자로 넘겨줌
        recursion(0,0,N * 2);

        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < 2 * N; j++) {
                if (map[i][j] == 1) sb.append('*');
                else sb.append(' ');
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void recursion(int y, int x, int N) {
        // 재귀의 종료 조건 N이 6일 때 해당 패턴대로 별을 찍음
        if (N==6){
            map[y][x] = 1;
            map[y][x+1] = 1;
            map[y][x+2] = 1;
            map[y][x+3] = 1;
            map[y][x+4] = 1;

            map[y+1][x+1] = 1;
            map[y+1][x+3] = 1;

            map[y+2][x+2] = 1;
            return;
        }


        // 재귀의 파고드는 조건
        // 3 부분으로 나눴을 때 
        
        // 왼쪽 아래 
        recursion(y, x, N/2);
        // 오른쪽 아래 
        recursion(y, x + N / 2, N / 2);
        // 가운대 위쪽
        recursion(y+N/4,x+N/4,N/2);

    }
}
