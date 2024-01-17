/*
작성자 : 황성민
작성일자 : 24.01.17
문제 접근, 풀이 : https://blog.naver.com/steadydeveloper/223325788368
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ27172_수_나누기_게임 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 플레이어들의 숫자들 입력
        int[] nums = new int[N];

        String[] inputStream = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(inputStream[i]);
        }

        // 에라토스테네스의 체를 이용하기위해 N의 최댓값인 1000001 + 1의 길이로 배열 선언
        int[] arr = new int[1000001];

        //마이너스 무한으로 초기화
        Arrays.fill(arr, Integer.MIN_VALUE);

        // 플레이어들의 카드 인덱스는 0으로 초기화
        for (int i : nums) {
            arr[i] = 0;
        }


        // 배열을 돌면서
        for (int i = 1; i < 1000001; i++) {
            // 만약 마이너스 무한이 아니라면(해당 인덱스 숫자의 카드를 갖고있다면)
            if (arr[i] != Integer.MIN_VALUE) {
                // 이 카드의 배수들 체크
                for (int j = i + i; j < 1000001; j += i) {
                    // 만약 배수중에 다른 플레이어가 있다면
                    if (arr[j] != Integer.MIN_VALUE) {
                        // 점수 갱신
                        arr[i] += 1;
                        arr[j] -= 1;
                    }
                }
            }
        }


        // 플레이어들의 인덱스로 접근하여 각 점수 출력
        for (int i : nums) {
            System.out.print(arr[i] + " ");
        }
    }

}
