package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 작성자 : 황성민
 * 작성일자 : 24.02.03
 * 사다리 정보가 주어졌을 때 가능한 방식으로
 * 사다리 가로선을 그어서 i번 인덱스의 결과가 i가 되도록
 * 사다리를 조작하는 문제 최대 조작할 수 있는 사다리는 3개이다.
 * 백래킹으로 사다리를 놓는 경우를 탐색하며
 * 문제 해결
 */

public class BOJ_15684_사다리조작 {

    static int line;
    static int edges;
    static int height;
    static ArrayList<int[]> possibleLadders;
    static HashMap<Integer, Integer>[] ladders;
    // 초기 정답 값 무한으로 설정
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");

        //사다리 세로선
        line = Integer.parseInt(tmp[0]);
        // 연결된 가로 수
        edges = Integer.parseInt(tmp[1]);
        // 높이
        height = Integer.parseInt(tmp[2]);


        // 사다리를 둘 수 있는가를 나타내는 배열
        boolean[][] isPossible = new boolean[height + 1][line + 1];

        // 초기에는 모두 true로 선언
        for (boolean[] i : isPossible) {
            Arrays.fill(i, true);
        }

        // 인덱스를 맞추기위해 +1길이로 만들었으므로 맨윗줄 양옆줄은 false;
        for (int i = 0; i < line + 1; i++) {
            isPossible[0][i] = false;
        }

        for (int i = 0; i < height + 1; i++) {
            isPossible[i][0] = false;
            isPossible[i][line] = false;
        }

        // 사다리 정보를 나타내는 해쉬맵 배열 선언
        // 배열의 인덱스는 높이 해쉬맵의 값은 사다리를 타야하는 정보 저장
        // 인덱스 맞추기위해 빈 딕셔너리 하나 추가
        ladders = new HashMap[height + 1];

        for (int i = 0; i < height + 1; i++) {
            ladders[i] = new HashMap<Integer, Integer>();
        }

        // 사다리 정보 입력
        for (int i = 0; i < edges; i++) {
            tmp = br.readLine().split(" ");


            int h = Integer.parseInt(tmp[0]);
            int edge = Integer.parseInt(tmp[1]);

            // h, edge번째에 선을 연결한다.
            ladders[h].put(edge, edge + 1);
            ladders[h].put(edge + 1, edge);

            // 사다리의 선의 위치, 양옆은 설치 불가능
            isPossible[h][edge] = false;
            isPossible[h][edge - 1] = false;
            isPossible[h][edge + 1] = false;
        }


        // 설치 가능한 사다리 리스트
        possibleLadders = new ArrayList<>();
        for (int i = 1; i < height + 1; i++) {
            for (int j = 1; j < line + 1; j++) {
                if (isPossible[i][j]) {
                    possibleLadders.add(new int[]{i, j});
                }
            }
        }


        // 사다리 시뮬레이션 시작
        installLadders(0, new int[]{0, 0}, 0);

        // 3개보다 너 많이 둬야한다거나 불가능 하다면 -1 출력
        if (answer > 3) {
            System.out.println(-1);
        } else {
            // 아니라면 연결 개수 최솟값 출력
            System.out.println(answer);
        }

    }


    // 사다리 시뮬레이션 함수
    static void installLadders(int depth, int[] beforeInstall, int start) {

        // 현재 모두 자기자신으로 떨어지는 사다리라면 정답값 더 작은값으로 업데이트
        if (isAnswer()) {
            answer = Math.min(answer, depth);
            // 0개라면 더 확인할 필요도 없다
            if (answer == 0) {
                System.out.println(answer);
                System.exit(0);
            }
        }

        // 사다리를 3개뒀으면 4개이상 두지 않고 중지
        if (depth == possibleLadders.size() || depth == 3) return;


        for (int i = start; i < possibleLadders.size(); i++) {

            // 설치할 가로선 선택
            int[] select = possibleLadders.get(i);

            //   이전 사다리랑 같은 높이 이면서 일자위치라면 건너 뜀
            if (select[0] == beforeInstall[0] && select[1] == beforeInstall[1] + 1) continue;


            // 사다리 설치 하기 
            ladders[select[0]].put(select[1], select[1] + 1);
            ladders[select[0]].put(select[1] + 1, select[1]);


            // 재귀를 파고들 때 이전 사다리 정보를 넘겨줌
            installLadders(depth + 1, select, i + 1);

            // 설치했던 사다리 돌리기 
            ladders[select[0]].remove(select[1]);
            ladders[select[0]].remove(select[1] + 1);
        }
    }


    //현재 상태에서 사다리 탔을 때 모두 자기 번호로 떨어지는지 확인
    static boolean isAnswer() {


        for (int i = 1; i < line + 1; i++) {
            int arrive = i;
            for (int j = 1; j < height + 1; j++) {
                arrive = ladders[j].getOrDefault(arrive, arrive);

            }
            if (i != arrive) {
                return false;
            }
        }
        return true;
    }

}