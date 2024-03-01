package baekjoon;

/**
 * 작성자 : 황성민
 * 작성일자 : 24.02.25
 * 문제 해결 방법 : 각각의 스택을 이용하여 시뮬레이션 한다.
 *                근데 이미 시뮬레이션이 된 돌이 떨어지는 경로를 생각해보면
 *                마지막에 떨궜던 위치 이전에서 다시 시뮬레이션을 진행하면 된다는것을 알 수 있다.
 *                즉, 떨어진 돌의 정보를 스택에 저장해 준다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class BOJ3025_돌던지기 {
    static int X, Y;
    static Stack<Tuple>[] stacks;
    static  char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        // 가로의 개수만큼 스택을 만든다.
        stacks = new Stack[X];
        for (int i = 0; i < X; i++) stacks[i] = new Stack<>();

        // 맵정보 입력
        map = new char[Y][X];
        for (int i = 0; i < Y; i++) {
                map[i] = br.readLine().toCharArray();
        }

        // 떨어뜨릴 돌의 수
        int fallcnt = Integer.parseInt(br.readLine());

        // 돌 떨어뜨리기
        for (int i = 0; i < fallcnt; i++) {
            fall(Integer.parseInt(br.readLine()) -1);
        }


        for (char[] characters : map) {
            for (Character c : characters) {
                sb.append(c);
            }
            sb.append('\n');
        }

        // 정답 출력
        System.out.println(sb);

    }

    // 돌을 떨어뜨리는 메서드
    static void fall(int idx) {
        // 현재 떨어뜨리는 돌의 초기 위치
        int y = 0;
        int x = idx;

        // 스택이 비어있지 않고 해당 경로에 돌이 이미 놓여진 경우동안 pop()
        while (!stacks[idx].isEmpty() && map[stacks[idx].peek().y][stacks[idx].peek().x] == 'O') {
            stacks[idx].pop();
        }

        // 만약 스택에 남아있다면 해당 스택의 y x값이 시뮬진행 위치
        if (!stacks[idx].isEmpty()) {
            Tuple t = stacks[idx].peek();
            y = t.y;
            x = t.x;
        }

        // 현재 위치가 마지막이 아니고 아래가 벽이 아닐 동안 반복
        while (y+1 < Y && map[y+1][x] != 'X') {

            // 아래가 빈칸이면 낙하
            if (map[y + 1][x] == '.') {
                y++;

            // 위 조건이 아니라면 왼쪽으로 아래로 낙하 할 수 있으면 낙하
            } else if (0 <= x-1 && map[y][x - 1] == '.' && map[y + 1][x - 1] == '.') {
                y++;
                x--;
            // 위 조건이 아니라면 오른쪽 아래로 낙하 할 수 있으면 낙하 
            } else if (x + 1 < X && map[y][x + 1] == '.' && map[y + 1][x + 1] == '.') {
                y++;
                x++;
            // 다 안된다면 멈춤
            } else {
                break;
            }

            // 이동하는 경로들 스택에 push
            stacks[idx].push(new Tuple(y, x));
        }

        // 스택의 마지막 남아있는 경로 빼서
        Tuple t = stacks[idx].pop();
        y = t.y;
        x = t.x;
        // 해당 값 O로 갱신
        map[y][x] = 'O';

    }

    static class Tuple{
        int y, x;
        public Tuple(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}

