package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Swea5644_무선충전 {

    static int[] moveX = {0, 0, 1, 0, -1};
    static int[] moveY = {0, -1, 0, 1, 0};

    static User user1;
    static User user2;
    static Bc[] bcs;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            st = new StringTokenizer(br.readLine());

            int moveCnt = Integer.parseInt(st.nextToken());
            int batteryCnt = Integer.parseInt(st.nextToken());

            int[] u1Move = new int[moveCnt];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < moveCnt; i++) {
                u1Move[i] = Integer.parseInt(st.nextToken());
            }

            int[] u2Move = new int[moveCnt];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < moveCnt; i++) {
                u2Move[i] = Integer.parseInt(st.nextToken());
            }


            bcs = new Bc[batteryCnt];
            for (int i = 0; i < batteryCnt; i++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                bcs[i] = new Bc(y, x, r, p);
            }


            user1 = new User(1, 1);
            user2 = new User(10, 10);


            int answer = 0;

            for (int i = 0; i < moveCnt; i++) {

                answer += getMax();
                user1.y += moveY[u1Move[i]];
                user1.x += moveX[u1Move[i]];
                user2.y += moveY[u2Move[i]];
                user2.x += moveX[u2Move[i]];
            }

            answer += getMax();

            sb.append("#" + tc + " " + answer + "\n");
        }

        System.out.println(sb);

    }


    static int getMax(){
        ArrayList<Bc> user1Charges = new ArrayList<>();
        ArrayList<Bc> user2Charges = new ArrayList<>();

        for (Bc bc : bcs) {
            if (bc.isChargePossible(user1.y, user1.x)) {
                user1Charges.add(bc);
            }

            if (bc.isChargePossible(user2.y, user2.x)) {
                user2Charges.add(bc);
            }
        }

        int max = 0;
        // 2번 유저만 충전기 위에 있을 때
        if (user1Charges.isEmpty() && !user2Charges.isEmpty()) {

            for (Bc bc : user2Charges) {
                max = Math.max(max, bc.p);
            }


            // 1번 유저만 충전기 위에 있을 때
        } else if (!user1Charges.isEmpty() && user2Charges.isEmpty()) {

            for (Bc bc : user1Charges) {
                max = Math.max(max, bc.p);
            }

            // 1, 2 둘 다 충전기 위에 있을 때
        } else if (!user1Charges.isEmpty() && !user2Charges.isEmpty()) {

            for (Bc bc1 : user1Charges) {
                for (Bc bc2 : user2Charges) {
                    if (bc1.equals(bc2)) {
                        max = Math.max(max, bc1.p);
                    } else {
                        max = Math.max(bc1.p + bc2.p, max);
                    }
                }
            }

        }
        return max;
    }


    static class Bc{
        int y,x,r,p;

        public Bc(int y, int x, int r, int p) {
            this.y = y;
            this.x = x;
            this.r = r;
            this.p = p;
        }

        public boolean isChargePossible(int y, int x){
            return Math.abs(this.y - y) + Math.abs(this.x - x) <= r;
        }
    }

    static class User {
        int y, x;

        public User(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
