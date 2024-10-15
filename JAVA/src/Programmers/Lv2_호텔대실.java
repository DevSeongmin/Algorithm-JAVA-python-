package Programmers;

public class Lv2_호텔대실 {

	class Solution {
		public int solution(String[][] book_time) {

			int answer = 0;
			int[] bookings = new int[2500];

			for (String[] s : book_time) {

				int startTime = convertTime(s[0]);
				int endTime = convertEndTime(s[1]);

				for (int i = startTime; i < endTime; i++) {
					answer = Math.max(answer, ++bookings[i]);
				}
			}
			return answer;
		}

		public int convertTime(String time) {
			return Integer.parseInt(time.split(":")[0]) * 100 + Integer.parseInt(time.split(":")[1]);
		}

		public int convertEndTime(String time) {
			int startTime = Integer.parseInt(time.split(":")[0]);
			int endTime = Integer.parseInt(time.split(":")[1]) + 10;

			if (endTime >= 60) {
				startTime++;
				endTime %= 60;
			}
			return startTime * 100 + endTime;

		}
	}

}
