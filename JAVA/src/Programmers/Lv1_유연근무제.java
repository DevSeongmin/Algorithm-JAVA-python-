package Programmers;

public class Lv1_유연근무제 {


	class Solution {
		public int solution(int[] schedules, int[][] timeLogs, int startDay) {
			int answer = 0;
			int n = schedules.length;

			for (int i = 0; i < n; i++) {
				Time hopeTime = new Time(schedules[i]);
				hopeTime.add10Minuts();

				boolean flag = true;
				for (int today = 0; today < 7; today++) {

					if (isWeekend(startDay, today)) continue;

					if (hopeTime.hourMinutes < (new Time(timeLogs[i][today])).hourMinutes) {
						flag = false;
						break;
					}

				}
				if (flag) answer++;
			}

			return answer;
		}

		boolean isWeekend(int startDay, int today) {
			int check = (startDay + today - 1) % 7 + 1;

			return check % 6 == 0 || check % 7 == 0;
		}
	}

	class Time{
		int hour;
		int minutes;
		int hourMinutes;

		public Time(int number){
			this.hour = number / 100;
			this.minutes = number % 100;
			if (minutes >= 60) {
				minutes -= 60;
				hour++;
			}
			this.hourMinutes = hour * 100 + minutes;
		}

		public void add10Minuts() {
			hourMinutes +=10;
			this.hour = hourMinutes / 100;
			this.minutes = hourMinutes % 100;
			if (this.minutes >= 60) {
				this.minutes -= 60;
				this.hour++;
			}
			this.hourMinutes = this.hour * 100 + this.minutes;
		}
	}
}
