package baekjoon;

/**
 * 작성자 : 황성민
 * 작성일자 : 24.01.29
 * N과 M 문제와 비슷한 문제!
 * 재귀를 활용하여 1 2 3의  중복 조합의 상태 공간 트리에서
 * 합이 N이라면 정답에 해당 문자를 넣어주고 return
 * N을 초과하면 return하여 해결
 */

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ12101_1_2_3더하기2 {

    //N 은 1 2 3의 합으로 나타내야 하는 값
    static int N;
    // K는 이렇게 나타내는 수들을 정렬하였을 때 사전순으로 K번째 오는 값
    static int K;

    // 조건에 맞는 문자들을 저장해줄 어레이 리스트 선언
    static ArrayList<String> arr = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        N = input.nextInt();
        K = input.nextInt();

        recursion("", 0);



        // K 가 리스트의 사이즈보다 작거나 같다면 해당 문자 사이에 + 를 더해서 출력
        if (arr.size() >= K) {

            String solve = "" + arr.get(K - 1).charAt(0);

            for (int i = 1; i < arr.get(K - 1).length(); i++) {
                solve += "+" + arr.get(K - 1).charAt(i);
            }
            System.out.println(solve);

        // K 보다 어레이 사이즈가 크거나 K번째 까지 경우가 없다.
        } else {
            System.out.println(-1);
        }
    }

    static void recursion(String answer, int value) {
        if (value > N) {
            return;
        }

        if (value == N) {
            arr.add(answer);
            return;
        }


        // 1 2 3의 합으로 N을 표현하는 경우를 도는 재귀 함수
        for (int i = 1; i <= 3; i++) {

            String before = answer;

            answer = answer + i;
            value += i;
            recursion(answer, value);
            value -= i;
            answer = before;

        }
    }
}


