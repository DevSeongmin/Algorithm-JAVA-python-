/*
작성자 : 황성민
작성일자 : 24.01.16
알고리즘 부류 : 투 포인터
문제 해결 : https://blog.naver.com/steadydeveloper/223324638575
 */



package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ2467_용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //배열의 크기
        int size = Integer.parseInt(br.readLine());

        //용액의 정보 배열
        int[] arr = new int[size];

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 배열 입력
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //투 포인터 지정 왼쪽 = 0   오른쪽 = size - 1
        int left = 0;
        int right = size - 1;

        // 절댓값이 낮은(0에 가까운) 경우 갱신하기 위한 변수 선언
        int checkValue = Integer.MAX_VALUE;

        // 두개의 포인터가 가리키는 값의 합 변수 선언
        int currentValue = arr[left] + arr[right];

        // 정답 변수
        int[] answer = {-1,-1};

        // left가 right보다 작을 경우 동안 반복
        while (left < right) {

            // 두개의 포인터 탐색중 절댓값이 더 작은 경우
            // 정답 갱신,  절댓값 변수 갱신
            if (Math.abs(currentValue) < checkValue){
                answer[0] = arr[left];
                answer[1] = arr[right];
                checkValue = Math.abs(currentValue);
            }


            // 현재 값이 0보다 작은 경우 left포인터 오른쪽으로 한 칸 이동
            if (currentValue < 0) {
                currentValue -= arr[left++];
                currentValue += arr[left];

            // 현재 값이 0보다 크거나 같은 경우 right포인터 왼쪽으로 한 칸 이동
            } else{
                currentValue -= arr[right--];
                currentValue += arr[right];
            }
        }

        // 정답 출력
        System.out.println(answer[0] + " " + answer[1]);
    }
}
