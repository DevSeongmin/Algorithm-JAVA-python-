package baekjoon;

/**
 * 작성자 : 황성민
 * 작성일자 24.01.25
 * 풀이법 큰 사각형을 4개로 분할하여
 * 왼쪽위, 오른쪽위, 왼쪽아래, 오른쪽아래
 * 각 좌표로 나눠 어느 좌표인지 구한다
 *
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class BOJ1074_Z {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int answer = 0;


        for (int i = N; i >=0; i-=1){
            // 2의 n승의 / 2 -- > 큰 사각형의  절반 크기
            int divide = (1 << i) / 2;

            if (y < divide){
                //왼쪽 위 일 경우 패스


                // 오른쪽 위 일 경우
                if (x >= divide){
                    x -= divide;
                    // 작은 사각형의 한칸 만큼 정답에 더해줌
                    answer += divide * divide;
                }

            } else if (y >= divide){
                //왼쪽 아래일 경우
                if (x < divide){
                    y -= divide;
                    // 작은 사각형의 2칸만큼 더해줌
                    answer += (divide * divide) * 2;
                    // 오른쪽 아래일 경우
                } else {
                    x-= divide;
                    y-= divide;
                    // 작은 사각형의 3칸만큼 더해줌
                    answer += (divide * divide) * 3;
                }
            }
        }

        // 정답 출력
        System.out.println(answer);

    }
}
