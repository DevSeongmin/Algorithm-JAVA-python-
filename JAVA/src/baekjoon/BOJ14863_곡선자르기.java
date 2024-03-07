package baekjoon;

/**
 * 작성자: 황성민
 * 작성일자 : 24.03.08
 * 문제 해결 방법 : x축으로 잘랐을 때 y값이 음수에서 양수로,  양수에서 음수로 가는 경우는
 *              2개씩 짝지어져 있다.
 *              즉 상승하는 x, 하강하는 x 좌표를 구하고
 *              x값으로 정렬 후에
 *              상승과 하강이 붙어있다면 그것은 아무것도 포함하지 않는 봉우리이며
 *              하강시에 스택이 비어있다면 그것은 다른 봉우리에 둘러싸여있지 않다.
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ14863_곡선자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());


        Node[] nodes = new Node[N];

        // 시작 인덱스 찾기 -- > 음수에서 양수로 가는지점을 시작 인덱스로
        int startIdx = -1;
        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int inputX = Integer.parseInt(st.nextToken());
            int inputY = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(inputX, inputY);

            if (inputX <= x && inputY <= y) {
                x = inputX;
                y = inputY;
                startIdx = i;
            }
        }



        // 상승 하강하는 x좌표 리스트
        ArrayList<xInfo> xInfos = new ArrayList<>();

        int cnt = 0;
        int[] tmp = new int[2];

        for (int i = 1; i < N; i++) {
            Node curNode = nodes[(i + startIdx) % N];
            Node beforeNode = nodes[(i + startIdx - 1) % N];


            // 올라가는 x 지점
            if (beforeNode.y < 0 && curNode.y > 0) {
                tmp[cnt] = curNode.x;
                cnt++;
            }

            // 내려가는 x지점 
            if (beforeNode.y > 0 && curNode.y < 0) {
                tmp[cnt] = curNode.x;
                cnt++;
            }


            // 짝이 지어진 경우
            if (cnt == 2) {
                Arrays.sort(tmp);

                // x값이 작은것이 봉우리의 올라가는곳
                xInfos.add(new xInfo(tmp[0], true));
                // x값이 큰것이 봉우리의 내려가는곳
                xInfos.add(new xInfo(tmp[1], false));
                cnt = 0;
            }
        }
        
        
        // x축 정렬
        Collections.sort(xInfos);

        
        // 아무것도 포함하지 않는 봉우리 세기
        int noContain = 0;
        for (int i = 1; i < xInfos.size(); i++) {
            if (xInfos.get(i - 1).isUp && !xInfos.get(i).isUp) {
                noContain++;
            }
        }

        Stack<String> stack = new Stack<>();

        
        // 다른 봉우리에 포함되지 않는 봉우리 세기
        int noContained = 0;
        for (int i = 0; i < xInfos.size(); i++) {
            if (xInfos.get(i).isUp) {
                stack.push("tmp");
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    noContained++;
                }
            }
        }

        // 정답 출력
        System.out.println(noContained + " " + noContain);


    }

    static class xInfo implements Comparable<xInfo> {
        int x;
        boolean isUp;

        public xInfo(int x, boolean isUp) {
            this.x = x;
            this.isUp = isUp;
        }

        @Override
        public int compareTo(xInfo o) {
            return Integer.compare(this.x, o.x);
        }
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
