package hsat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Lv3_플레이페어_암호 {

	public class Main {

		static HashMap<Character, Point> map = new HashMap();

		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			String word = br.readLine();
			String key = br.readLine();


			char[][] keyMap = new char[5][5];

			int y = 0;
			int x = 0;

			for (int i  =0; i < key.length(); i++) {
				char c = key.charAt(i);

				if (!map.containsKey(c)) {
					map.put(c, new Point(y, x));
					keyMap[y][x] = c;
					x++;
				}

				if (x == 5) {
					y++;
					x = 0;
				}
			}

			for (int i = 0; i < 26; i++) {
				char c = (char) ('A' + i);
				if (c == 'J') continue;
				if (map.containsKey(c)) continue;

				map.put(c, new Point(y, x));
				keyMap[y][x] = c;
				x++;

				if (x == 5) {
					y++;
					x = 0;
				}
			}

			ArrayList<Character> arr = new ArrayList();
			for (int i = 0; i < word.length(); i++) {
				arr.add(word.charAt(i));
			}

			for (int i = 1; i < arr.size(); i+=2) {
				if (arr.get(i) == arr.get(i-1)) {

					if (arr.get(i) == 'X') {
						arr.add(i, 'Q');
					} else {
						arr.add(i, 'X');
					}
				}
			}

			if (arr.size() % 2 == 1) {
				arr.add('X');
			}

			for (int i = 1; i < arr.size(); i+=2) {
				char firstChar = arr.get(i -1);
				char secondChar = arr.get(i);

				Point firstPoint = map.get(firstChar);
				Point secondPoint = map.get(secondChar);

				if (firstPoint.y == secondPoint.y) {
					System.out.print(keyMap[firstPoint.y][(firstPoint.x+1) % 5]);
					System.out.print(keyMap[secondPoint.y][(secondPoint.x+1) % 5]);
					continue;
				}

				if (firstPoint.x == secondPoint.x) {
					System.out.print(keyMap[(firstPoint.y+1) % 5][firstPoint.x]);
					System.out.print(keyMap[(secondPoint.y+1) % 5][secondPoint.x]);
					continue;
				}

				System.out.print(keyMap[firstPoint.y][secondPoint.x]);
				System.out.print(keyMap[secondPoint.y][firstPoint.x]);
			}
		}

		static class Point{
			int y, x;
			public Point(int y, int x) {
				this.y = y;
				this.x = x;
			}
		}
	}
}
