package baekjoon;

import java.util.Arrays;
import java.util.Scanner;


/*
작성자 : 황성민
날짜 : 24년 1월 13일
알고리즘 부류 : 분할 정복
문제 해결 접근법 : https://blog.naver.com/steadydeveloper/223321331626
*/



public class BOJ1780_222풀링 {

    static int[][] arr;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();

        // N x N 배열 선언
        arr = new int[N][N];

        // 배열 값 입력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = input.nextInt();
            }
        }
        // 정답 출력
        System.out.println(recursion(0, 0, N));
    }


    // 답을 구하기 위한 재귀 함수
    static int recursion(int startY, int startX, int N) {
        // leftUp 왼쪽 위값
        int lU = arr[startY][startX];

        //rightUp 오른쪽 위 값
        int rU = arr[startY][startX + 1];

        //leftBottom 오른쪽 아래 값
        int lB = arr[startY + 1][startX];

        //rightBottom 오른쪽 아래 값
        int rB = arr[startY + 1][startX + 1];


        // 만약 N이 2보다 크다면 더 작게 분할해야한다.
        if (N > 2) {
            // 4개로 분할된 사각형을 더 작개 쪼개기
            lU = recursion(startY, startX, N / 2);
            rU = recursion(startY, startX + N / 2, N / 2);
            lB = recursion(startY + N / 2, startX, N / 2);
            rB = recursion(startY + N / 2, startX + N / 2, N / 2);
        }

        // 2번째로 큰값을 구하기 위해 길이 4짜리 인트형 배열 선언
        int[] tmp = {lU, rU, lB, rB};
        // 배열 정렬
        Arrays.sort(tmp);
        // 두 번째로 큰값 반환
        return tmp[2];
    }

}