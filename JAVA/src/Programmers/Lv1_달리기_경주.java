package Programmers;

import java.util.*;

public class Lv1_달리기_경주 {

	class Solution {

		HashMap<String, Integer> playerRankMap = new HashMap();

		HashMap<Integer, String> rankPlayerMap = new HashMap();

		public String[] solution(String[] players, String[] callings) {

			int L = players.length;

			for (int i = 0; i < L; i++) {
				playerRankMap.put(players[i], i);
				rankPlayerMap.put(i, players[i]);
			}

			for (String rushPlayer : callings) {
				changeRank(rushPlayer);
			}

			String[] answer = new String[L];

			for (int i = 0; i < L; i++) {
				answer[i] = rankPlayerMap.get(i);
			}

			return answer;
		}

		public void changeRank(String rushPlayer) {
			int rushPlayerRank = playerRankMap.get(rushPlayer);
			String notRushPlayer = rankPlayerMap.get(rushPlayerRank - 1);

			rankPlayerMap.put(rushPlayerRank - 1, rushPlayer);
			rankPlayerMap.put(rushPlayerRank, notRushPlayer);

			playerRankMap.put(rushPlayer, rushPlayerRank - 1);
			playerRankMap.put(notRushPlayer, rushPlayerRank);
		}
	}
}
