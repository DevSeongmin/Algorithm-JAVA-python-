package baekjoon;

import java.util.Scanner;


/** 작성자 : 황성민
 * 작성 일자 : 24.02.01
 * 접근 및 풀이법 :
 * 앞자리에서 끊었을때 모든 수가 소수인 경우를 신기한 소수라고 한다.
 * N의 자리의 신기한 소수의 수를 구하는 문제이다.
 *
 *  만약 N이 2일 경우를 생각해 보자
 *
 *  첫째자리에 올 수 있는 수는 1~9까지이다.  0이면 어차피 소수가 아님
 *  1~ 9 까지의 소수 체크 후  소수 이면
 *
 *  (1 ~ 9) * 10 + (1~9) 로 N의 자리가 될 때 까지 소수 체크하면 문제 해결 가능
 *
 */

public class BOJ2023_신기한소수 {

    static int N = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        N = input.nextInt();

        // 탐색 시작
        dfs(0, 0);

        // 정답 출력
        System.out.println(sb);

    }

    static void dfs(int depth, int num) {
        // N자리까지 완성했으면 sb에 저장 후 리턴
        if (depth == N) {
            sb.append(num + "\n");
            return;
        }


        //1부터 9까지 뒤에 붙여주는 반복
        for (int i = 1; i <= 9; i++) {

            // 붙였을 경우 소수이면 다시 재귀 호출
            if (isPrime(num * 10 + i)) {
                dfs(depth + 1, num * 10 + i);

            }

        }

    }

    // 에라토스테네스 체를 이용한 소수판별 함수
    static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i < (int) Math.sqrt(n) + 1; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

}

