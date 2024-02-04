package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 작성자 : 황성민
 * 작성일자 : 24.02.04
 * 비트 마스킹을 이용한 조합 표현
 *  알파벳의 개수인 26개
 *   즉 0000000000_0000000000_000000  부터
 *      1111111111_111111111_111111 까지의 비트 마스킹을 이용하여 해결
 */

public class BOJ1062_가르침 {

    static int N,M;
    static int[] words;
    static int answer = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        // 기본 적으로 antic 5개는 가르쳐야 하나라도 말할 수 있다.
        if (M < 5){
            System.out.println(0);
            return;
        // 26개를 가르치면 모든 단어를 말할 수 있다.
        } else if(M == 26){
            System.out.println(N);
            return;
        }


        // 5단어를 가르침 기본적으로
        M -= 5;
        int standard = 0;

        standard |= 1 << ('a' - 'a');
        standard |= 1 << ('n' - 'a');
        standard |= 1 << ('t' - 'a');
        standard |= 1 << ('i' - 'a');
        standard |= 1 << ('c' - 'a');



        // 각각의 단어들 입력
        words = new int[N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < line.length(); j++) {
                int index = line.charAt(j) - 'a';
                // or 연산자로 헤당 알파벳 비트를 1로 켜줌
                words[i] |= 1 << index;
            }
        }

        learn(0,0,standard);
        System.out.println(answer);
    }

    static void learn(int depth,int start, int flag){

        // 알파벳을 M개 가르쳤을 때 몇개의 단어를 읽을 수 있는지 카운트
        if (depth == M){

            int result = 0;
            for (int word : words){
                // 만약 그 단어와 현재 읽을 수 있는 상태들을 or연산 했을 때 읽을 수 있는 상태가 나오면
                // 그 단어는 읽을 수 있는 것!
                if ((word | flag) == flag) {
                    result++;
                }
            }
            answer = Math.max(answer, result);
            return;
        }

        for (int i = start; i < 26; i++){
            // 읽지 못하는 알파뱃일 경우 가르치고 재귀 함수 호출
            if ((flag & 1 << i) == 0) {
                // 이번에 가르친 다음 단어부터 가르친다.
                learn(depth + 1, i + 1, flag | 1 << i);
            }
        }
    }
}
