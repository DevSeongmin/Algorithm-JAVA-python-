package baekjoon;

/**
 * 작성자 : 황성민
 * 작성일자 : 24.03.05
 * 문제해결 : 그리디하게 접근한다.
 *
 *          하나의 꽃을 선택했을 때 그 꽃이 피어 있는 기간동안 심을 수 있는
 *          꽃들 중 가장 오래 피어있는 꽃을 선택한다.
 *           이 과정을 반복
 *
 *           편의상 월에는 100을 곱해서 수를 표현
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ2457_공주님의정원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        // 시작 하는 날짜 우선,  시작 날짜가 같다면 끝나는 날짜가 늦게
        PriorityQueue<Flower> flowers = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            int startM = Integer.parseInt(st.nextToken());
            int startD = Integer.parseInt(st.nextToken());
            int endM = Integer.parseInt(st.nextToken());
            int endD = Integer.parseInt(st.nextToken());

            int start = startM * 100 + startD;
            int end = endM * 100 + endD;

            // 3월1일보다 작은 수는 301로            꽃이 지는 날짜가 1131보다 큰경우 1131로
            flowers.add(new Flower(Math.max(start, 301), Math.min(end, 1131)));
        }

        // 가장 빨리 피는 꽃이 3월1일 이후로 핀다면 0출력 후 종료
        if (flowers.peek().start < 301){
            System.out.println(0);
            return;
        }


        int answer = 1;
        int curEnd = 0;

        // 3월 1일에 피는 꽃들중 가장 오래 피어 있는 꽃의 지는 날짜를 기억
        while (!flowers.isEmpty() && flowers.peek().start == 301) {
            curEnd = Math.max(flowers.poll().end, curEnd);
        }


        // 만약 3월 1일에 피는 꽃이 끝까지 피어 있다면
        if (curEnd > 1130){
            // 정답 출력 후 종료
            System.out.println(answer);
            return;
        }

        // 꽃이 빌 때 까지
        while (!flowers.isEmpty()){

            // 하루라도 비는 경우 break;  연속해서 심지 못하는 경우
            if (curEnd < flowers.peek().start) {
                break;
            }


            // 현재 꽃이 피어있는 동안 필 수 있는 꽃들 중 가장 늦게 지는 꽃의 날짜를 기록할 변수
            int next = 0;

            answer++;

            // 현재 꽃이 지기까지 심을 수 있는 꽃들 중 가장 늦게 지는 꽃 찾기
            while(curEnd >= flowers.peek().start){
                next = Math.max(next, flowers.poll().end);

                // 11월 31일까지 필 수 있다면 정답 출력
                if (next == 1131) {
                    System.out.println(answer);
                    return;
                }

                // 11월 31일 전에 꽃을 다 써버린 경우
                if (flowers.isEmpty()) {
                    System.out.println(0);
                    return;
                }
            }

            // 현재 꽃이 지는 날을 고른 꽃이 지는 날짜로 업데이트
            curEnd = next;
        }
        System.out.println(0);





    }
    // comparable 재정의  시작 날짜가 빠른순, 같다면 끝나는 날짜가 느린순
    static class Flower implements Comparable<Flower>{
        int start, end;

        public Flower(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Flower o) {
            if (this.start == o.start) return Integer.compare(o.end, this.end);
            return Integer.compare(this.start, o.start);


        }
    }
}