package baekjoon;

/**
 * 작성자 : 황성민
 * 작성일자 24.01.30
 * 조건에 맞게 구현하여 문제 해결
 * 0 과 1의 비트값 반전은 ^  대응되는 비트가 서로 다르면 1을 반환함. (비트 XOR 연산) 사용
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1244_스위치_켜고_끄기 {

    static int N;
    static int[] switches;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        String[] tmp = br.readLine().split(" ");

        // 인덱스를 맞추기 위해 0번 인덱스는 없다 생각하고
        // 인덱스 1부터 N까지 담기도록 크기 하나 더 추가해서 선언
        switches = new int[N+1];


        for (int i = 0; i < N; i++) {
            switches[i+1] = Integer.parseInt(tmp[i]);
        }

        // 스위치 조작 횟수
        int play = Integer.parseInt(br.readLine());

        for (int i = 0; i < play; i++) {
            st = new StringTokenizer(br.readLine());


            int gender = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());

            // 남자라면 해당 인덱스를 받아 메서드 실행
            if (gender == 1) {
                man(idx);
            }
            // 여자일 경우 메서드 실행
            else {
                woman(idx);
            }


        }


        for (int c = 1; c <= N; c++) {

            System.out.print(switches[c] + " ");

            // 20비트씩 개행으로 출력하라는 조건
            if (c % 20 == 0) {
                System.out.println();
            }
        }


    }

    // 남자일 경우 해당 인덱스를 포함하여 인덱스의 배수들 반전
    static void man(int idx) {
        for (int i = idx; i <= N; i+=idx) {
            switches[i] ^= 1;
        }
    }

    // 여자일 경우 메서드
    static void woman(int idx) {
        // 현재 인덱스의 왼쪽, 오른쪽 두개의 포인터 선언
        int left = idx-1;
        int right = idx+1;

        // 기준 (가운데) 인덱스 반전
        switches[idx] ^=  1;

        // 왼쪽은 왼쪽으로 한칸씩 오른쪽은 오른쪽으로 한칸씩 이동하며
        // 스위치의 범위 안에서 left와 right 값이 같을 동안 반복
        while( 0 < left && right <= N && switches[left] == switches[right]) {


            // 각각 비트 반전
            switches[left] ^= 1;
            switches[right] ^= 1;

            // 포인터 이동
            left-=1;
            right+=1;

        }
    }
}
