package Programmers;

import java.util.HashMap;

public class Lv2_방금그곡 {

	class Solution {

		static HashMap<Character, Character> map = new HashMap();

		{
			map.put('C', 'c');
			map.put('D', 'd');
			map.put('E', 'e');
			map.put('F', 'f');
			map.put('G', 'g');
			map.put('A', 'a');
			map.put('B', 'b');
		}

		public String solution(String m, String[] musicinfos) {
			Music answerMusic = null;

			m = majorConvert(m);

			for (String musicInfo : musicinfos) {
				String[] musicArr = musicInfo.split(",");

				int startTime = timeConvert(musicArr[0]);
				int endTime = timeConvert(musicArr[1]);
				String musicName = musicArr[2];
				String melody = majorConvert(musicArr[3]);

				Music music = new Music(startTime, endTime, musicName, melody);

				if (!music.melody.contains(m))
					continue;

				if (answerMusic == null) {
					answerMusic = music;
					continue;
				}

				if (answerMusic.playTime < music.playTime) {
					answerMusic = music;
					continue;
				}
			}
			return answerMusic == null ? "(None)" : answerMusic.name;
		}

		public int timeConvert(String time) {
			String[] tmp = time.split(":");
			int hour = Integer.parseInt(tmp[0]);
			int minuts = Integer.parseInt(tmp[1]);

			return hour * 60 + minuts;
		}

		public String majorConvert(String m) {

			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < m.length() - 1; i++) {
				char c = m.charAt(i);
				char nextC = m.charAt(i + 1);

				if (c == '#') {
					continue;
				}

				if (nextC == '#') {
					sb.append(map.get(c));
				} else {
					sb.append(c);
				}
			}

			char lastChar = m.charAt(m.length() - 1);

			if (lastChar != '#') {
				sb.append(lastChar);
			}
			return sb.toString();
		}
	}

	class Music {
		int startTime;
		int endTime;
		int playTime;
		String name;
		String melody;

		public Music(int startTime, int endTime, String name, String melody) {
			this.startTime = startTime;
			this.endTime = endTime;
			this.playTime = endTime - startTime;
			this.name = name;

			StringBuilder sb = new StringBuilder();
			int cnt = 0;

			while (cnt < playTime) {
				cnt += melody.length();
				sb.append(melody);
			}

			this.melody = sb.toString().substring(0, playTime);
		}
	}
}
