package baekjoon;

/**
 * 작성자 : 황성민
 * 작성일자 : 24.02.14
 * 문제 해결 방식 : 이진탐색을 이용하여 던전을 클리어 할 수 있는 최소 HP를 구한다.
 *                이 문제를 해결하기 위해서는 이진탐색에서 더 나아가
 *                 이진탐색의 상계 하계의 개념도 숙지해야한다.
 *                 관련 내용 : https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=occidere&logNo=221045300639
 *
 * 추가적으로 : 인준이형 같은 경우에는 이진탐색으로 풀지 않았다. 훨씬 빠르다.
 *            문제를 접근할 때 다양한 관점과 순수한 백지 상태로 접근해서 푸는 훈련도 해야겠다고 느껴졌다.
 *
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16434_드래곤_앤_던전 {

    static int[][] rooms;
    static long maxHP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        input = br.readLine().split(" ");

        // 방 개수, 공격력
        int room = Integer.parseInt(input[0]);
        long attack = Long.parseLong(input[1]);
        // 던전 정보 입력
        rooms = new int[room][3];
        for (int i = 0; i < room; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                rooms[i][j] = Integer.parseInt(input[j]);
            }
        }

        // 이진탐색 left값
        long minHP = 1L;
        // right 값
        long fullHP = Long.MAX_VALUE;

        // 정답
        long answer = 0L;

        // 이진탐색
        while (minHP < fullHP) {

            // mid 값
            maxHP = (minHP + fullHP) / 2;

            // 던전을 클리어 할 수 있는가?
            boolean result = isPossible(maxHP, attack);

            // 해당 이진탐색은 하계를 기준으로 잡았다.
            // 즉 클리어 false일 떄 정답을 계속 업데이트 하고
            // 하계값을 찾으면 끝
            // 마지막으로 정답 + 1을 하여 첫 true값을 반환하는 mid값으로 문제 해결

            if (!result) {
                minHP = maxHP + 1;
                answer = maxHP;
            } else {
                fullHP = maxHP;
            }
        }
        System.out.println(maxHP);


    }

    // 해당 HP로 던전을 클리어 할 수 있는지 확인하는 메서드
    static boolean isPossible(long HP, long attack) {
        for (int[] room : rooms) {
            // 몬스터 방인 경우
            if (room[0] == 1) {
                int monsterAttack = room[1];
                int monsterHP = room[2];
                long turn = monsterHP % attack == 0 ? monsterHP / attack - 1 : monsterHP / attack;
                HP -= monsterAttack * turn;
                if (HP <= 0) return false;
            }
            // 포션 방인경우
            else if (room[0] == 2) {
                attack += room[1];
                HP = Math.min(maxHP, HP + room[2]);
            }
        }
        return true;
    }
}
