package baekjoon;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/*
작성자 : 황성민
작성일자 : 24.01.16
문제 해결, 접근 : https://blog.naver.com/steadydeveloper/223324545064
 */
public class BOJ2447_별찍기_10 {

    // 별모양을 찍기위한 정적 배열 생성
    static Character[][] arr;

    public static void main(String[] args)  throws IOException {
        Scanner input = new Scanner(System.in);

        // 기본 System.out.println 사용 시 시간초과
        // 스트링 빌더를 사용하여 한번에 모아서 출력하는 것으로 해결
        StringBuilder sb = new StringBuilder();


        // N 입력 N은 3의 제곱
        int N = input.nextInt();

        // 별과 공백을 담아둘 Character형 2차원 배열 선언
        arr = new Character[N][N];
        for (Character[] a : arr){
            // 공백으로 초기화
            Arrays.fill(a, ' ');
        }

        // 규칙에 맞게 별찍기 수행
        recursion(0,0,N);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 각 배열의 값 sb(스트링 빌더)에 저장
                sb.append(arr[i][j]);
            }
            // 한줄이 끝나면 개행 문자 추가
            sb.append('\n');
        }

        // 스트링 빌더 출력
        System.out.println(sb);
    }


    // N*N Character형 배열에 규칙에 맞게 별을 추가하는 코드
    static public void recursion(int y, int x, int N) {

        // 더 이상 쪼개지지 않으므로 해당 좌표에 별 넣기
        if (N == 1) {
            arr[y][x] = '*';
            return;
        }


        // 분할과정

        /*
       최소 값인 3의 모양
       즉 3N * 3N의 2차원 배열에서
       루프를 수행 할 때 y + N, x + N의 부분은 비워두는 규칙이 있음

        ***
        * *
        ***

         */

        for (int i = y; i < y + N; i += (N / 3)) {
            for (int j = x; j < x + N; j += (N / 3)) {

                // N/3의 증감값으로 2중 루프를 돌며
                // y + N/3,  x + N/3 의 위치일 때는 별을 출력하지 않는다.
                // 위 과정을 재귀적으로 수행
                if (i == y + N / 3 && j == x + N / 3) {
                    continue;
                }
                recursion(i,j,N/3);

            }
        }


    }
}
