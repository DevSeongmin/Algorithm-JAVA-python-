package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class BOJ_15684_사다리조작 {

    static int line;
    static int edges;
    static int height;
    static ArrayList<int[]> possibleLadders;
    static HashMap<Integer, Integer>[] ladders;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");

        line = Integer.parseInt(tmp[0]);
        edges = Integer.parseInt(tmp[1]);
        height = Integer.parseInt(tmp[2]);


        boolean[][] isPossible = new boolean[height + 1][line + 1];

        for (boolean[] i : isPossible) {
            Arrays.fill(i, true);
        }

        for (int i = 0; i < line+1; i++) {
            isPossible[0][i] = false;
        }


        for (int i = 0; i < height + 1; i++) {
            isPossible[i][0] = false;
            isPossible[i][line] = false;
        }

        // 인덱스 맞추기위해 빈 딕셔너리 하나 추가
        ladders = new HashMap[height + 1];

        for (int i = 0; i < height + 1; i++) {
            ladders[i] = new HashMap<Integer, Integer>();
        }

        for (int i = 0; i < edges; i++) {
            tmp = br.readLine().split(" ");

            int h = Integer.parseInt(tmp[0]);
            int edge = Integer.parseInt(tmp[1]);

            // 가로 선 설치 
            ladders[h].put(edge, edge + 1);
            ladders[h].put(edge + 1, edge);


            isPossible[h][edge] = false;
            isPossible[h][edge-1] = false;
            isPossible[h][edge + 1] = false;
        }


        possibleLadders = new ArrayList<>();

        for (int i = 1; i < height +1 ; i++) {
            for (int j = 1; j < line + 1; j++) {
                if (isPossible[i][j]) {
                    possibleLadders.add(new int[] {i,j});
                }
            }
        }



//        

//        for (int[] i :possibleLadders){
//            System.out.println(Arrays.toString(i));
//        }

        installLadders(0, new int[] {0,0}, 0);

        if (answer > 3){
            System.out.println(-1);
        } else{
            System.out.println(answer);
        }

    }


    static void installLadders(int depth, int[] beforeInstall, int start) {

//        System.out.println(Arrays.toString(ladders));

        if (isAnswer()) {
            answer = Math.min(answer, depth);
            if (answer == 0){
                System.out.println(answer);
                System.exit(0);

            }
        }

        if (depth == possibleLadders.size() || depth == 3) return;




        for (int i = start; i < possibleLadders.size(); i++) {


            // tmp의 첫번째 -->  높이    // 두번째 --> 사다리 연결 라인 
            int[] select = possibleLadders.get(i);


            // 같은 높이                                 이전 사다리랑 일자라면 컨티뉴
            if (select[0] == beforeInstall[0] && select[1] == beforeInstall[1] + 1)  continue;


            // 사다리 설치 하기 
            ladders[select[0]].put(select[1], select[1] + 1);
            ladders[select[0]].put(select[1] + 1, select[1]);


            // 재귀를 파고들 때 이전 사다리 정보를 넘겨줌
//            installLadders(depth + 1, possibleLadders.get(depth), i + 1);
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
            for (int j = 1; j<height+1;j++) {
                arrive = ladders[j].getOrDefault(arrive, arrive);

            }
            if (i != arrive) {
                return false;
            }
        }
        return true;
    }

}