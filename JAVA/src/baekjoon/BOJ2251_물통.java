package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 작성자 : 황성민
 * 작성일자 : 24.02.17
 * 문제 해결 방식 : 한 물통에서 다른 물통으로 담는 과정은 총 6가지이다. 물통이 3개이기 때문에
 *              이러한 6가지의 액션을 BFS돌려 문제를 해결한다.
 *
 *              저같은 경우에는 파이썬으로 코테를 많이 풀었었고
 *              튜플과 같은 연속적인 값을 가지고 있으며 해쉬가 가능한 자료형이 자바에서는
 *              별도로 지원해주지 않는다.
 *              그렇기에 클래스를 정의하고 equals와 hashcode를 재정의 하여
 *              3개 물통의 상태를 방문처리셋에 담아 방문 체크를 하였다.
 *
 *
 */

public class BOJ2251_물통 {

    // 한물통에서 다른 물통으로 물을 옮기는 상황들을 가지고 있는 배열
    static int[] givers = {0, 0, 1, 1, 2, 2};
    static int[] getters = {1, 2, 0, 2, 0, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        input = br.readLine().split(" ");

        // 물통의 총 용량
        int[] maxWater = new int[3];
        maxWater[0] = Integer.parseInt(input[0]);
        maxWater[1] = Integer.parseInt(input[1]);
        maxWater[2] = Integer.parseInt(input[2]);

        // 현재 물통의 상태 
        int[] curWater = new int[3];
        curWater[0] = 0;
        curWater[1] = 0;
        curWater[2] = maxWater[2];

        // 정답을 담아둘 해쉬 셋
        HashSet<Integer> answer = new HashSet<>();
        answer.add(curWater[2]);

        // 3 물통의 상태로 방문을 체크할 튜플형을 갖는 해쉬셋 선언
        HashSet<Tuple> situations = new HashSet<>();
        situations.add(new Tuple(curWater[0], curWater[1], curWater[2]));

        //bfs를 돌릴 큐 선언
        Queue<int[]> q = new LinkedList<>();
        q.add(curWater);

        // 큐가 빌때까지
        while (!q.isEmpty()) {

            curWater = q.poll();

            // 6가지 동작 수행
            for (int i = 0; i < 6; i++) {
                int[] tmpWater = Arrays.copyOf(curWater, curWater.length);

                int giver = givers[i];
                int getter = getters[i];

                // 주는 물통이 0이면 건너뛴다.
                if (tmpWater[giver] == 0) continue;

                // 주는 물통에서 받는 물통으로 물 이동
                tmpWater[getter] += tmpWater[giver];
                tmpWater[giver] = 0;

                // 만약 받는 물통이 넘쳤다면 넘친만큼 다시 돌려줌
                if (tmpWater[getter] > maxWater[getter]) {
                    tmpWater[giver] = tmpWater[getter] - maxWater[getter];
                    tmpWater[getter] = maxWater[getter];
                }


                Tuple situation = new Tuple(tmpWater[0], tmpWater[1], tmpWater[2]);

                // 현재 물통 상태를 이전에 방문한적 없다면 방문셋에 넣기
                if (!situations.contains(situation)) {
                    q.add(Arrays.copyOf(tmpWater,tmpWater.length));
                    situations.add(situation);

                    // 첫번째 물통이 0이라면 세번째 물통 양 정답셋에 넣기
                    if (tmpWater[0] ==0) answer.add(tmpWater[2]);
                }
            }
        }

        // 정답셋을 어레이리스트로 변환 후 정렬하고 답 출력
        Integer[] output = answer.toArray(new Integer[answer.size()]);
        Arrays.sort(output);

        for (Integer i : output) {
            System.out.print(i + " ");
        }


    }

    // 튜플 클래스 선언
    static class Tuple {
        int[] values = new int[3];

        public Tuple(int a, int b, int c) {
            values[0] = a;
            values[1] = b;
            values[2] = c;
        }


        // equals, hashcode 재정의
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Tuple tuple = (Tuple) o;
            return Arrays.equals(values, tuple.values);
        }


        @Override
        public int hashCode() {
            return Arrays.hashCode(values);
        }
    }
}

