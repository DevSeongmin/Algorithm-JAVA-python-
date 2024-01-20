package baekjoon;


/*
작성자 : 황성민
작성일자 : 24.01.20
문제 접근 및 풀이 : https://blog.naver.com/steadydeveloper/223328513149
 */

import java.util.Scanner;

public class BOJ1644_소수의_연속합 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 찾고자 하는 소수들의 합
        int N = input.nextInt();

        // 만약 2보다 작다면 0출력 후 종료
        if (N < 2){
            System.out.println(0);
            return;
        }

        // 에라토스테네스의 체를 이용해 소수를 구하기 위한 배열 선언
        boolean[] arr = new boolean[N+1];

        // 2이상은 true로 초기화
        for (int i = 2; i <= N; i++) {
            arr[i] = true;
        }

        //cnt는 소수의 개수
        int cnt = 0;

        //에라토스테네스의 체 실행
        for (int i = 2; i <= N; i++) {
            if (arr[i]){
                cnt++;
                for (int j = i + i; j <= N; j+=i){
                    arr[j] = false;
                }
            }
        }

        // 소수들을 담기 위한 배열
        int[] primes = new int[cnt];
        cnt = 0;

        // 배열에 소수들을 담아줍니다.
        for (int i = 0; i <= N; i++) {
            if (arr[i]){
                primes[cnt++] = i;
            }
        }
        int answer= 0;

        // 소수들로 이루어진 배열로 투포인터 실행
        int left = 0;
        int right = 0;
        int rangeSum = primes[0];

        while (left <= right){

            // 만약 범위의 합이 목표값 N보다 크다면 왼쪽 포인터 오른쪽으로 이동
            if(rangeSum > N){
                rangeSum -= primes[left++];

            // 만약 범위의 합이 목표값 N보다 작다면 오른쪽 포인터 오른쪽으로 이동
            } else if (rangeSum < N) {
                if (right == cnt-1){
                    break;
                }
                rangeSum += primes[++right];
            }
            // 목표값을 찾았다면 정답++; 후 왼쪽 포인터 오른쪽으로 이동
            else {
                answer++;
                rangeSum -= primes[left++];
            }

        }

        // 정답 출력
        System.out.println(answer);
    }
}
