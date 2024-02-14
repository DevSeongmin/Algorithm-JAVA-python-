package baekjoon;

/**
 * 작성자 : 황성민
 * 작성일자 : 24.02.13
 * 문제 해결 : 앵무새의 말을 중간에 가로첼 수 있다.
 *            그리고 앵무새의 말을 모두 받아적는다.!  이 두 부분이 핵심
 *    앵무새별로 큐를 만들고 단어들이 들어가도록 만드다.
 *    선장의 말의 순서대로 앵무새들의 말을 비교해서 있으면 poll
 *    없다면 Impossible   -> 선장의 말 큐가 빌 때까지
 *    이제 마지막으로 앵무새가 말이 남아있다면 Impossible
 *    마지막까지 안걸렸다면 Possible
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ14713_앵무새 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;


        int N = Integer.parseInt(br.readLine());
        // 앵무새 만큼 큐 배열을 만들어 준다.
        Queue<String>[] parrots = new LinkedList[N];

        for (int i = 0; i < N; i++) {

            // 각각 앵무새의 문장을 단어 단위로 큐에 넣어준다.
            parrots[i] = new LinkedList<>();
            input = br.readLine().split(" ");
            for (int j = 0; j < input.length; j++) {
                parrots[i].add(input[j]);
            }
        }

        // 완전한 문장 큐 입력
        Queue<String> completeSentence = new LinkedList<>();
        input = br.readLine().split(" ");
        for (int i = 0; i < input.length; i++) {
            completeSentence.add(input[i]);
        }

        // 완전한 문장이 모두 빌 때까지
        while (!completeSentence.isEmpty()) {
//            for (Queue<String> parrot : parrots) {
//                System.out.println(parrot);
//            }
//
//            System.out.println(completeSentence);

            // 완전한 문장 맨 앞 단어
            String word = completeSentence.poll();

            // 앵무새의 말이 있는지 확인
            boolean flag = false;

            for (int i = 0; i < N; i++) {
                // 앵무새들의 큐중 만 앞에 선장의 맨 앞 단어가 있다면
                if (!parrots[i].isEmpty() && parrots[i].peek().equals(word)) {

                    flag = true;
                    // 해당 앵무새한테 빼준다.
                    parrots[i].poll();
                    break;
                }
            }

            // 한 사이클을 돌 동안 앵무새에서 뺀적없다면 불가능
            if (!flag){
                System.out.println("Impossible");
                System.exit(0);
            }
        }


        // 앵무새에 말이 남아있다면 불가능
        for (int i = 0; i < N; i++) {
            if (!parrots[i].isEmpty()) {
                System.out.println("Impossible");
                System.exit(0);
            }
        }


        // 위 과정에서 안걸렸다면 가능
        System.out.println("Possible");

    }
}
