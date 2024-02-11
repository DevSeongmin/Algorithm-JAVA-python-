package baekjoon;

/**
 * 작성자 : 황성민
 * 작성일자 : 24.02.11
 * 문제 해결 방식 : Moo 수열은
 * (n-1)번째 moo 수열   +    moo...(o는 n+2)개    +  (n-1)번째 moo 수열로 이루어져있다.
 * 분할 정복을 통해 문제를 해결한다.
 */


import java.util.Scanner;

public class BOJ5904_Moo게임 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 찾고자 하는 n번째 문자
        int N = input.nextInt();

        int moo = 3;
        int k = 0;

        // N번째 문자보다 moo수열의 길이가 작다면
        // N번째 문자 보다 크거나 같아 질때까지 moo수열을 늘리고
        // 몇번째 무수열인지 k에 저장
        while (moo < N){
            k++;
            moo = moo * 2 + k+3;
        }

        // 분할정복 재귀 호출
        recursion(N,moo,k);
    }


    static void recursion(int N, int moo, int k){

        // 첫번째라면 m출력
        if (N == 1){
            System.out.println('m');
            return;
        }

        // N의 값이 (N-1)  moo 수열의 값 보다 작다면
        else if(N < (moo - k - 3)/2 + 1){
            recursion(N, (moo - k - 3)/2, k-1);

            // N값이 moo...(o는 n+2)개 의 첫번째라면
        } else if(N == (moo - k - 3)/2 + 1){
            System.out.println('m');
            return;

            // N값이 moo...(o는 n+2)개 의 첫번째가 아니라면
        } else if(N < moo -  (moo - k - 3)/2 + 1){
            System.out.println('o');
            return;

            //(n-1)번째 moo 수열   +    moo...(o는 n+2)개    +  (n-1)번째 moo
            // N값이 위에서 3번째 (n -1)번째 moo에 있다면
        } else {
            recursion(N - (moo - k - 3)/2 - k - 3, (moo - k - 3)/2, k-1);
        }


    }
}
