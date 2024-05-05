package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int ant = Integer.parseInt(st.nextToken());
		int stick = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		Ant[] ants = new Ant[ant];
		for (int i = 0; i < ant; i++) {
			st = new StringTokenizer(br.readLine());
			int pos = Integer.parseInt(st.nextToken());
			char dir = st.nextToken().charAt(0);
			// 개미 입력       개미 ID,  개미 위치, 개미 방향
			ants[i] = new Ant(i + 1, pos, dir);
		}

		// 이동후의 좌표를 구하는 반복문
		for (int i = 0; i < ant; i++) {
			Ant cur = ants[i];
			// 왼족 이동 이라면
			if (cur.dir == 'L') {
				cur.pos -= T;
			} else {
				cur.pos += T;
			}

			cur.pos %= 2 * stick;
			if (cur.pos < 0)
				cur.pos += 2 * stick;
			if (cur.pos > stick)
				cur.pos = 2 * stick - cur.pos;
		}

		// 코인을 들고있는 개미 인덱스
		int coin = Integer.parseInt(br.readLine());

		// 개미들 위치(pos) 순으로 정렬
		Arrays.sort(ants);

		// 코인을 들고있는 개미의 인덱스를 찾아 출력
		for (int i = 0; i < ant; i++) {
			if (ants[i].id == coin) {
				System.out.println(i + 1);
				break;
			}
		}

	}

	static class Ant implements Comparable<Ant> {
		int id, pos;
		char dir;

		public Ant(int id, int pos, char dir) {
			this.id = id;
			this.pos = pos;
			this.dir = dir;
		}

		@Override
		public int compareTo(Ant o) {
			return Integer.compare(this.pos, o.pos);
		}

		@Override
		public String toString() {
			return "Ant{" +
				"id=" + id +
				", pos=" + pos +
				", dir=" + dir +
				'}';
		}
	}

}
