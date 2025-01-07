package Programmers;

import java.util.PriorityQueue;

public class Lv3_셔틀버스 {
	class Solution {
		public String solution(int n, int t, int m, String[] timetable) {
			PriorityQueue<String> pq = new PriorityQueue();

			for (String s : timetable) {
				pq.add(s);
			}

			String now = "09:00";

			int cnt = 0;
			String last = "";
			for (int i = 0; i < n; i++) {
				cnt = 0;
				while (!pq.isEmpty() && now.compareTo(pq.peek()) >= 0 && cnt < m) {
					last = pq.poll();
					cnt++;
				}
				now = timeAdd(now, t);
			}

			System.out.println("last : " + last);
			System.out.println("cnt : " + cnt);
			System.out.println("now : " + now);

			if (last.equals("") || cnt < m) {
				return timeMinus(now, t);
			}

			if (cnt == m) {
				return timeMinus(last, 1);
			}

			return "";
		}

		static String timeMinus(String time, int value) {
			String[] hm = time.split(":");

			int hour = Integer.parseInt(hm[0]);
			int minute = Integer.parseInt(hm[1]);

			minute -= value;

			if (minute < 0) {
				minute+=60;
				hour--;
			}

			StringBuilder sb = new StringBuilder();

			if (hour < 10) {
				sb.append("0" + hour);
			} else {
				sb.append(hour);
			}

			sb.append(":");

			if (minute < 10) {
				sb.append("0" + minute);
			} else {
				sb.append(minute);
			}

			return sb.toString();
		}

		static String timeAdd(String time, int value) {
			String[] hm = time.split(":");

			int hour = Integer.parseInt(hm[0]);
			int minute = Integer.parseInt(hm[1]);

			minute += value;

			if (minute >= 60) {
				minute -= 60;
				hour++;
			}

			StringBuilder sb = new StringBuilder();

			if (hour < 10) {
				sb.append("0" + hour);
			} else {
				sb.append(hour);
			}

			sb.append(":");

			if (minute < 10) {
				sb.append("0" + minute);
			} else {
				sb.append(minute);
			}

			return sb.toString();
		}
	}
}
