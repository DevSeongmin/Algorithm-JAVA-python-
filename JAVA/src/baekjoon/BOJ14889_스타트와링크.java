package baekjoon;


/**
 * 작성자 : 황성민
 * 작성일자 : 24.02.05
 * 문제해결 방식 : 두팀으로 나눈다.
 * 즉 컴비네이션으로 N C N/2 를 수행하여
 * 뽑힌선수 안뽑힌 선수로 팀을 나누고
 * 경기력 차가 최소가 몇인지 갱신하여 해결한다.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ14889_스타트와링크 {


    static int N;

    // set에 포함되엉 있으면 선택된 선수
    static HashSet<Integer> set = new HashSet();
    static int[][] matrix;
    static int answer = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        matrix = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        recursion(0, 1);
        System.out.println(answer);

    }

    static void recursion(int depth, int s) {

        // 최솟값이 0이라면 더 이상 할 필요가 없다.
        if (answer == 0) {
            return;
        }


        if (depth > 0) {
            // 선택된 팀
            int t1 = 0;
            // 선택되지 않은 팀
            int t2 = 0;

            for (int i = 1; i <= N; i++) {
                // 선택된 팀 점수 계산
                if (set.contains(i)) {
                    for (int j = 1; j <= N; j++) {
                        if (set.contains(j)) t1 += matrix[i][j];
                    }
                    // 선택되지 않은팀 점수 계산
                } else {
                    for (int j = 1; j <= N; j++) {
                        if (!set.contains(j)) t2 += matrix[i][j];
                    }
                }
            }

            // 정답을 두 팀의 차가 더 작은값으로
            answer = Math.min(answer, Math.abs(t1 - t2));
        }

        // 셋에 절반을 뽑았을 때
        if (depth == N / 2) {
            return;
        }

        // combination 구하기
        for (int i = s; i <= N; i++) {
            set.add(i);
            recursion(depth + 1, i + 1);
            set.remove(i);
        }
    }
}
