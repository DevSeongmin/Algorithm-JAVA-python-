package Programmers;

public class Lv1_바탕화면정리 {

	class Solution {
		public int[] solution(String[] wallpaper) {
			int minY = 51;
			int minX = 51;
			int maxY = 0;
			int maxX = 0;

			int Y = wallpaper.length;
			int X = wallpaper[0].length();


			for (int i = 0; i < Y; i++) {
				for (int j = 0; j < X; j++) {
					if(wallpaper[i].charAt(j) == '.') continue;

					minY = Math.min(minY, i);
					minX = Math.min(minX, j);
					maxY = Math.max(maxY, i);
					maxX = Math.max(maxX, j);
				}
			}


			return new int[] {minY, minX, maxY+1, maxX+1};
		}
	}
}
