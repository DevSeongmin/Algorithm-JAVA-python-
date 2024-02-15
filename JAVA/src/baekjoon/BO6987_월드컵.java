package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 작성자 : 황성민
 * 작성일자 : 24.02.14
 * 문제 접근 : 처음에는 승무패의 정보로 바로 가능한 결과인지 계산하려했다.
 *
 * 			1. 모두 합쳤을 때 30판이 아니라면				        X
 * 			2. 무승부의 개수들을 맵에 cnt++하여 담아 짝수가 아니라면 	X
 * 			3. 승 무 패 중 6이 있다면 						        X
 * 			4 전체 승 != 패  라면 							    X
 * 		    5. 한 팀의 경기가 5경기가 되지않는다면                    X
 * 		    6. 한 조의 승 수와 패 수가 다르다면                      X
 * 			등등....
 *
 * 			하지만 결국 풀지 못했다. 사실 지금도 이 문제가 그리디로 풀릴 수 있는지 궁금하다.
 *
 * 그리하여 모든 대진표를 만들고 각각 이겼을 때 비겼을 때 졌을 때 시뮬레이션하여 문제를 해결했다.
 */


public class BO6987_월드컵 {



    static int answer;
    // 한 대진표의 정보
    static int[][] winDrawLose = new int[6][3];
    // 대진표 모든 팀이 경기하는 컴비네이션 조합
    static int[][] comb = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 0, 4 }, { 0, 5 }, { 1, 2 }, { 1, 3 }, { 1, 4 }, { 1, 5 },
            { 2, 3 }, { 2, 4 }, { 2, 5 }, { 3, 4 }, { 3, 5 }, { 4, 5 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 테스트 케이스 4개
        for (int tc = 0; tc < 4; tc++) {

            // 팀 정보 입력
            st = new StringTokenizer(br.readLine());

            // 6개 팀
            for (int i = 0; i < 6; i++) {
                // 승무패 정보
                for (int j = 0; j < 3; j++) {
                    winDrawLose[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 정답 변수 0
            answer = 0;
            // 시뮬레이션 시작
            recursion(0);
            // 정답 스트링 빌더에 어펜드
            sb.append(answer + " ");
        }

        // 정답 출력
        System.out.println(sb);

    }

    static void recursion(int s) {

        // 가능한 대진표인것을 확인했다면 이후는 더 확인하지 않고 return;
        if (answer == 1) return;

        // s가 15라면 모든 대진을 끝낸 경우이다.
        if (s == 15) {

            // 모든 팀의 정보가 0이라면 그것은 가능한 대진표이다.
            boolean flag = true;
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 3; j++) {
                    if (winDrawLose[i][j] != 0) {
                        flag = false;
                    }
                }
            }
            if (flag)
                answer = 1;
            return;

        }

        // 대진표 정보
        // team1 team2
        int team1 = comb[s][0];
        int team2 = comb[s][1];


        // team1  기준

        // 이긴 경우
        if (winDrawLose[team1][0] >= 1 && winDrawLose[team2][2] >= 1) {
            winDrawLose[team1][0]--;
            winDrawLose[team2][2]--;
            recursion(s + 1);
            winDrawLose[team1][0]++;
            winDrawLose[team2][2]++;

        }

        // 비긴 경우
        if (winDrawLose[team1][1] >= 1 && winDrawLose[team2][1] >= 1) {
            winDrawLose[team1][1]--;
            winDrawLose[team2][1]--;
            recursion(s + 1);
            winDrawLose[team1][1]++;
            winDrawLose[team2][1]++;
        }

        // 진 경우
        if (winDrawLose[team1][2] >= 1 && winDrawLose[team2][0] >= 1) {
            winDrawLose[team1][2]--;
            winDrawLose[team2][0]--;
            recursion(s + 1);
            winDrawLose[team1][2]++;
            winDrawLose[team2][0]++;

        }
    }
}

