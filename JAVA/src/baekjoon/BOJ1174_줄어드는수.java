package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 작성자 : 황성민
 * 작성일자 : 24.02.04
 * 비트 마스킹을 이용한 집합 표현
 */

// 비트 마스킹 버전
public class BOJ1174_줄어드는수 {

    static int[] ints;
    static ArrayList<Long> arr;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();

        // 멱집합 (Power Set)을 만들고 해당인덱스를 아래 값으로 매핑하여
        // 줄어드는 수 집합 구현
        ints = new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

        // 정답을 담아둘 어레이 리스트
        arr = new ArrayList<>();


        // 2^10 만큼의 모든 경우의 수를 만든다.

        //  2진수에서 다음 값을 나타낸다.
        // 0000000000 ~~  1111111111
        for (int i = 1; i < (1<<10); i++){
            // 답을 담아둘 sum
            long sum = 0;

            // 10 자리 만큼 탐색한다.
            for (int j = 9; j >= 0; j--){

                // 만약 해당 자리가 비트 1 이라면
                if ((i & (1<<j)) > 0){
                    // 값 추가
                    sum = sum * 10 + ints[9 - j];
                }
            }
            arr.add(sum);
        }

        // 정답 리스트 정렬
        Collections.sort(arr);

        // 해당 인덱스의 값 출력
        if (N > arr.size()) {
            System.out.println(-1);
        } else{
            System.out.println(arr.get(N - 1));
        }

    }
}