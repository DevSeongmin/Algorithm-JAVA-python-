package baekjoon;

/**
 * 작성자 : 황성민
 * 작성일자 : 24.02.13
 * 문제 해결 방식 : N개의 기타줄의 스택을 만들고
 *                스택을 이용하여 기타의 손 움직임 횟수를 카운팅한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ2841_외계인의_기타_연주 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        input = br.readLine().split(" ");

        // 기타줄
        int N = Integer.parseInt(input[0]);
        // 플랫수
        int P = Integer.parseInt(input[1]);

        // 기타줄 만큼 스택을 만든다.
        Stack<Integer>[] guitar = new Stack[N+1];
        for (int i = 0; i < N + 1; i++) {
            guitar[i] = new Stack<>();
        }


        // 손가락 사용 횟수
        int useFingers = 0;
        for (int i = 0; i < N; i++) {

            input = br.readLine().split(" ");

            // 기타줄
            int gLine = Integer.parseInt(input[0]);
            // 플랫 번호
            int plat = Integer.parseInt(input[1]);

            // 만약 기타가 비어있거나 현재 손가락 플랫이 더 높다면 손가락 사용
            if (guitar[gLine].isEmpty() || guitar[gLine].peek() < plat) {
                // 잡은 plat 스택에 넣기
                guitar[gLine].add(plat);
                useFingers++;

            } else {

                // 이번 플랫이 해당 줄의 마지막 보다 작거나 같을 때까지 손가락 때기
                while (!guitar[gLine].isEmpty() && guitar[gLine].peek() > plat){
                    guitar[gLine].pop();
                    // 손가락 수 ++
                    useFingers++;
                }

                // 기다의 줄의 스택이 비어있거나 현재 플랫과 다르다면
                if (guitar[gLine].isEmpty() || guitar[gLine].peek() != plat) {
                    guitar[gLine].add(plat);
                    // 손가락수 ++
                    useFingers++;
                }


            }
        }

        System.out.println(useFingers);
    }
}
