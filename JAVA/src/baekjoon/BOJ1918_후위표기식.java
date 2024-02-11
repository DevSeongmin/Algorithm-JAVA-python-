package baekjoon;
/**
 * 작성자 : 황성민
 * 작성일자 : 24.02.11
 * 문제해결방식 : 스택을 이용하여 후위 표기식으로 바꾼다.
 * 처음에는 감이 잘 잡히지 않아
 * https://woongsios.tistory.com/288
 * 블로그를 참고하였다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class BOJ1918_후위표기식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        String inOper = br.readLine();
        // 연산자를 담아둘 스택
        Stack<Character> operStack = new Stack<>();

        // 연산자의 우선순위를 나타내는 해쉬맵
        HashMap<Character, Integer> priority = new HashMap<>();
        priority.put('+', 0);
        priority.put('-', 0);
        priority.put('*', 1);
        priority.put('/', 1);
        priority.put('(', 2);
        priority.put(')', 2);

        for (int i = 0; i < inOper.length(); i++) {
            Character tmp = inOper.charAt(i);

            // 피 연산자라면 스트링 빌더에 어펜드
            if (!priority.containsKey(tmp)) answer.append(tmp);

            else {
                // 만약 연산자 스택이 비어있다면 추가
                if (operStack.isEmpty()) operStack.add(tmp);


                // 연산자 스택이 비어있지 않다면
                else {
                    // 닫힌 괄호라면
                    if (tmp == ')') {
                        // 열린 괄호가 나올때까지 연산자를 pop하며 answer에 어펜드
                        while(operStack.peek() != '('){
                            answer.append(operStack.pop());
                        }

                        // 열린 괄호 pop()
                        operStack.pop();


                    // 닫힌 괄호가 아니라면
                    } else {
                        // 스택이 비어있지 않고
                        // 스택의 탑이 '('이 아니고
                        // 우선 순위가 높거나 같은 애들을 스트링 빌더에 어펜드
                        while (!operStack.isEmpty() && operStack.peek() != '(' && priority.get(operStack.peek()) >= priority.get(tmp)) {
                            answer.append(operStack.pop());
                        }
                        operStack.add(tmp);
                    }
                }

            }
        }

        // 남아있는 연산자 모두 answer에 어펜드
        while(!operStack.isEmpty()) answer.append(operStack.pop());

        // 정답 출력
        System.out.println(answer);

    }
}
