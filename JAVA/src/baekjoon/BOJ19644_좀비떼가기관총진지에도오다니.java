package baekjoon;


/**
 * 작성자 : 황성민
 * 작성일자 : 24.02.12
 * 문제 해결 방식 : 큐를 이용하여 좀비의 정보를 나타낸다.
 * 이때 큐에는 좀비의 HP와 해당 좀비가 기관총을 맞을 때 얻는 데미지를 저장해둔다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ19644_좀비떼가기관총진지에도오다니 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;


        // 해당 진지의 거리
        int dist = Integer.parseInt(br.readLine());

        input = br.readLine().split(" ");
        // 기관총의 사거리
        int gunRange = Integer.parseInt(input[0]);
        // 기관총의 데미지
        int gunDamage = Integer.parseInt(input[1]);
        // 지뢰 개수
        int mine = Integer.parseInt(br.readLine());

        // 좀지 정보가 들어있는 큐 [좀비 HP, 좀비가 맞을 데미지]
        Queue<int[]> zombies = new LinkedList<>();

        // 지뢰를 사용한적이 있다면
        ArrayList<Integer> mineUsageInfo = new ArrayList<>();

        // 좀비 정보 저장
        for (int i = 0; i < dist; i++) {
            int hp = Integer.parseInt(br.readLine());
            // 좀비가 맞는 데미지는 좀비의 거리 * 총기 데미지와  총기 사거리 범위 밖일 때는 총기 사거리 안일 때 최대 대미지로
            int damage = Math.min((i + 1) * gunDamage, gunRange * gunDamage);

            zombies.add(new int[]{hp, damage});
        }



        // 좀비 큐가 모두 빌 때 까지
        while (!zombies.isEmpty()) {
            int[] tmp = zombies.peek();
            int zombieHp = tmp[0];
            int attack = tmp[1];


            // 지뢰를 사용한 적이 있다면
            if (!mineUsageInfo.isEmpty()) {

                // 좀비가 받는 대미지를 지뢰 사용 정보를 이용해 줄여줌
                attack -= mineUsageInfo.size() * gunDamage;

                // 지뢰의 첫 정보는 -1
                mineUsageInfo.set(0, mineUsageInfo.get(0) - 1);

                // 지뢰의 첫 정보가 0이라면 지워줌
                if (mineUsageInfo.get(0) == 0) {
                    mineUsageInfo.remove(0);
                }
            }


            // 좀비를 죽일 수 있다면
            if (zombieHp <= attack) {
                zombies.poll();
            }


            // 좀비를 기관총으로 죽일 수 없다면
            else {
                // 수류탄이 있다면
                if (mine > 0) {
                    mine -= 1;
                    zombies.poll();

                    // 수류탄 정보가 없다면
                    if (!mineUsageInfo.isEmpty()) {
                        // 총기 사거리 - 지뢰 정보의 마지막  정보 추가
                        mineUsageInfo.add(gunRange - mineUsageInfo.get(mineUsageInfo.size()-1));
                    } else {
                        // 지뢰 정보 사거리 -1 추가
                        mineUsageInfo.add(gunRange - 1);
                    }


                    // 죽는 경우
                } else {
                    System.out.println("NO");
                    return;
                }


            }
        }
        // 살아 남은 경우
        System.out.println("YES");


    }
}
