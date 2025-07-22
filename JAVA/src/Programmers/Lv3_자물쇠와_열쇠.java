package Programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class Lv3_자물쇠와_열쇠 {

	class Solution {
		public boolean solution(int[][] key, int[][] lock) {
			int keyN = key.length;
			int lockN = lock.length;

			Key myKey = new Key(keyN);

			for (int i = 0; i < keyN; i++) {
				for (int j = 0; j < keyN; j++) {
					if (key[i][j] == 1) {
						myKey.add(new Pair(i, j));
					}
				}
			}

			return check(myKey, lock);
		}

		static boolean check(Key myKey, int[][] lock) {

			for (int spin = 0; spin < 4; spin++) {
				for (int i = -myKey.n + 1; i < lock.length; i++) {
					for (int j = -myKey.n + 1; j < lock.length; j++) {
						if (canOpen(myKey, i, j, generateTmpLock(lock))) {
							return true;
						}
					}
				}
				myKey.spinClock();
			}


			return false;
		}

		static boolean canOpen(Key myKey, int dy, int dx, int[][] tmpLock) {

			for (Pair p : myKey.arr) {
				int y = p.y + dy;
				int x = p.x + dx;

				if (y < 0) continue;
				if (y >= tmpLock.length) continue;
				if (x < 0) continue;
				if (x >= tmpLock.length) continue;

				tmpLock[y][x]++;
			}

			for (int i = 0; i < tmpLock.length; i++) {
				for (int j = 0; j < tmpLock.length; j++) {
					if (tmpLock[i][j] != 1) return false;
				}
			}

			return true;
		}

		static int[][] generateTmpLock(int[][] lock) {
			int[][] tmp = new int[lock.length][lock.length];

			for (int i = 0; i < lock.length; i++) {
				tmp[i] = Arrays.copyOf(lock[i], lock.length);
			}

			return tmp;
		}
	}

	class Key{
		int n;
		ArrayList<Pair> arr = new ArrayList<>();

		public void add(Pair pair) {
			arr.add(pair);
		}

		public Key(int n){
			this.n = n;
		}

		public void spinClock() {
			for (Pair pair : arr) {
				int y = pair.y;
				int x = pair.x;
				pair.y = x;
				pair.x = n - 1 - y;
			}
		}
	}

	class Pair{
		int y, x;
		public Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
		public Pair(int[] arr) {
			this.y = arr[0];
			this.x = arr[1];
		}
	}
}
